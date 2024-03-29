package itmo.prl.evk.web;


import com.fasterxml.jackson.databind.ObjectMapper;


import itmo.prl.evk.db.repo.StudentRepo;
import itmo.prl.evk.dto.Student;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.ConfigurableMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@RunWith(SpringRunner.class)
public class StudentControllerTest {

    MockMvc mockMvc;

    @Autowired
    WebApplicationContext webApplicationContext;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    StudentRepo studentRepo;

    @Rule
    public JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation("target/generated-snippets");

    @Before
    public void setUp() {
        ConfigurableMockMvcBuilder builder =
                MockMvcBuilders.webAppContextSetup(this.webApplicationContext)
                        .apply(documentationConfiguration(this.restDocumentation));
        this.mockMvc = builder.build();
    }


    @Test
    public void readStd() throws Exception {
        Student student = new Student();
        student.setSurname("Ivanov");
        String content = objectMapper.writeValueAsString(student);
        System.out.println(content);
        String uri = "/students/find";
        mockMvc.perform(get(uri)
                .param("surname", student.getSurname())
                .contentType(MediaType.APPLICATION_JSON)
                .content(content))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Petr"))
                .andDo(document(uri));
    }


    @Test
    public void saveStd() throws Exception {
        Student student = new Student();
        student.setSurname("Aronov");
        student.setName("Igor");
        student.setSecondName("Girovich");
        student.setPhone("89213564585");
        student.setEmail("sara@ya.ru");
        String content = objectMapper.writeValueAsString(student);
        System.out.println(content);
        String uri = "/students/new";
        mockMvc.perform(post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Igor"))
                .andDo(document(uri));
    }

    @Test
    public void removeStd() throws Exception {
        Student student = new Student();
        student.setId(36);
        String content = objectMapper.writeValueAsString(student);
        System.out.println(content);
        String uri = "/students/remove/{id}";
        mockMvc.perform(delete(uri, student.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(content))
                .andExpect(status().isOk())
                .andDo(document(uri));
    }

}