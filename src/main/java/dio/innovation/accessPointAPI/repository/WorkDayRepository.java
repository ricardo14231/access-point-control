package dio.innovation.accessPointAPI.repository;

import dio.innovation.accessPointAPI.model.WorkDayModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkDayRepository extends JpaRepository<WorkDayModel, Long> {
}
