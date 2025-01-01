package chfr.iubh.dlbingdabd01kafkalistenerservice.DTO;


import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;
@Data
public class SensorTemperatureDTO {

    private UUID uuid;

    private String sensorName;

    private Double temperature;

    private LocalDateTime dateReceived;
}
