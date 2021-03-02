package itmo.prl.evk.web;


import itmo.prl.evk.db.entity.StudentEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class StudentController {

    @GetMapping
    public StudentEntity readStudent (){
        return new StudentEntity();
    }
}
