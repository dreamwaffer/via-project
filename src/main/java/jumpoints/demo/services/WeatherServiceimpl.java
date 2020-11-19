package jumpoints.demo.services;

import jumpoints.demo.models.responses.WeatherResponse;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class WeatherServiceimpl implements WeatherService {

    private final WebClient webClient;

    public WeatherServiceimpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("api.openweathermap.org").build();
    }

    @Override
    public WeatherResponse getWeather(float latitude, float longitude) {
        return restCall(latitude, longitude);
    }

    public WeatherResponse restCall(float latitude, float longitude) {
        String url = "/data/2.5/weather?lat=" + latitude + "&lon=" + longitude + "&units=metric&appid=" + "61f0e87cc61cc61ac75f6aeab999e8e4";
        WeatherResponse responseJson = webClient.get()
                .uri(url)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(WeatherResponse.class)
                .block();

        return responseJson;
    }
}
