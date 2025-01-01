package chfr.iubh.dlbingdabd01kafkalistenerservice.service;

import chfr.iubh.dlbingdabd01kafkalistenerservice.entities.SensorMessage;
import chfr.iubh.dlbingdabd01kafkalistenerservice.repository.SensorMessageRepository;
import chfr.iubh.dlbingdabd01kafkalistenerservice.util.TimeService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SensorMessageStorageService {
    private final SensorMessageRepository sensorMessageRepository;

    private final TimeService timeService;

    @Transactional
    public void setDateReceivedAndSaveMessage(SensorMessage message) {
        message.setDateReceived(timeService.getCurrentTime());
        sensorMessageRepository.save(message);
    }
}
