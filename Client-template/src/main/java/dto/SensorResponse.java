package dto;

public class SensorResponse {
    private long sensorId;
    private double latitude;
    private double longitude;
    private int grpcPort;

    public long getSensorId() {
        return sensorId;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public int getGrpcPort() {
        return grpcPort;
    }

    public void setSensorId(long sensorId) {
        this.sensorId = sensorId;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setGrpcPort(int grpcPort) {
        this.grpcPort = grpcPort;
    }
}
