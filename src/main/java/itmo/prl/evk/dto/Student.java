package itmo.prl.evk.dto;


import itmo.prl.evk.db.entity.CourseAssignment;
import itmo.prl.evk.db.entity.StudentEntity;
import lombok.*;

import java.util.List;

@Data
public class Student extends StudentEntity {

    private Integer id;
    private String surname;
    private String name;
    private String secondName;
    private String email;
    private String phone;
    private CourseAssignment courseAssignment;
}









