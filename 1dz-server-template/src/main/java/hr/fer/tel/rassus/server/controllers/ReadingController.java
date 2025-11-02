package hr.fer.tel.rassus.server.controllers;

import hr.fer.tel.rassus.server.beans.Reading;
import hr.fer.tel.rassus.server.beans.Sensor;
import hr.fer.tel.rassus.server.dto.reading.ReadingRequest;
import hr.fer.tel.rassus.server.dto.reading.ReadingResponse;
import hr.fer.tel.rassus.server.repositories.ReadingRepository;
import hr.fer.tel.rassus.server.repositories.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import hr.fer.tel.rassus.server.services.ReadingService;
import hr.fer.tel.rassus.server.services.SensorService;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
public class ReadingController {
    private final ReadingService readingService;
    private final SensorService sensorRepository;

    public ReadingController(ReadingService readingService, SensorService sensorRepository) {
        this.readingService = readingService;
        this.sensorRepository = sensorRepository;
    }



    // TODO 4.3  Spremanje očitanja pojedinog senzora
    @PostMapping("/sensors/{sensorId}/readings")
    public ResponseEntity<Void> saveReading(@PathVariable Long sensorId, @RequestBody ReadingRequest request){

        readingService.saveReading(sensorId, request);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }



    // TODO 4.5  Popis očitanja pojedinog senzora
    @GetMapping("/sensors/{sensorId}/readings")
    public ResponseEntity<List<ReadingResponse>> retrieveReadings(@PathVariable Long sensorId){
        List<ReadingResponse> readings = readingService.listReadings(sensorId);
        return ResponseEntity.ok(readings);

    }









}