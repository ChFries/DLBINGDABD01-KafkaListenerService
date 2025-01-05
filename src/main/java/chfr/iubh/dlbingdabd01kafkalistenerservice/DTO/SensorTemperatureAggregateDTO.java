package chfr.iubh.dlbingdabd01kafkalistenerservice.DTO;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class SensorTemperatureAggregateDTO {

    private Double meanTemperature;

    private Double highestTemperature;

    private Double lowestTemperature;

    private LocalDateTime earliestRecordedAt;
    private LocalDateTime latestRecordedAt;

    private List<Double> temperaturesOrderedByRecordedAt;
}
