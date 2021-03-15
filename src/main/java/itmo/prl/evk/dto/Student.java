package itmo.prl.evk.dto;


import itmo.prl.evk.db.entity.StudentEntity;
import lombok.*;


public class Student extends StudentEntity {

    private Integer id;
    private String surname;
    private String name;
    private String secondName;
    private String email;
    private String phone;
    private Integer coursId;

    public Student(Integer id, String surname, String name, String secondName, String email, String phone, Integer coursId) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.secondName = secondName;
        this.email = email;
        this.phone = phone;
        this.coursId = coursId;
    }

    public Student() {
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







