package dto;

public class ReadingRequest {
    private long sensorId;
    private double temperature;
    private double pressure;
    private double humidity;
    private double co;
    private double no2;
    private double so2;

    private ReadingRequest(long sensorId, double[] reading){
        this.sensorId = sensorId;
        this.temperature = reading[0];
        this.pressure = reading[1];
        this.humidity = reading[2];
        this.co = reading[3];
        this.no2 = reading[4];
        this.so2 = reading[5];
    }

    public long getSensorId() {
        return sensorId;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getPressure() {
        return pressure;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getCo() {
        return co;
    }

    public double getNo2() {
        return no2;
    }

    public double getSo2() {
        return so2;
    }
}
