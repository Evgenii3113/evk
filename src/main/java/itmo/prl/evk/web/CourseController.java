package itmo.prl.evk.web;


import itmo.prl.evk.db.entity.CourseEntity;
import itmo.prl.evk.dto.Course;
import itmo.prl.evk.dto.Student;
import itmo.prl.evk.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public CourseEntity saveCourse(@RequestBody Course course) {
        return courseService.saveCourse(course);
    }

    @GetMapping("/all")
    public List<Course> findAllCourse() {
        return courseService.findAll();
    }

    @GetMapping("/find")
    public CourseEntity readCourse(@RequestParam String courseName) {
        return  courseService.findByCourseName(courseName);

    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity deleteCourse (@PathVariable Integer id) {
        courseService.deleteCourse(id);
        return new ResponseEntity<>("Course removed", HttpStatus.OK);
    }
}
