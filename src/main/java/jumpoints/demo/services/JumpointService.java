package jumpoints.demo.services;

import jumpoints.demo.models.Jumpoint;
import jumpoints.demo.models.responses.JumpointDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JumpointService {
    List<Jumpoint> getAll();

    List<JumpointDTO> convertAll(List<Jumpoint> jumpoints);

    JumpointDTO convertOne(Jumpoint point);

    boolean updateAll(List<Jumpoint> jumpoints);

    boolean add(Jumpoint jumpoint);

    Jumpoint findById(Long id);

    void update(Jumpoint jumpoint);

    boolean delete(Jumpoint jumpoint);

}
