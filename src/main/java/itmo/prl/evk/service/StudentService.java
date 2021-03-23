package itmo.prl.evk.service;


import itmo.prl.evk.db.entity.StudentEntity;
import itmo.prl.evk.db.repo.CourseRepo;
import itmo.prl.evk.db.repo.StudentRepo;
import itmo.prl.evk.dto.Student;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepo studentRepo;
    private final CourseRepo courseRepo;

    public StudentService(StudentRepo studentRepo, CourseRepo courseRepo) {
        this.studentRepo = studentRepo;
        this.courseRepo = courseRepo;
    }



    public StudentEntity saveStudent(Student student) {
        StudentEntity studentEntity = studentRepo.save(createStudentEntity(student));
        return studentEntity;
    }

    public void deleteStudent(Integer id) {
        studentRepo.deleteById(id);
    }

    public Student findBySurname(String surname) {
        StudentEntity studentEntity = studentRepo.findBySurname(surname);
        return createStudent(studentEntity);
    }

    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        Iterable<StudentEntity> studentList = studentRepo.findAll();
        for (StudentEntity studentEntity : studentList) {
            students.add(createStudent(studentEntity));
        }
        return students;
    }

    public List<Student> findByCourse (Integer id) {
        List<Student> students = new ArrayList<>();
        List<StudentEntity> studentEntityList = studentRepo.findByCourse(id);
        for (StudentEntity studentEntity : studentEntityList) {
            students.add(createStudent(studentEntity));
        }
        return students;
    }

    private StudentEntity createStudentEntity(Student student) {
        StudentEntity studentEntity = new StudentEntity();
        return getStudentEntity(studentEntity, student.getId(), student.getName(), student.getSurname(), student.getSecondName(), student.getEmail(), student.getPhone(), student.getCourseId(), student);
    }

    private StudentEntity getStudentEntity(StudentEntity studentEntity, Integer id, String name, String surname, String secondName, String email, String phone, Integer courseId, Student student) {
        studentEntity.setId(id);
        studentEntity.setName(name);
        studentEntity.setSurname(surname);
        studentEntity.setSecondName(secondName);
        studentEntity.setEmail(email);
        studentEntity.setPhone(phone);
        studentEntity.setCourseId(courseId);

        return studentEntity;
    }

    private Student createStudent(StudentEntity studentEntity) {
        Student student = new Student();
        return (Student) getStudentEntity(student, studentEntity.getId(), studentEntity.getName(), studentEntity.getSurname(), studentEntity.getSecondName(), studentEntity.getEmail(), studentEntity.getPhone(), studentEntity.getCourseId(), student);
    }



    }





