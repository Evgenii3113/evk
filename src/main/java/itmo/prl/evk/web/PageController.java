package itmo.prl.evk.web;



import itmo.prl.evk.db.entity.CourseAssignment;
import itmo.prl.evk.db.entity.CourseEntity;
import itmo.prl.evk.db.entity.StudentEntity;
import itmo.prl.evk.db.repo.StudentRepo;
import itmo.prl.evk.dto.Course;
import itmo.prl.evk.dto.Student;
import itmo.prl.evk.service.CourseService;
import itmo.prl.evk.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
public class PageController {

    public final StudentService studentService;
    public final CourseService courseService;

    public PageController(StudentService studentService, CourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }

    @Autowired
    StudentRepo studentRepo;


    @RequestMapping(value = {"/studentList"}, method = RequestMethod.GET)
    public String viewStudentList(Model model) {

        model.addAttribute("student", studentService.findAll());


        return "studentList";
    }

    @RequestMapping(value = {"/newStudent"}, method = RequestMethod.GET)
    public String createNewStudent(Model model) {

        return "newStudent";
    }

    @RequestMapping(value = {"/newStudent"}, method = RequestMethod.POST)
    public String saveStudent(@RequestParam String surname, String name, String secondName, String phone, String email, String courseName, Model model) {
        model.addAttribute("surname", surname)
                .addAttribute("name", name)
                .addAttribute("secondName", secondName)
                .addAttribute("phone", phone)
                .addAttribute("email", email)
                .addAttribute("courseName", courseName);
        Student student = new Student();
        student.setSurname(surname.trim());
        student.setName(name.trim());
        student.setSecondName(secondName.trim());
        student.setPhone(phone.trim());
        student.setEmail(email.trim());
        StudentEntity lastStudentEntity = studentService.saveStudent(student);
        Course course = new Course();
        course.setCourseName(courseName);
        CourseEntity courseEntityWithId = courseService.findByCourseName(course.getCourseName());
        CourseAssignment courseAssignment = new CourseAssignment();
        courseAssignment.setCourseEntity(courseEntityWithId);
        lastStudentEntity.setCourseAssignments(Arrays.asList(courseAssignment));
        studentRepo.save(lastStudentEntity);







        return "redirect:/studentList";
    }



}
