package jumpoints.demo.services;

import jumpoints.demo.models.Jumpoint;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JumpointService {
    List<Jumpoint> getAll();

    boolean updateAll(List<Jumpoint> jumpoints);

    boolean add(Jumpoint jumpoint);

    Jumpoint findById(Long id);

    void update(Jumpoint jumpoint);

}
