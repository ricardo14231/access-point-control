package dio.innovation.accessPointAPI.repository;

import dio.innovation.accessPointAPI.model.MovementModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovementRepository extends JpaRepository<MovementModel, MovementModel.IdMovementModel> {
}
