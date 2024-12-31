package chfr.iubh.dlbingdabd01kafkalistenerservice.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@Profile(value = "producer")
public class KafkaProducerConfig {
}
