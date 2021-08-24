package dio.innovation.accessPointAPI.repository;

import dio.innovation.accessPointAPI.model.LocationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<LocationModel, Long> {
}
