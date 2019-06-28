package cn.jantd.springsecurity;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringsecurityApplicationTests {

  @Autowired
  private WebApplicationContext webApplicationContext;

  private MockMvc mockMvc;

  @Before
  public void contextLoads() {
    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).apply(springSecurity()).build();
  }

  @Test
  public void loginTest() throws Exception {
    mockMvc.perform(
            get("/login")
                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                    .param("username","admin")
                    .param("password","123456")
//                    .content("{\"username\":\"admin\",\"password\": \"123456\"}")
    ).andDo(print())
            .andExpect(status().isOk());
  }

  @Test
//  @WithMockUser(value = "admin",password="123456")
  public void noneRequestTest() throws Exception {
    mockMvc.perform(get("/none"))
            .andDo(print())
            .andExpect(status().isOk());
  }

  @Test
  @WithUserDetails(value = "admin",userDetailsServiceBeanName="userService")
  public void requestTest() throws Exception {
    mockMvc.perform(get("/test"))
            .andDo(print())
            .andExpect(status().isOk());
  }

}
