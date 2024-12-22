package chfr.iubh.dlbingdabd01kafkalistenerservice.messaging;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
@RequiredArgsConstructor
public class SensorTopicListener {

    private final JsonMapper responseMapper;

    @Value("${kafkaprops.topic-name}")
    private String topicName;

    @Value("${sensorprops.uuid}")
    private UUID sensorUUID;

    @KafkaListener(id = "${kafkaprops.cluster-id}", topics = "${kafkaprops.topic-name}")
    public void listen(String kafkaMessage) {
        try {
            SensorMessage message = responseMapper.readValue(kafkaMessage, SensorMessage.class);
            if (message.getUuid().equals(sensorUUID)) {
                log.info("Listening to {}", message);
            }
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
        }
    }

    @PostConstruct
    private void init() {
        log.info("Initializing kafka topic {}", topicName);
        log.info("Listening for UUID {}", sensorUUID.toString());
    }
}
