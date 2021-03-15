package itmo.prl.evk.db.repo;


import itmo.prl.evk.db.entity.CourseEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends CrudRepository<CourseEntity, Integer> {

    CourseEntity findByCourseName (String courseName);

}
