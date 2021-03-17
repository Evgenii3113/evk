package itmo.prl.evk.web;


import itmo.prl.evk.dto.Student;
import itmo.prl.evk.form.StudentForm;
import itmo.prl.evk.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {

    public final StudentService studentService;

    public PageController(StudentService studentService) {
        this.studentService = studentService;
    }


    @RequestMapping(value = { "/studentList" }, method = RequestMethod.GET)
    public String viewStudentList(Model model) {

        model.addAttribute ("student", studentService.findAll());

        return "studentList";
    }

    @RequestMapping(value = {"/newStudent"}, method = RequestMethod.GET)
    public String createNewStudent (Model model){
        StudentForm studentForm = new StudentForm();
        model.addAttribute("studentForm", studentForm);

        return "newStudent";
    }

    @RequestMapping(value = {"/newStudent"}, method = RequestMethod.POST)
    public String saveStudent (@ModelAttribute ("studentForm") StudentForm studentForm){
        Student student = new Student();
        student.setSurname(studentForm.getStudentSurname());
        student.setName(studentForm.getStudentName());
        student.setSecondName(studentForm.getStudentSecondName());

        studentService.saveStudent(student);

        return "redirect:/studentList";
    }

}
