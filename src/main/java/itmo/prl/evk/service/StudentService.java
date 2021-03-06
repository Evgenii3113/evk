package itmo.prl.evk.service;


import itmo.prl.evk.db.entity.StudentEntity;
import itmo.prl.evk.db.repo.StudentRepo;
import itmo.prl.evk.dto.Student;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Data
@RequiredArgsConstructor
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;



       public Iterable<StudentEntity> listAll(){
        return studentRepo.findAll();
    }

    public void saveStudent(Student student) {
        studentRepo.save(student);
    }

    public StudentEntity getStudent(Integer id) {
        return studentRepo.findById(id).get();
    }

    public void deleteStudent(Integer id) {
        studentRepo.deleteById(id);
    }




//    private StudentRepo studentRepo;
//
//    public Optional<StudentEntity> getStudent(Integer id) {
//        return studentRepo.findById(id);
//    }
//
//    public Iterable<StudentEntity> getAll() {
//        return studentRepo.findAll();
//    }
//
//    public void saveStudent(StudentEntity studentEntity) {
//        studentRepo.save(studentEntity);
//
//    }
//
//    public void deleteStudent(Integer id) {
//        studentRepo.deleteById(id);
//
//    }
//
//    public Boolean exist(Example<? extends StudentEntity> example) {
//        return studentRepo.existsById(13);
//    }
}


