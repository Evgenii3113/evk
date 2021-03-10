package itmo.prl.evk.db.repo;


import itmo.prl.evk.db.entity.CoursEntity;
import itmo.prl.evk.db.entity.StudentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursRepo extends CrudRepository<CoursEntity, Integer> {

    CoursEntity findByCoursName (String coursName);

}
