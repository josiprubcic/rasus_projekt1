package hr.fer.tel.rassus.server.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Sensor {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private double latitude, longitude;

    private String ip;
    private int port;


    @OneToMany(mappedBy = "sensor", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Reading> readings = new ArrayList<>();

    public List<Reading> getReadings() {
        return readings;
    }

    public Sensor() {
    }

    public long getId() {
        return id;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getIp() {
        return ip;
    }

    public int getPort() {
        return port;
    }

    public void setId(long id) {
        this.id = id;
    }
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
    public void setPort(int port) {
        this.port = port;
    }
}
