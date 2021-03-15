package itmo.prl.evk.web;


import itmo.prl.evk.db.entity.CourseEntity;
import itmo.prl.evk.dto.Course;
import itmo.prl.evk.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CoursController {

private  final CourseService courseService;

    public CoursController(CourseService courseService) {
        this.courseService = courseService;
    }


    @PostMapping("/new")
   public CourseEntity saveStd (@RequestBody Course course) {
       return courseService.saveCourse(course);
   }

    @GetMapping("/all")
    public List<Course> findAllCours(){
        return courseService.findAll();
    }


   @GetMapping("/find")
   public Course readCourse (@RequestParam String courseName) {
        return courseService.findByCourseName(courseName);
    }


    @DeleteMapping("/delete/{id}")
    public String deleteCours (@PathVariable Integer id){
        courseService.deleteCourse(id);
        return "Course deleted";
    }


}
