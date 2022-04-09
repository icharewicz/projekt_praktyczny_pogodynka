package weather_entity_classes;

import javax.persistence.*;

@Entity
@Table(name = "weather_service")
public class WeatherService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "service_id")
    private int id;

    @Column(name = "service_url")
    private String url;

    public WeatherService() {}

    public WeatherService(int id, String url) {
        this.id = id;
        this.url = url;
    }

    @Override
    public String toString() {
        return "WeatherService{" +
                "id=" + id +
                ", url='" + url + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
