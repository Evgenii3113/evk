package itmo.prl.evk.db.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table (schema = "public", name = "cours")
public class CoursEntity<studentEntityList> {


    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "cours_id")
    private Integer id;
    @Column(name = "cours_name")
    private String coursName;
    @Column(name = "start_date")
    private Date startDate;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCours")
    private List<StudentEntity> studentEntityList;

    public CoursEntity() {
    }

    public CoursEntity(Integer id, String coursName, Date startDate) {
        this.id = id;
        this.coursName = coursName;
        this.startDate = startDate;
    }


}

