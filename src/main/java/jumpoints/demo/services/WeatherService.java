package jumpoints.demo.services;

import jumpoints.demo.models.responses.WeatherResponse;
import org.springframework.stereotype.Service;

@Service
public interface WeatherService {

    public WeatherResponse getWeather(double latitude, double longitude);
}
