package dio.innovation.accessPointAPI.repository;

import dio.innovation.accessPointAPI.model.OccurrenceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OccurrenceRepository extends JpaRepository<OccurrenceModel, Long> {
}
