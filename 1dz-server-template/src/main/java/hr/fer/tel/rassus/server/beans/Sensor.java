package hr.fer.tel.rassus.server.beans;

public class Sensor {
  private final long id;
  private final double temperature, pressure, humidity, co, no2, so2;

    public Sensor(long id, double temperature, double pressure, double humidity, double co, double no2, double so2) {
        this.id = id;
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        this.co = co;
        this.no2 = no2;
        this.so2 = so2;
    }

    public long getId() {
        return id;
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
