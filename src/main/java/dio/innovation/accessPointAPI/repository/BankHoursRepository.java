package dio.innovation.accessPointAPI.repository;

import dio.innovation.accessPointAPI.model.BankHoursModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankHoursRepository extends JpaRepository<BankHoursModel, Long> {
}
