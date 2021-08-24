package dio.innovation.accessPointAPI.repository;

import dio.innovation.accessPointAPI.model.DateTypeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DateTypeRepository extends JpaRepository<DateTypeModel, Long> {
}
