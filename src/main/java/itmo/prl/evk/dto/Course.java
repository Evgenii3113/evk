package itmo.prl.evk.dto;


import itmo.prl.evk.db.entity.CourseEntity;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Course extends CourseEntity {

    private Integer id;
    private String courseName;
    private String startDate;



}

