package chfr.iubh.dlbingdabd01kafkalistenerservice.service;

import chfr.iubh.dlbingdabd01kafkalistenerservice.DTO.SensorTemperatureAggregateDTO;
import chfr.iubh.dlbingdabd01kafkalistenerservice.DTO.SensorTemperatureDTO;
import chfr.iubh.dlbingdabd01kafkalistenerservice.entities.SensorMessage;
import chfr.iubh.dlbingdabd01kafkalistenerservice.mapper.SensorTemperatureMapper;
import chfr.iubh.dlbingdabd01kafkalistenerservice.repository.SensorMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class TemperatureSensorService {

    private final SensorMessageRepository sensorMessageRepository;

    private final SensorTemperatureMapper sensorTemperatureMapper;

    @Value("${record.max-retention-minutes}")
    private int maxRetentionMinutes;

    public SensorTemperatureDTO getLatestRecordedTemperature() {
        return sensorTemperatureMapper.fromEntity(StreamSupport.stream(sensorMessageRepository.findAll().spliterator(), false)
                .max(Comparator.comparing(SensorMessage::getDateReceived)).orElseThrow());
    }

    public SensorTemperatureAggregateDTO getAggregateForDefinedTimePeriod() {
        List<SensorMessage> relevantValues = StreamSupport.stream(sensorMessageRepository.findAll().spliterator(), false).filter(
                sensorMessage ->
                        sensorMessage.getDateReceived().isAfter(LocalDateTime.now().minus(Duration.ofMinutes(maxRetentionMinutes)))
        ).toList();

        LocalDateTime earliestRecordedAt = relevantValues.stream().min(Comparator.comparing(SensorMessage::getDateReceived)).orElseThrow().getDateReceived();
        LocalDateTime latestRecordedAt = relevantValues.stream().max(Comparator.comparing(SensorMessage::getDateReceived)).orElseThrow().getDateReceived();
        List<Double> temperatures = relevantValues.stream().map(SensorMessage::getTemperature).toList();
        DoubleSummaryStatistics stats = temperatures.stream().mapToDouble(Double::doubleValue).summaryStatistics();
        Double meanTemperature = stats.getAverage();
        Double highestTemperature = stats.getMax();
        Double lowestTemperature = stats.getMin();

        return SensorTemperatureAggregateDTO.builder()
                .lowestTemperature(lowestTemperature)
                .highestTemperature(highestTemperature)
                .earliestRecordedAt(earliestRecordedAt)
                .latestRecordedAt(latestRecordedAt)
                .meanTemperature(meanTemperature)
                .temperaturesOrderedByRecordedAt(temperatures)
                .build();
    }


}
