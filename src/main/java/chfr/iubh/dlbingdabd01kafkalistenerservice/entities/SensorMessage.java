package chfr.iubh.dlbingdabd01kafkalistenerservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDateTime;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@RedisHash
public class SensorMessage {
    @Id
    private UUID messageId;

    @NonNull
    private UUID uuid;

    @NonNull
    private String sensorName;

    @NonNull
    private Double temperature;

    @JsonIgnore
    private LocalDateTime dateReceived;
}
