package chfr.iubh.dlbingdabd01kafkalistenerservice.repository;

import chfr.iubh.dlbingdabd01kafkalistenerservice.entities.SensorMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SensorMessageRepository extends JpaRepository<SensorMessage, UUID> {
    SensorMessage findFirstByOrderByDateReceivedDesc();
}
