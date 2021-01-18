package jumpoints.demo.services;

import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public class DateTimeFormatter {
    public String getDate(Instant instant) {
        LocalDateTime ldt = LocalDateTime.ofInstant(instant, ZoneId.of("Europe/Prague"));
        return String.format("%02d", ldt.getDayOfMonth()) + "." + String.format("%02d", ldt.getMonthValue()) + "." + ldt.getYear();
    }

    public String getDateForCalendar(Instant instant) {
        LocalDateTime ldt = LocalDateTime.ofInstant(instant, ZoneId.of("Europe/Prague"));
        return ldt.getYear() + "-" + String.format("%02d", ldt.getMonthValue()) + "-" + String.format("%02d", ldt.getDayOfMonth());
    }

    public String getTime(Instant instant) {
        LocalDateTime ldt = LocalDateTime.ofInstant(instant, ZoneId.of("Europe/Prague"));
        return ldt.getHour() + ":" + String.format("%02d", ldt.getMinute());
    }

    public LocalDateTime getLocalDateTime(Instant instant) {
        return LocalDateTime.ofInstant(instant, ZoneId.of("Europe/Prague"));
    }
}
