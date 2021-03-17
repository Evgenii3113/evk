package itmo.prl.evk.form;

import lombok.Data;

import java.util.Date;

@Data
public class StudentForm {
    private String studentSurname;
    private String studentName;
    private String studentSecondName;
    private String studentEmail;
    private String studentPhone;
    private String studentCourse;
    private Date courseStartDate;

}
