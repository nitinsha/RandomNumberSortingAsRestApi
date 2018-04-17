package com.nitin.demorandomsort;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.nitin.demorandomsort.business.service.RandomNumberSortingService;
import com.nitin.demorandomsort.data.repository.RandomNumberSortingRepository;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class RandomNumberSortingServiceTests {

	@TestConfiguration
	static class RandomNumberSortingServiceTestConfiuration{
		@Bean
		public RandomNumberSortingService randomNumberSortingService(){
			return new RandomNumberSortingService();
		}
	}
	
	@Autowired
	RandomNumberSortingService randomNumberSortingService;
	@MockBean
	RandomNumberSortingRepository randomNumberSortingRepository;
	@Before
	public void setup(){
	
		Mockito.when(randomNumberSortingRepository.count()).thenReturn((long) 1);		
		
	}
	@Test
	public void getTotalNumberOfRequestReceived(){
		long count = randomNumberSortingService.count();
		assertThat(count).isEqualTo(1);
	}
}
