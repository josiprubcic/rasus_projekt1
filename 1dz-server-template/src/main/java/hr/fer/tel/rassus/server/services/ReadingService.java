package hr.fer.tel.rassus.server.services;

import hr.fer.tel.rassus.server.beans.Reading;
import hr.fer.tel.rassus.server.beans.Sensor;
import hr.fer.tel.rassus.server.dto.reading.ReadingRequest;
import hr.fer.tel.rassus.server.dto.reading.ReadingResponse;
import hr.fer.tel.rassus.server.repositories.ReadingRepository;
import hr.fer.tel.rassus.server.repositories.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReadingService{
    @Autowired
    private ReadingRepository readingRepository;

    @Autowired
    private SensorRepository sensorRepository;



    public void saveReading(long sensorId, ReadingRequest reading){
        Sensor sensor = sensorRepository.findById(sensorId).orElse(null);
        if(sensor == null){
            throw new RuntimeException("Sensor with id " + sensorId + " not found");
        }

        Reading newReading = new Reading();

        newReading.setSensor(sensor);
        newReading.setTemperature(reading.getTemperature());
        newReading.setHumidity(reading.getHumidity());
        newReading.setPressure(reading.getPressure());
        newReading.setCo(reading.getCo());
        newReading.setNo2(reading.getNo2());
        newReading.setSo2(reading.getSo2());

        readingRepository.save(newReading);
    }

    public List<ReadingResponse> listReadings(@PathVariable Long sensorId){
        List<Reading> readings = readingRepository.findBySensor_Id(sensorId);


        return readings.stream().map(ReadingResponse::new).collect(Collectors.toList());
    }





}
