package weather_entity_classes;

import javax.persistence.*;

@Entity
@Table(name = "cities")
public class Cities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "city_id") // to samo co private int id czyli sql = java
    private int cityId;

    @Column(name = "city")
    private String city;

    public Cities() {
    }

    public Cities(int cityId, String city) {
        this.cityId = cityId;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Cities{" +
                "cityId=" + cityId +
                ", city='" + city + '\'' +
                '}';
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

