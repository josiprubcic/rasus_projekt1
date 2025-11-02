package hr.fer.tel.rassus.server.dto.sensor;

public class SensorRequest {
    private double latitude;
    private double longitude;
    private String ip;
    private Integer port;

    public SensorRequest(){}

    public SensorRequest(double latitude, Integer port, String ip, double longitude) {
        this.latitude = latitude;
        this.port = port;
        this.ip = ip;
        this.longitude = longitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}
