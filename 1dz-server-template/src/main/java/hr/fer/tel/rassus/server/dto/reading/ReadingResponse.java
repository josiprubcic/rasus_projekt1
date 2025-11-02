package hr.fer.tel.rassus.server.dto.reading;

import hr.fer.tel.rassus.server.beans.Reading;

public class ReadingResponse {
    private Long id;
    private Double temperature;
    private Double pressure;
    private Double humidity;
    private Double co;
    private Double no2;
    private Double so2;

    public ReadingResponse() {

    }

    public ReadingResponse(Long id, Double temperature, Double pressure, Double humidity, Double co, Double no2, Double so2) {
        this.id = id;
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        this.co = co;
        this.no2 = no2;
        this.so2 = so2;
    }

    public ReadingResponse(Reading reading) {
        this.id = reading.getId();
        this.temperature = reading.getTemperature();
        this.pressure = reading.getPressure();
        this.humidity = reading.getHumidity();
        this.co = reading.getCo();
        this.no2 = reading.getNo2();
        this.so2 = reading.getSo2();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getPressure() {
        return pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Double getNo2() {
        return no2;
    }

    public void setNo2(Double no2) {
        this.no2 = no2;
    }

    public Double getCo() {
        return co;
    }

    public void setCo(Double co) {
        this.co = co;
    }

    public Double getSo2() {
        return so2;
    }

    public void setSo2(Double so2) {
        this.so2 = so2;
    }
}
