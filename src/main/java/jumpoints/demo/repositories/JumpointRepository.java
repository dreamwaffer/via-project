package jumpoints.demo.repositories;

import jumpoints.demo.models.Jumpoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JumpointRepository extends JpaRepository<Jumpoint, Long> {
    public List<Jumpoint> findAllByOrderByIdAsc();
}