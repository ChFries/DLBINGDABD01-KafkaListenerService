package chfr.iubh.dlbingdabd01kafkalistenerservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication(scanBasePackages = {"chfr.iubh"})
@Slf4j
@EnableRedisRepositories
public class Dlbingdabd01KafkaListenerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Dlbingdabd01KafkaListenerServiceApplication.class, args);
    }

}
