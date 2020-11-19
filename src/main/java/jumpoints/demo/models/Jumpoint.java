package jumpoints.demo.models;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "jumpoints")
public class Jumpoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String locationGPS;

    private String description;

    private String weather;

    private Instant date;

    public Jumpoint(String locationGPS, String description, String weather) {
        this.locationGPS = locationGPS;
        this.description = description;
        this.weather = weather;
        this.date = Instant.now();
    }

    public Jumpoint(String locationGPS, String description) {
        this.locationGPS = locationGPS;
        this.description = description;;
        this.date = Instant.now();
    }

    public Jumpoint() {
        this.date = Instant.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocationGPS() {
        return locationGPS;
    }

    public void setLocationGPS(String locationGPS) {
        this.locationGPS = locationGPS;
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

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }
}

