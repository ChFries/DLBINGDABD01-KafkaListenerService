package chfr.iubh.dlbingdabd01kafkalistenerservice.messaging;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import java.util.UUID;

@Component
@Slf4j
@RequiredArgsConstructor
@Profile(value = "publisher")
public class SensorTopicMockPublisher {

    @Value("${kafkaprops.topic-name}")
    private String topicName;

    @Value("${sensorprops.name}")
    private String sensorName;

    @Value("${sensorprops.uuid}")
    private UUID sensorUUID;

    private final KafkaTemplate kafkaTemplate;

    private final JsonMapper responseMapper;


    @PostConstruct
    private void init() {
        log.info("Publishing events for UUID {} on kafka topic {}", sensorUUID.toString(), topicName);
        publishMockTemperatureEvents();
    }

    private void publishMockTemperatureEvents() {
        try {
            Thread.sleep(1000);
            kafkaTemplate.send(topicName, responseMapper.writeValueAsString(SensorMessage.builder()
                            .uuid(sensorUUID)
                            .temperature(Math.random()*100)
                            .sensorName(sensorName)
                            .build())
                    );
            publishMockTemperatureEvents();
        } catch (InterruptedException | JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
