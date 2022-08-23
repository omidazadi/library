package com.tosansoha.library.integrationTests;

import javax.servlet.ServletContext;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.tosansoha.library.LibraryController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@WebAppConfiguration
//@TestPropertySource(
//    locations = "classpath:application-IT.properties")
public class LibraryIntegrationTest {
    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    /*@Test
    public void testingTest() {
        ServletContext servletContext = webApplicationContext.getServletContext();
        
        Assertions.assertNotNull(servletContext);
        Assertions.assertTrue(servletContext instanceof MockServletContext);
        Assertions.assertNotNull(webApplicationContext.getBean("LibraryController"));
    }

    @Test
    public void trivialTest() {
        Assertions.assertEquals(2, 2);
    }*/

    @Autowired
	private LibraryController controller;

	@Test
	public void contextLoads() throws Exception {
		Assertions.assertNotNull(controller);
        Assertions.assertNotNull(mockMvc);
        Assertions.assertNotNull(webApplicationContext);
	}
}
