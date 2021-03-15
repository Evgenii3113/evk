package itmo.prl.evk.service;


import itmo.prl.evk.db.entity.StudentEntity;
import itmo.prl.evk.db.repo.StudentRepo;
import itmo.prl.evk.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
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

    private StudentEntity createStudentEntity(Student student) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(student.getId());
        studentEntity.setName(student.getName());
        studentEntity.setSurname(student.getSurname());
        studentEntity.setSecondName(student.getSecondName());
        studentEntity.setEmail(student.getEmail());
        studentEntity.setPhone(student.getPhone());
        studentEntity.setCoursId(student.getCoursId());
        return studentEntity;
    }

    private Student createStudent(StudentEntity studentEntity) {
        Student student = new Student();
        student.setId(studentEntity.getId());
        student.setName(studentEntity.getName());
        student.setSurname(studentEntity.getSurname());
        student.setSecondName(studentEntity.getSecondName());
        student.setEmail(studentEntity.getEmail());
        student.setPhone(studentEntity.getPhone());
        student.setCoursId(studentEntity.getCoursId());
        return student;
    }
}



