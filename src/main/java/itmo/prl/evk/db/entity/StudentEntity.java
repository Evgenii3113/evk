package itmo.prl.evk.db.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table (schema = "public", name = "student" )
public class StudentEntity {

    @Id
    @Column (name = "student_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String surname;
    @Column
    private String name;
    @Column (name = "second_name")
    private String secondName;
    @Column
    private String email;
    @Column
    private String phone;
    @Column
    private Integer coursId;

    public StudentEntity() {
    }

    public StudentEntity(Integer id, String surname, String name, String secondName, String email, String phone, Integer coursId) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.secondName = secondName;
        this.email = email;
        this.phone = phone;
        this.coursId = coursId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getCoursId() {
        return coursId;
    }

    public void setCoursId(Integer coursId) {
        this.coursId = coursId;
    }
}
