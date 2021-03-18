package itmo.prl.evk.dto;


import itmo.prl.evk.db.entity.CourseEntity;
import lombok.Data;

import java.util.Date;

@Data
public class Course extends CourseEntity {

    private Integer id;
    private String courseName;
    private Date startDate;
}

