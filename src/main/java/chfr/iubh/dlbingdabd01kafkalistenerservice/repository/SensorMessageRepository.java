package chfr.iubh.dlbingdabd01kafkalistenerservice.repository;

import chfr.iubh.dlbingdabd01kafkalistenerservice.entities.SensorMessage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SensorMessageRepository extends CrudRepository<SensorMessage, UUID> {
}
