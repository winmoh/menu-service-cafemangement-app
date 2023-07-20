package com.cafemanager.menuservice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import com.cafemanager.menuservice.dto.MenuRequest;
import com.cafemanager.menuservice.repository.MenuRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class MenuServiceApplicationTests {



	static MongoDBContainer mongoDBContainer=new MongoDBContainer("mongo:6.0").withExposedPorts(27017);
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private MenuRepository menuRepository;

	static {
		mongoDBContainer.start();
	}

	@DynamicPropertySource
	static void setProperties(DynamicPropertyRegistry dpRegistry){

		dpRegistry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
	}


	public MenuRequest getProductRequest(){
		return MenuRequest.builder()
				.name("ftor beldi")
				.category("petit déjeuner")
				.price(60)
				.build();
	}

	@Test
	void  createProductTest() throws Exception {
		MenuRequest req=getProductRequest();
		String createProductRequest=objectMapper.writeValueAsString(req);
		mockMvc.perform(MockMvcRequestBuilders.post("/api/menu")
				.contentType(MediaType.APPLICATION_JSON)
				.content(createProductRequest))
				.andExpect(status().isCreated())
		;
		Assertions.assertEquals(1, menuRepository.findAll().size());


	}

}
