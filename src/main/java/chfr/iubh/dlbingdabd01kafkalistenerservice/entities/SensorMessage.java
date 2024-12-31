package chfr.iubh.dlbingdabd01kafkalistenerservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
public class SensorMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID messageId;

    @NonNull
    @Column(nullable = false, name = "sensoruuid")
    private UUID uuid;

    @NonNull
    private String sensorName;

    @NonNull
    private Double temperature;

    @JsonIgnore
    private LocalDateTime dateReceived;
}
