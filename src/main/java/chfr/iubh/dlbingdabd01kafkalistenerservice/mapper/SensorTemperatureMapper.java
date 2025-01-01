package chfr.iubh.dlbingdabd01kafkalistenerservice.mapper;

import chfr.iubh.dlbingdabd01kafkalistenerservice.DTO.SensorTemperatureDTO;
import chfr.iubh.dlbingdabd01kafkalistenerservice.entities.SensorMessage;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SensorTemperatureMapper {

    SensorTemperatureDTO fromEntity(SensorMessage sensorMessage);
}
