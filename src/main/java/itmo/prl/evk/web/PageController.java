package itmo.prl.evk.web;


import itmo.prl.evk.db.entity.CourseAssignment;
import itmo.prl.evk.db.entity.CourseEntity;
import itmo.prl.evk.db.entity.StudentEntity;
import itmo.prl.evk.db.repo.CourseAssignmentRepo;
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
    @Autowired
    CourseAssignmentRepo courseAssignmentRepo;


    @RequestMapping(value = {"/studentList"}, method = RequestMethod.GET)
    public String viewStudentList(Model model) {
        model.addAttribute("student", studentService.findAll());
        return "studentList";
    }

    @RequestMapping(value = {"/newStudent"}, method = RequestMethod.GET)
    public String createNewStudent() {
        return "newStudent";
    }

    @RequestMapping(value = {"/newStudent"}, method = RequestMethod.POST)
    public String saveStudent(@RequestParam String surname, String name, String secondName, String phone, String email, String courseName, Model model, Model model1) {
        model.addAttribute("surname", surname)
                .addAttribute("name", name)
                .addAttribute("secondName", secondName)
                .addAttribute("phone", phone)
                .addAttribute("email", email);
        Student student = new Student();
        student.setSurname(surname.trim());
        student.setName(name.trim());
        student.setSecondName(secondName.trim());
        student.setPhone(phone.trim());
        student.setEmail(email.trim());
        StudentEntity studentEntity = studentService.saveStudent(student);

        model1.addAttribute("courseName", courseName);
        CourseEntity courseEntity = courseService.findByCourseName(courseName);

        CourseAssignment courseAssignment = new CourseAssignment();
        courseAssignment.setCourseEntity(courseEntity);
        courseAssignment.setStudentEntity(studentEntity);

        courseAssignmentRepo.save(courseAssignment);

        return "redirect:/studentList";
    }

    @RequestMapping(value = {"/courseList"}, method = RequestMethod.GET)
    public String viewCourseList(Model model) {
        model.addAttribute("course", courseService.findAll());
        return "courseList";
    }

    @RequestMapping(value = {"/newCourse"}, method = RequestMethod.GET)
    public String createNewCourse() {
        return "newCourse";
    }

    @RequestMapping(value = {"/newCourse"}, method = RequestMethod.POST)
    public String saveCourse(@RequestParam String courseName, String startDate, Model model) {
        model.addAttribute("courseName", courseName)
                .addAttribute("startDate", startDate);
        Course course = new Course();
        course.setCourseName(courseName.trim());
        course.setStartDate(startDate.trim());
        courseService.saveCourse(course);
        return "redirect:/courseList";
    }

        @RequestMapping(value = {"/assignList"}, method = RequestMethod.GET)
        public String viewAssignmentList(Model model) {
            model.addAttribute("assign", courseAssignmentRepo.findAll());
            return "assignList";
        }

    }

