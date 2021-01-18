package jumpoints.demo.models.responses;

import jumpoints.demo.models.Jumpoint;

import java.time.Instant;

public class JumpointDTO {
    private Long id;

    private String name;

    private double latitude;

    private double longitude;

    private String description;

    private String weather;

    private String createdAt;

    public JumpointDTO(Long id, String name, double latitude, double longitude, String description, String weather, String createdAt) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.description = description;
        this.weather = weather;
        this.createdAt = createdAt;
    }

    public JumpointDTO() {

    }

    public Long getId() {
        return id;
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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
