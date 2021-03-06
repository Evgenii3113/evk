package itmo.prl.evk.dto;


import itmo.prl.evk.db.entity.StudentEntity;
import lombok.*;

@Data
@RequiredArgsConstructor
public class Student extends StudentEntity {

    private Integer id;
    private String surname;
    private String name;
    private String secondName;
    private String email;
    private String phone;


    public Student(Integer id, String name, String surname) {
    }
}







