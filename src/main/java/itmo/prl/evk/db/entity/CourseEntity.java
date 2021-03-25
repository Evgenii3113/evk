package itmo.prl.evk.db.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(schema = "public", name = "course")
public class CourseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Integer id;
    @Column(name = "course_name")
    private String courseName;
    @Column(name = "start_date")
    private String startDate;


}

