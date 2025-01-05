package chfr.iubh.dlbingdabd01kafkalistenerservice.service;

import chfr.iubh.dlbingdabd01kafkalistenerservice.DTO.SensorTemperatureDTO;
import chfr.iubh.dlbingdabd01kafkalistenerservice.entities.SensorMessage;
import chfr.iubh.dlbingdabd01kafkalistenerservice.mapper.SensorTemperatureMapper;
import chfr.iubh.dlbingdabd01kafkalistenerservice.repository.SensorMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class TemperatureSensorService {

    private final SensorMessageRepository sensorMessageRepository;

    private final SensorTemperatureMapper sensorTemperatureMapper;

    public SensorTemperatureDTO getLatestRecordedTemperature(){
        return sensorTemperatureMapper.fromEntity(StreamSupport.stream(sensorMessageRepository.findAll().spliterator(), false)
                .max(Comparator.comparing(SensorMessage::getDateReceived)).orElseThrow());
    }



}
