package hr.fer.tel.rassus.server.repositories;

import hr.fer.tel.rassus.server.beans.Reading;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReadingRepository extends JpaRepository<Reading, Long>{
    List<Reading> findBySensor_Id(Long sensorId);
}
