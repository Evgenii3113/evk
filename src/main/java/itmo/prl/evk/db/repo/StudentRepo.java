package itmo.prl.evk.db.repo;


import itmo.prl.evk.db.entity.CourseEntity;
import itmo.prl.evk.db.entity.StudentEntity;
import itmo.prl.evk.dto.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends CrudRepository<StudentEntity, Integer> {

    StudentEntity findBySurname (String surname);

    @Query("select s from StudentEntity s join CourseEntity c on s.curs_id = c.id")
    List<StudentEntity> findByCourse(Integer id);

}
