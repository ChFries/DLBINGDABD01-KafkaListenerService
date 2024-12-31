package chfr.iubh.dlbingdabd01kafkalistenerservice.util;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TimeService {

    public LocalDateTime getCurrentTime() {
        return LocalDateTime.now();
    }

}
