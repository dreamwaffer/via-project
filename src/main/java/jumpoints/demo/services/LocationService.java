package jumpoints.demo.services;

import org.springframework.stereotype.Service;

@Service
public interface LocationService {

    public float getLatitude(String locationGPS);
    public float getLongitude(String locationGPS);
}
