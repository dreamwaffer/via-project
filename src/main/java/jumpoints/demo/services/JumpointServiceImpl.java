package jumpoints.demo.services;

import jumpoints.demo.models.Jumpoint;
import jumpoints.demo.models.responses.JumpointDTO;
import jumpoints.demo.models.responses.WeatherResponse;
import jumpoints.demo.repositories.JumpointRepository;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class JumpointServiceImpl implements JumpointService {

    private final JumpointRepository jumpointRepository;
    private final WeatherService weatherService;
    private final LocationService locationService;
    private final DateTimeFormatter dateTimeFormatter;

    public JumpointServiceImpl(JumpointRepository jumpointRepository, WeatherService weatherService, LocationService locationService, DateTimeFormatter dateTimeFormatter) {
        this.jumpointRepository = jumpointRepository;
        this.weatherService = weatherService;
        this.locationService = locationService;
        this.dateTimeFormatter = dateTimeFormatter;
    }

    @Override
    public List<Jumpoint> getAll() {
        List<Jumpoint> jumpoints = jumpointRepository.findAllByOrderByIdAsc();
        this.updateAll(jumpoints);
        return jumpoints;
    }

    @Override
    public List<JumpointDTO> convertAll(List<Jumpoint> jumpoints) {
        List<JumpointDTO> result = new ArrayList<>();
        for (Jumpoint point : jumpoints) {
            result.add(this.convertOne(point));
        }
        return result;
    }

    @Override
    public JumpointDTO convertOne(Jumpoint point) {
        JumpointDTO pointDTO = new JumpointDTO();
        pointDTO.setName(point.getName());
        pointDTO.setId(point.getId());
        pointDTO.setLocationGPS(point.getLocationGPS());
        pointDTO.setDescription(point.getDescription());
        pointDTO.setWeather(point.getWeather());
        pointDTO.setCreatedAt(this.dateTimeFormatter.getDate(point.getCreatedAt()));
        return pointDTO;
    }

    @Override
    public boolean updateAll(List<Jumpoint> jumpoints) {
        float lat;
        float lon;
        String weather;
        WeatherResponse wr;

        for (Jumpoint point : jumpoints) {
            if (point.getUpdateDate() == null || Duration.between(point.getUpdateDate(), Instant.now()).toMinutes() > 120) {
                weather = "";
                lat = this.locationService.getLatitude(point.getLocationGPS());
                lon = this.locationService.getLongitude(point.getLocationGPS());
                wr = this.weatherService.getWeather(lat, lon);
//                wr = this.weatherService.getWeather(lat, lon);
                weather += wr.getMain().getTemp() + " (feels like: " + wr.getMain().getFeels_like() + "), ";
                weather += wr.getWeather().get(0).getMain() + ", ";
                weather += wr.getWeather().get(0).getDescription();
                point.setWeather(weather);
                point.setUpdateDate(Instant.now());
                this.jumpointRepository.save(point);
            }
        }
        return true;
    }

    @Override
    public boolean add(Jumpoint jumpoint) {
        try {
            jumpointRepository.save(jumpoint);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    @Override
    public Jumpoint findById(Long id) {
        return this.jumpointRepository.findById(id).get();
    }

    @Override
    public void update(Jumpoint jumpoint) {
        this.jumpointRepository.save(jumpoint);
    }
}
