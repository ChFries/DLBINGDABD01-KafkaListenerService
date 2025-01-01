package chfr.iubh.dlbingdabd01kafkalistenerservice.service;

import chfr.iubh.dlbingdabd01kafkalistenerservice.DTO.SensorTemperatureDTO;
import chfr.iubh.dlbingdabd01kafkalistenerservice.mapper.SensorTemperatureMapper;
import chfr.iubh.dlbingdabd01kafkalistenerservice.repository.SensorMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TemperatureSensorService {

    private final SensorMessageRepository sensorMessageRepository;

    private final SensorTemperatureMapper sensorTemperatureMapper;

    public SensorTemperatureDTO getLatestRecordedTemperature(){
        return sensorTemperatureMapper.fromEntity(sensorMessageRepository.findFirstByOrderByDateReceivedDesc());
    }



}
