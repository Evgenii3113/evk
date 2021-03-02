package itmo.prl.evk.service;


import itmo.prl.evk.db.repo.StudentRepo;
import itmo.prl.evk.dto.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

//private StudentRepo studentRepo;
//
//    public StudentService(StudentRepo studentRepo) {
//        this.studentRepo = studentRepo;
//    }

    public Student saveStudent (Student student);

    public void deleteStudent (Integer id);

    public Student findById (Integer id);

    List<Student> findAll();

    }


