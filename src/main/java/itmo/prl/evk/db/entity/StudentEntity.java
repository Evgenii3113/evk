package itmo.prl.evk.db.entity;


import lombok.Data;


import javax.persistence.*;
import java.util.Collection;
import java.util.List;


@Entity
@Data
@Table(schema = "public", name = "student")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String surname;
    @Column
    private String name;
    @Column(name = "second_name")
    private String secondName;
    @Column
    private String email;
    @Column
    private String phone;
    @JoinColumn(name = "student_id")
    @OneToMany(cascade = CascadeType.ALL)
    private Collection<CourseAssignment> courseAssignments;

}
