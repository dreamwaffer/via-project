package jumpoints.demo.services;

import jumpoints.demo.models.Jumpoint;
import jumpoints.demo.models.responses.WeatherResponse;
import jumpoints.demo.repositories.JumpointRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JumpointServiceImpl implements JumpointService {

    private JumpointRepository jumpointRepository;
    private WeatherService weatherService;
    private LocationService locationService;

    public JumpointServiceImpl(JumpointRepository jumpointRepository, WeatherService weatherService, LocationService locationService) {
        this.jumpointRepository = jumpointRepository;
        this.weatherService = weatherService;
        this.locationService = locationService;
    }

    @Override
    public List<Jumpoint> getAll() {
        List<Jumpoint> jumpoints = jumpointRepository.findAll();
        this.updateAll(jumpoints);
        return jumpoints;
    }

    @Override
    public boolean updateAll(List<Jumpoint> jumpoints) {
        float lat;
        float lon;
        String weather;
        WeatherResponse wr;
        for (Jumpoint point : jumpoints) {
            weather = "";
            lat = this.locationService.getLatitude(point.getLocationGPS());
            lon = this.locationService.getLongitude(point.getLocationGPS());
            wr = this.weatherService.getWeather(lat, lon);
            weather += wr.getMain().getTemp() + " (feels like: " + wr.getMain().getFeels_like() + "), ";
            weather += wr.getWeather().get(0).getMain() + ", ";
            weather += wr.getWeather().get(0).getDescription();
            point.setWeather(weather);
            this.jumpointRepository.save(point);
        }
        return true;
    }

    @Override
    public boolean add(Jumpoint jumpoint) {
        try {
            jumpointRepository.save(jumpoint);
        }catch (IllegalArgumentException e){
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
