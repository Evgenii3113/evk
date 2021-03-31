package itmo.prl.evk.db.entity;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
    private LocalDate startDate;



}

