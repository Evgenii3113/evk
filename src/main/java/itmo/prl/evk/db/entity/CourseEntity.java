package itmo.prl.evk.db.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table (schema = "public", name = "course")
public class CourseEntity {


    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Integer id;
    @Column(name = "course_name")
    private String courseName;
    @Column(name = "start_date")
    private Date startDate;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCours")
    private List<StudentEntity> studentEntityList;

    public CourseEntity() {
    }

    public CourseEntity(Integer id, String courseName, Date startDate) {
        this.id = id;
        this.courseName = courseName;
        this.startDate = startDate;
    }


}

