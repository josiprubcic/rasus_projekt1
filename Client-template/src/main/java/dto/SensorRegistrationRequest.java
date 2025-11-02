package dto;

public class SensorRegistrationRequest {
    private double latitude;
    private double longitude;
    private String ip;
    private int grpcPort;

    public SensorRegistrationRequest(double latitude, double longitude, String ip, int grpcPort) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.ip = ip;
        this.grpcPort = grpcPort;
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

    public int getGrpcPort() {
        return grpcPort;
    }
}
