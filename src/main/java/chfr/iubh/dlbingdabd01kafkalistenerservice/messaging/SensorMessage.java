package chfr.iubh.dlbingdabd01kafkalistenerservice.messaging;

import lombok.*;

import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class SensorMessage {
    private UUID uuid;
    private String sensorName;
    private Double temperature;
}
