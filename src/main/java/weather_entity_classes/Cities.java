package weather_entity_classes;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "cities")
public class Cities {

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cities", orphanRemoval = true)
    private Set<AvgMeasure> avgMeasureSet = new HashSet<>();

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cities)) return false;
        Cities cities = (Cities) o;
        return getCityId() == cities.getCityId() && Objects.equals(avgMeasureSet, cities.avgMeasureSet) && Objects.equals(getCity(), cities.getCity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(avgMeasureSet, getCityId(), getCity());
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

