package weather_entity_classes;

import javax.persistence.*;

@Entity
@Table(name = "weather_service")
public class WeatherService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "service_id")
    private int serviceId;

    @Column(name = "service_url")
    private String url;

    public WeatherService() {}

    public WeatherService(int serviceId, String url) {
        this.serviceId = serviceId;
        this.url = url;
    }

    @Override
    public String toString() {
        return "WeatherService{" +
                "serviceId=" + serviceId +
                ", url='" + url + '\'' +
                '}';
    }

    public int getId() {
        return serviceId;
    }

    public void setId(int serviceId) { this.serviceId = serviceId;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
