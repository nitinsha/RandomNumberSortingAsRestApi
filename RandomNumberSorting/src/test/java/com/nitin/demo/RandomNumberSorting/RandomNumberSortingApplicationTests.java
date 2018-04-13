package com.nitin.demo.RandomNumberSorting;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.nitin.demo.controller.RandomNumberSortingController;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class RandomNumberSortingApplicationTests {

	@Autowired
	RandomNumberSortingController controller;

	String queryString = "1,9,2,8,3,7";
	String sortedString = "1,2,3,7,8,9";
	

	@Autowired
	private TestRestTemplate restTemplate;



	String url = "http://localhost:8082/test/sort?ids=" + queryString;
	@Before
	public void init() {
	}

	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

	@Test
	public void numbersPassedasShouldSortedByRestApi() throws Exception {
		assertThat(restTemplate.getForObject(url, String.class)).contains(sortedString);
	}

}
