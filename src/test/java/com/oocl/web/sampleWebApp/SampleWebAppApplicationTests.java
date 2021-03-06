package com.oocl.web.sampleWebApp;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SampleWebAppApplicationTests {


	@Autowired
	private MockMvc mockMvc;

	//Given a user { "username": "string" }
	//When POST to /users
	//Then it should return 201. And the value of `Location` header should be /users/{userId}
	@Test
	public void shouldReturnDefaultMessage() throws Exception {

		this.mockMvc.perform(post("/users")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{ \"username\": \"string\" }")
				)
				.andExpect(status().isCreated())
				.andExpect(header().string("Location", containsString("/users/string")));
	}

}
