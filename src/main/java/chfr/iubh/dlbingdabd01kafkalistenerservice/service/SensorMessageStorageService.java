package chfr.iubh.dlbingdabd01kafkalistenerservice.service;

import chfr.iubh.dlbingdabd01kafkalistenerservice.entities.SensorMessage;
import chfr.iubh.dlbingdabd01kafkalistenerservice.repository.SensorMessageRepository;
import chfr.iubh.dlbingdabd01kafkalistenerservice.util.TimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SensorMessageStorageService {
    private final SensorMessageRepository sensorMessageRepository;

    private final TimeService timeService;

    public void setDateReceivedAndSaveMessage(SensorMessage message) {
        message.setDateReceived(timeService.getCurrentTime());
        message.setUuid(UUID.randomUUID());
        sensorMessageRepository.save(message);
    }
}
