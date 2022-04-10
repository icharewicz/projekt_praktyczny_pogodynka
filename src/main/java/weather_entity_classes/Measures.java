package weather_entity_classes;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "measures")
public class Measures {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id")
    private WeatherService weatherService;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    private Cities cities;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "measures_id")
    private int measuresId;


    @Column(name = "weather_service_id")
    private int weatherServiceId;

    @Column(name = "temperature")
    private int temperature;

    @Column(name = "humidity")
    private double humidity;

    @Column(name = "city_id")
    private int cityId;

    @Column(name = "date")
    private LocalDate date;

    public Measures() {
    }

    public Measures(WeatherService weatherService, int measuresId, int weatherServiceId, int temperature, double humidity, int cityId, LocalDate date) {
        this.weatherService = weatherService;
        this.measuresId = measuresId;
        this.weatherServiceId = weatherServiceId;
        this.temperature = temperature;
        this.humidity = humidity;
        this.cityId = cityId;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Measures{" +
                "weatherService=" + weatherService +
                ", measuresId=" + measuresId +
                ", weatherServiceId=" + weatherServiceId +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                ", cityId=" + cityId +
                ", date=" + date +
                '}';
    }

    public WeatherService getWeatherService() {
        return weatherService;
    }

    public void setWeatherService(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    public int getMeasuresId() {
        return measuresId;
    }

    public void setMeasuresId(int measuresId) {
        this.measuresId = measuresId;
    }

    public int getWeatherServiceId() {
        return weatherServiceId;
    }

    public void setWeatherServiceId(int weatherServiceId) {
        this.weatherServiceId = weatherServiceId;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Measures measures = (Measures) o;
        return measuresId == measures.measuresId && weatherServiceId == measures.weatherServiceId && temperature == measures.temperature && Double.compare(measures.humidity, humidity) == 0 && cityId == measures.cityId && Objects.equals(weatherService, measures.weatherService) && Objects.equals(date, measures.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(weatherService, measuresId, weatherServiceId, temperature, humidity, cityId, date);
    }
}
