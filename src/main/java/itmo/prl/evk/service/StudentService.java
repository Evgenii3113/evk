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
        StudentEntity student1 = new StudentEntity();
        student1.setId(student.getId());
        student1.setName(student.getName());
        student1.setSurname(student.getSurname());
        student1.setSecondName(student.getSecondName());
        student1.setEmail(student.getEmail());
        student1.setPhone(student.getPhone());
        StudentEntity studentEntity = studentRepo.save(student1);
        return studentEntity;
//        Student student2 = new Student();
//        student2.setId(studentEntity.getId());
//        student2.setName(studentEntity.getName());
//        student2.setSurname(studentEntity.getSurname());
//        student2.setSecondName(studentEntity.getSecondName());
//        student2.setEmail(studentEntity.getEmail());
//        student2.setPhone(studentEntity.getPhone());
        //return studentEntity;
    }

    public void deleteStudent(Integer id) {
        studentRepo.deleteById(id);
    }

    public Student findBySurname(String surname) {
        StudentEntity studentEntity = studentRepo.findBySurname(surname);
        Student student = new Student();
        student.setId(studentEntity.getId());
        student.setName(studentEntity.getName());
        student.setSurname(studentEntity.getSurname());
        student.setSecondName(studentEntity.getSecondName());
        student.setEmail(studentEntity.getEmail());
        student.setPhone(studentEntity.getPhone());
        return student;

    }

    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        Iterable<StudentEntity> studentList = studentRepo.findAll();
        for (StudentEntity studentEntity : studentList) {
            Student student = new Student();
            student.setId(studentEntity.getId());
            student.setName(studentEntity.getName());
            student.setSurname(studentEntity.getSurname());
            student.setSecondName(studentEntity.getSecondName());
            student.setEmail(studentEntity.getEmail());
            student.setPhone(studentEntity.getPhone());
            students.add(student);
        }
        return students;
   }


    //    @Autowired
//    private StudentRepo studentRepo;
//
//
//
//    public Iterable<StudentEntity> findAll() {
//        return studentRepo.findAll();
    }

//
//    public void saveStudent(Student student) {
//        studentRepo.save(student);
//    }
//
//    public StudentEntity getStudent(Integer id) {
//        return studentRepo.findById(id).get();
//    }
//
//    public void deleteStudent(Integer id) {
//        studentRepo.deleteById(id);
//    }




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



