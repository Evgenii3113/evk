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
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;


@Controller
public class PageController {

    public final StudentService studentService;
    public final CourseService courseService;

    public PageController(StudentService studentService, CourseService courseService, StudentRepo studentRepo,
                          CourseAssignmentRepo courseAssignmentRepo) {
        this.studentService = studentService;
        this.courseService = courseService;
        this.studentRepo = studentRepo;
        this.courseAssignmentRepo = courseAssignmentRepo;
    }

    final StudentRepo studentRepo;
    final CourseAssignmentRepo courseAssignmentRepo;

    @GetMapping({"/"})
    public String firstPage() {
        return "myFirst";
    }


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
    public String saveStudent(String surname, String name, String secondName, String phone, String email,
                              String courseName, Model model) {
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

        model.addAttribute("courseName", courseName);
        CourseEntity courseEntity = courseService.findByCourseName(courseName);

        CourseAssignment courseAssignment = new CourseAssignment();
        courseAssignment.setCourseEntity(courseEntity);
        studentEntity.setCourseAssignments(Arrays.asList(courseAssignment));
        courseAssignmentRepo.save(courseAssignment);


        return "redirect:/assignList";
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
    public String saveCourse(@RequestParam String courseName,
                             @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                             Model model) {
        model.addAttribute("courseName", courseName)
                .addAttribute("startDate", startDate);
        Course course = new Course();
        course.setCourseName(courseName.trim());
        course.setStartDate(startDate);
        courseService.saveCourse(course);
        return "redirect:/courseList";
    }

    @RequestMapping(value = {"/assignList"}, method = RequestMethod.GET)
    public String viewAssignmentList(Model model) {
        model.addAttribute("assign", courseAssignmentRepo.findAll());
        return "assignList";
    }

    @RequestMapping(value = {"/findStudent"}, method = RequestMethod.GET)
    public String findStudent() {
        return "findStudent";
    }


    @RequestMapping(value = {"/findStudent"}, method = RequestMethod.POST)
    public String findStudent(@RequestParam String surname, Model model) {
        model.addAttribute("surname", surname);
        Student student = studentService.findBySurname(surname);


        model.addAttribute("id", student.getId())
                .addAttribute("surname", student.getSurname())
                .addAttribute("name", student.getName())
                .addAttribute("secondName", student.getSecondName())
                .addAttribute("phone", student.getPhone())
                .addAttribute("email", student.getEmail());


        return "redirect:/findStud/" + student.getId() + "/" + student.getSurname() + "/" + student.getName() + "/"
                + student.getSecondName() + "/" + student.getPhone() + "/" + student.getEmail();

    }

    @RequestMapping(value = {"/findStud/{id}/{surname}/{name}/{secondName}/{phone}/{email}"}, method = RequestMethod.GET)
    public String findStud(@PathVariable Integer id,
                           @PathVariable String surname,
                           @PathVariable String name,
                           @PathVariable String secondName,
                           @PathVariable String phone,
                           @PathVariable String email,
                           Model model) {

        model.addAttribute("id", id)
                .addAttribute("surname", surname)
                .addAttribute("name", name)
                .addAttribute("secondName", secondName)
                .addAttribute("phone", phone)
                .addAttribute("email", email);


        return "findStud";
    }




}

