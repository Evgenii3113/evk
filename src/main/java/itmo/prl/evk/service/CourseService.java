package itmo.prl.evk.service;


import itmo.prl.evk.db.entity.CourseEntity;
import itmo.prl.evk.db.repo.CourseRepo;
import itmo.prl.evk.dto.Course;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    private final CourseRepo courseRepo;

    public CourseService(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }


    public CourseEntity saveCourse(Course course) {
        CourseEntity courseEntity = courseRepo.save(createCourseEntity(course));
        return courseEntity;
    }

    public void deleteCourse(Integer id) {
        courseRepo.deleteById(id);
    }

    public Course findByCourseName(String courseName) {
        CourseEntity courseEntity = courseRepo.findByCourseName(courseName);
        return createCourse(courseEntity);
    }

    public List<Course> findAll() {
        List<Course> courseList = new ArrayList<>();
        Iterable<CourseEntity> courseEntities = courseRepo.findAll();
        for (CourseEntity courseEntity : courseEntities) {
            courseList.add(createCourse(courseEntity));
        }
        return courseList;
    }

    private CourseEntity createCourseEntity(Course course) {
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setId(course.getId());
        courseEntity.setCourseName(course.getCourseName());
        courseEntity.setStartDate(course.getStartDate());
        return courseEntity;
    }

    private Course createCourse(CourseEntity courseEntity) {
        Course course = new Course();
        course.setId(courseEntity.getId());
        course.setCourseName(courseEntity.getCourseName());
        course.setStartDate(courseEntity.getStartDate());
        return course;
    }

    @PostConstruct
    public void init() {
        Iterable<CourseEntity> courseEntities = courseRepo.findAll();
        for (CourseEntity courseEntity : courseEntities) {
            System.out.println(courseEntity.toString());
        }
    }
}