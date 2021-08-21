package dio.innovation.accessPointAPI.repository;

import dio.innovation.accessPointAPI.model.UserCategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCategoryRepository extends JpaRepository<UserCategoryModel, Long> {
}
