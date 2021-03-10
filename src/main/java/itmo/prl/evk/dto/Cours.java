package itmo.prl.evk.dto;


import itmo.prl.evk.db.entity.CoursEntity;
import lombok.Data;

import java.util.Date;

@Data
public class Cours extends CoursEntity {

    private Integer id;
    private String courseName;
    private Date startDate;

    public Cours(Integer id, String courseName, Date startDate) {
        this.id = id;
        this.courseName = courseName;
        this.startDate = startDate;
    }

    public Cours() {
    }
}

