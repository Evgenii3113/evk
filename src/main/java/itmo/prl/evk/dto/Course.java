package itmo.prl.evk.dto;


import itmo.prl.evk.db.entity.CourseEntity;
import lombok.Data;

import java.util.Date;

@Data
public class Course extends CourseEntity {

    private Integer id;
    private String courseName;
    private Date startDate;

    public Course(Integer id, String courseName, Date startDate) {
        this.id = id;
        this.courseName = courseName;
        this.startDate = startDate;
    }

    public Course() {
    }
}

