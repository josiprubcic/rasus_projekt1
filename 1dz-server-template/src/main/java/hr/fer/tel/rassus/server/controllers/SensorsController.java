package hr.fer.tel.rassus.server.controllers;

import hr.fer.tel.rassus.server.dto.sensor.SensorRequest;
import hr.fer.tel.rassus.server.dto.sensor.SensorResponse;
import hr.fer.tel.rassus.server.services.SensorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/sensors")
public class SensorsController {

    private final SensorService sensorService;

    public SensorsController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    //  TODO 4.1  Registracija
    @PostMapping("")
    public ResponseEntity<SensorResponse> registerSensor(@RequestBody SensorRequest sensorRequest){

        SensorResponse sensorResponse = sensorService.registerSensor(sensorRequest);

        return ResponseEntity.created(URI.create("/sensors/"+sensorResponse.getId())).body(sensorResponse);

    }
    //  TODO 4.4  Popis senzora
    //TODO 4.2  Najbliži susjed
    @GetMapping("/{id}/neighbour")
    public SensorResponse findNearestNeighbour(@PathVariable Long id){
        return sensorService.findNearestNeighbour(id);
    }

    @GetMapping("")
    public ResponseEntity<List<SensorResponse>> getAllSensors(){
        List<SensorResponse> sensors = sensorService.getAllSensors();
        return ResponseEntity.ok(sensors);
    }


}
