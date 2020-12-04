package jumpoints.demo.controllers;

import jumpoints.demo.models.Jumpoint;
import jumpoints.demo.models.responses.WeatherResponse;
import jumpoints.demo.services.JumpointService;
import jumpoints.demo.services.LocationService;
import jumpoints.demo.services.WeatherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {

    private final JumpointService jumpointService;
    private LocationService locationService;
    private WeatherService weatherService;

    public MainController(JumpointService jumpointService, LocationService locationService, WeatherService weatherService) {
        this.jumpointService = jumpointService;
        this.locationService = locationService;
        this.weatherService = weatherService;
        this.fillDB();
    }

    @CrossOrigin()
    @GetMapping("/jumpoints")
    public List<Jumpoint> getJumpoints() {
        return this.jumpointService.getAll();
    }

    @PostMapping("/jumpoints")
    public ResponseEntity<?> addJumpoint(@ModelAttribute Jumpoint jumpoint) {
        boolean result = this.jumpointService.add(jumpoint);
        if (result) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/jumpoints/{id}")
    public ResponseEntity updateJumpoint(@PathVariable(value = "id") Long jumpointId, @RequestParam String description) {
        Jumpoint jumpoint = this.jumpointService.findById(jumpointId);
        jumpoint.setDescription(description);
        this.jumpointService.update(jumpoint);
//        jumpoint.setDescription(jumpointData.getDescription());
        return new ResponseEntity(jumpoint, HttpStatus.OK);
    }

    private void fillDB() {
        this.jumpointService.add(new Jumpoint("41°24’12.2″N 2°10’26.5″E", "this is first location", "sunny"));
        this.jumpointService.add(new Jumpoint("41°24’12.2″N 2°10’26.5″E", "this is second location", "sunny"));
        this.jumpointService.add(new Jumpoint("41°24’12.2″N 2°10’26.5″E", "this is third location", "sunny"));
    }

}
