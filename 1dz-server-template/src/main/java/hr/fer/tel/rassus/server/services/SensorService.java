package hr.fer.tel.rassus.server.services;

import hr.fer.tel.rassus.server.beans.Sensor;
import hr.fer.tel.rassus.server.repositories.SensorRepository;
import hr.fer.tel.rassus.server.dto.sensor.SensorResponse;
import hr.fer.tel.rassus.server.dto.sensor.SensorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SensorService {

    @Autowired
    private SensorRepository sensorRepository;


    public SensorResponse registerSensor(SensorRequest  request){
        Sensor sensor = new Sensor();
        sensor.setLatitude(request.getLatitude());
        sensor.setLongitude(request.getLongitude());
        sensor.setIp(request.getIp());
        sensor.setPort(request.getPort());


        Sensor saved = sensorRepository.save(sensor);


        return new SensorResponse(saved);


    }

    public List<SensorResponse> getAllSensors(){
        List<SensorResponse> sensors = sensorRepository.findAll().stream().map(SensorResponse::new).collect(Collectors.toList());

    }

    public SensorResponse findNearestNeighbour(Long sensorId){
        Sensor sensor = sensorRepository.findById(sensorId).orElse(null);
        if (sensor == null) return null;

        List<Sensor> allSensors = sensorRepository.findAll();
        Sensor nearestNeighbour = null;
        double minDistance = Double.MAX_VALUE;

        for (Sensor otherSensor : allSensors) {
            if (otherSensor.getId() != sensorId) {
                double distance = calculateHaversine( sensor.getLatitude(), sensor.getLongitude(),
                        otherSensor.getLatitude(), otherSensor.getLongitude());
                if (distance < minDistance) {minDistance = distance;
                nearestNeighbour = otherSensor;}
            }
        }
        return  new SensorResponse(nearestNeighbour);
    }

    private double calculateHaversine(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371;
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLon/2) * Math.sin(dLon/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        return R * c;
    }
}
