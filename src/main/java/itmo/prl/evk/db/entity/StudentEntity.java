package itmo.prl.evk.db.entity;


import lombok.Data;


import javax.persistence.*;

@Entity
@Data
@Table(schema = "public", name = "student")
public class StudentEntity {

    @Id
    @Column(name = "student_id")
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

}
