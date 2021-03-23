package itmo.prl.evk.db.repo;


import itmo.prl.evk.db.entity.CourseEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepo extends CrudRepository<CourseEntity, Integer> {

    CourseEntity findByCourseName (String courseName);

    Optional<CourseEntity> findById (Integer id);




}
