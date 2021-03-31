package itmo.prl.evk.db.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@Table(schema = "public", name = "course_assignment")
public class CourseAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JoinColumn(name = "course_id")
    @OneToOne(cascade = CascadeType.ALL)
    private CourseEntity courseEntity;

    @JoinColumn(name = "student_id")
    @OneToOne(cascade = CascadeType.ALL)
    private StudentEntity studentEntity;
}
