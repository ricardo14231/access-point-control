package dio.innovation.accessPointAPI.repository;

import dio.innovation.accessPointAPI.model.AccessLevelModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessLevelRepository extends JpaRepository<AccessLevelModel, Long> {
}
