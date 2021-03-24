package itmo.prl.evk.db.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table (schema = "public", name = "course_assignment")
public class CourseAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JoinColumn (name = "course_id")
    @OneToOne (cascade = CascadeType.ALL)
    private CourseEntity courseEntity;

}
