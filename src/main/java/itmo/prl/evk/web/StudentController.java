package itmo.prl.evk.web;


import itmo.prl.evk.db.entity.StudentEntity;
import itmo.prl.evk.dto.Student;
import itmo.prl.evk.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class StudentController {


    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public Iterable<StudentEntity> allStudents (Model model){
        Iterable<StudentEntity> studentList = studentService.listAll();
        model.addAttribute("students", studentList);
        return studentList;
    }


    @PostMapping("/new")
    public String createStudent (Student student) {
        studentService.saveStudent(student);
        return "redirect:/index";
    }

    @GetMapping
    @RequestMapping("/{id}")
    public Student readStudent (@PathVariable (name = "id") Integer id, String surname, String name) {
        studentService.getStudent(id);
        return  new Student(id, name, surname);
    }

    @RequestMapping("/save")
    public String saveStudent (@ModelAttribute ("student") Student student){
        studentService.saveStudent(student);
        return "redirect:/";
   }

   @RequestMapping("/edit/{id}")
    public ModelAndView editStudent (@PathVariable (name = "id") Integer id){
        ModelAndView stud = new ModelAndView("new");
        StudentEntity student = studentService.getStudent(id);
        stud.addObject("student", student);
        return stud;
   }

   @RequestMapping("/delete/{id}")
    public String deleteStudent (@PathVariable (name = "id") Integer id){
        studentService.deleteStudent(id);
        return "Delete";
   }

}
