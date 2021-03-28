package itmo.prl.evk.db.repo;


import itmo.prl.evk.db.entity.StudentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends CrudRepository<StudentEntity, Integer> {

    StudentEntity findBySurname(String surname);

}
