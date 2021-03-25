package itmo.prl.evk.db.repo;

import itmo.prl.evk.db.entity.CourseAssignment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseAssignmentRepo extends CrudRepository<CourseAssignment, Integer> {

}
