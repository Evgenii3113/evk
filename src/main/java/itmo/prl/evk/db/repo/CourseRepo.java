package itmo.prl.evk.db.repo;


import itmo.prl.evk.db.entity.CourseEntity;
import itmo.prl.evk.db.entity.StudentEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepo extends CrudRepository<CourseEntity, Integer> {

    CourseEntity findByCourseName (String courseName);



}
