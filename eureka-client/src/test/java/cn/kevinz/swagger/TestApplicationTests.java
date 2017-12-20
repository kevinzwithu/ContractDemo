package cn.kevinz.swagger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.ws.rs.core.MediaType;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(TestApplication.class)
@AutoConfigureRestDocs(outputDir = "target/snippets", uriPort = 8762)
public class TestApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetUserList() throws Exception {
        this.mockMvc.perform(get("/user")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("This is user list.")))
                .andDo(document("getUserList"));
    }

    @Test
    public void testGetUser() throws Exception {
        this.mockMvc.perform(get("/user/kevinz")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("This is user kevinz")))
                .andDo(document("getUser"));
    }

    @Test
    public void testCreateUser() throws Exception {
        this.mockMvc.perform(post("/user/kevinz")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("I've pushed user kevinz into list.")))
                .andDo(document("createUser"));
    }

}
