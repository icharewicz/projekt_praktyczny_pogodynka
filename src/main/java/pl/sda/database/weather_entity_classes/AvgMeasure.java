package pl.sda.database.weather_entity_classes;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "avg_measure")
public class AvgMeasure {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    private Cities cities;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "avg_measure_id ")
    private int avgMeasureId;

//    @Column(name = "city_id")
//    private int cityId;

    @Column(name = "date")
    private LocalDate date; // ??

    @Column(name = "avg_tem")
    private double avgTemp;

    @Column(name = "avg_hum")
    private double avgHum;

    public AvgMeasure() {
    }

    public AvgMeasure(int avgMeasureId, int cityId, LocalDate date, double avgTemp, double avgHum) {
        this.avgMeasureId = avgMeasureId;
        //this.cityId = cityId;
        this.date = date;
        this.avgTemp = avgTemp;
        this.avgHum = avgHum;
    }

    @Override
    public String toString() {
        return "AvgMeasure{" +
                "avgMeasureId=" + avgMeasureId +
                //", cityId=" + cityId +
                ", date=" + date +
                ", avgTemp=" + avgTemp +
                ", avgHum=" + avgHum +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AvgMeasure)) return false;
        AvgMeasure that = (AvgMeasure) o;
        return getAvgMeasureId() == that.getAvgMeasureId() && Double.compare(that.getAvgTemp(), getAvgTemp()) == 0 && Double.compare(that.getAvgHum(), getAvgHum()) == 0 && Objects.equals(cities, that.cities) && Objects.equals(getDate(), that.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(cities, getAvgMeasureId(), getDate(), getAvgTemp(), getAvgHum());
    }

    public int getAvgMeasureId() {
        return avgMeasureId;
    }

    public void setAvgMeasureId(int avgMeasureId) {
        this.avgMeasureId = avgMeasureId;
    }

//    public int getCityId() {
//        return cityId;
//    }
//
//    public void setCityId(int cityId) {
//        this.cityId = cityId;
//    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getAvgTemp() {
        return avgTemp;
    }

    public void setAvgTemp(double avgTemp) {
        this.avgTemp = avgTemp;
    }

    public double getAvgHum() {
        return avgHum;
    }

    public void setAvgHum(double avgHum) {
        this.avgHum = avgHum;
    }
}
