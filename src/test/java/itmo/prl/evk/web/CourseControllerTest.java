package itmo.prl.evk.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import itmo.prl.evk.db.repo.CourseRepo;
import itmo.prl.evk.db.repo.StudentRepo;
import itmo.prl.evk.dto.Course;
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
public class CourseControllerTest {

    MockMvc mockMvc;

    @Autowired
    WebApplicationContext webApplicationContext;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    CourseRepo courseRepo;

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
    public void saveStd() throws Exception {
        Course course = new Course();
        course.setCourseName("Sports");
        String content = objectMapper.writeValueAsString(course);
        System.out.println(content);
        String uri = "/courses/new";
        mockMvc.perform(post(uri)
                .param("courseName", course.getCourseName())
                .contentType(MediaType.APPLICATION_JSON)
                .content(content))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.courseName").value("Sports"))
                .andDo(document(uri));
    }

    @Test
    public void readCourse() throws Exception {
        Course course = new Course();
        course.setCourseName("Coaching");
        String content = objectMapper.writeValueAsString(course);
        System.out.println(content);
        String uri = "/courses/find";
        mockMvc.perform(get(uri)
                .param("courseName", course.getCourseName())
                .contentType(MediaType.APPLICATION_JSON)
                .content(content))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.courseName").value("Coaching"))
                .andDo(document(uri));
    }

    @Test
    public void deleteCourse() throws Exception {
        Course course = new Course();
        course.setId(4);
        String content = objectMapper.writeValueAsString(course);
        System.out.println(content);
        String uri = "/courses/remove/{id}";
        mockMvc.perform(delete(uri, course.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(content))
                .andExpect(status().isOk())
                .andDo(document(uri));
    }
}