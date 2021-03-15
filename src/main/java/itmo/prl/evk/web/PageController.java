package itmo.prl.evk.web;


import itmo.prl.evk.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

}
