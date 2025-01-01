package chfr.iubh.dlbingdabd01kafkalistenerservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = {"chfr.iubh"})
@Slf4j
@EnableTransactionManagement
public class Dlbingdabd01KafkaListenerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Dlbingdabd01KafkaListenerServiceApplication.class, args);
    }

}
