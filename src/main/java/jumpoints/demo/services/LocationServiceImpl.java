package jumpoints.demo.services;

import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService{

    @Override
    public float getLatitude(String locationGPS) {
        String latitude = locationGPS.split(" ")[0];
        String[] parts = latitude.split("[°|'|\"|’|″]");
        float result = Float.parseFloat(parts[0])+Float.parseFloat(parts[1])/60+Float.parseFloat(parts[2])/3600;
        System.out.println(result);
        return result;
    }

    @Override
    public float getLongitude(String locationGPS) {
        String longitude = locationGPS.split(" ")[1];
        String[] parts = longitude.split("[°|'|\"|’|″]");
        float result = Float.parseFloat(parts[0])+Float.parseFloat(parts[1])/60+Float.parseFloat(parts[2])/3600;
        System.out.println(result);
        return result;
    }
}
