package jumpoints.demo.models;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "jumpoints")
public class Jumpoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double latitude;

    private double longitude;

    private String description;

    private String weather;

    private Instant createdAt;

    private Instant updateDate;

    public Jumpoint(String name, double latitude, double longitude, String description, String weather) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.description = description;
        this.weather = weather;
        this.createdAt = Instant.now();
        this.updateDate = null;
    }

    public Jumpoint(String name, double latitude, double longitude, String description) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.description = description;
        this.createdAt = Instant.now();
        this.updateDate = null;
    }

    public Jumpoint() {
        this.createdAt = Instant.now();
        this.updateDate = null;
    }

    public Instant getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Instant updateDate) {
        this.updateDate = updateDate;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant date) {
        this.createdAt = date;
    }
}

