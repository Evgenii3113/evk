package itmo.prl.evk.web;


import itmo.prl.evk.db.entity.CourseEntity;
import itmo.prl.evk.dto.Course;
import itmo.prl.evk.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/new")
    public CourseEntity saveStd(@RequestBody Course course) {
        return courseService.saveCourse(course);
    }

    @GetMapping("/all")
    public List<Course> findAllCourse() {
        return courseService.findAll();
    }


    @DeleteMapping("/remove/{id}")
    public String deleteCourse(@PathVariable Integer id) {
        courseService.deleteCourse(id);
        return "Course removed";
    }
}
