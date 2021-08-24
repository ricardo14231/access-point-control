package dio.innovation.accessPointAPI.repository;

import dio.innovation.accessPointAPI.model.CalendarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalendarRepository extends JpaRepository<CalendarModel, Long> {
}
