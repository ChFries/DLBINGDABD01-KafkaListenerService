package chfr.iubh.dlbingdabd01kafkalistenerservice.controller;

import chfr.iubh.dlbingdabd01kafkalistenerservice.DTO.SensorTemperatureDTO;
import chfr.iubh.dlbingdabd01kafkalistenerservice.service.TemperatureSensorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TemperatureSensorAPI {

    private final TemperatureSensorService temperatureSensorService;

    @GetMapping("/")
    public ResponseEntity<SensorTemperatureDTO> getCurrentTemperature() {
        SensorTemperatureDTO sensorTemperatureDTO = temperatureSensorService.getLatestRecordedTemperature();
        return ResponseEntity.ok(sensorTemperatureDTO);
    }
}
