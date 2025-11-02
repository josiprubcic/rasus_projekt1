package hr.fer.tel.rassus.server.dto.sensor;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import hr.fer.tel.rassus.server.beans.Sensor;

@JsonPropertyOrder({"id", "latitude", "longitude", "ip", "port"})
public class SensorResponse {
    private long id;
    private double longitude;
    private double latitude;
    private String ip;
    private Integer port;

    public SensorResponse() {}

    public SensorResponse(long id, double latitude, double longitude, String ip, Integer port) {
        this.id = id;
        this.longitude = longitude;
        this.port = port;
        this.ip = ip;
        this.latitude = latitude;
    }

    public SensorResponse(Sensor sensor){
        this.id = sensor.getId();
        this.longitude = sensor.getLongitude();
        this.port = sensor.getPort();
        this.ip = sensor.getIp();
        this.latitude = sensor.getLatitude();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
