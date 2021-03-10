package itmo.prl.evk.web;


import itmo.prl.evk.db.entity.StudentEntity;
import itmo.prl.evk.dto.Student;
import itmo.prl.evk.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

private  final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @PostMapping("/newStudents")
   public StudentEntity saveStd (@RequestBody Student student) {
       return studentService.saveStudent(student);
   }

    @GetMapping("/allStudents")
    public List<Student> findAllStd(){
        return studentService.findAll();
    }


   @GetMapping("/findStudent")
   public Student readStd (@RequestParam String surname) {
        return studentService.findBySurname(surname);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteStd (@PathVariable Integer id){
        studentService.deleteStudent(id);
        return (ResponseEntity<Void>) ResponseEntity.ok();
    }




}
