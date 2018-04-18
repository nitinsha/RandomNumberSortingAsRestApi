package com.nitin.demorandomsort;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.nitin.demorandomsort.business.domain.RandomNumberSort;
import com.nitin.demorandomsort.business.service.RandomNumberSortingService;
import com.nitin.demorandomsort.controller.RandomNumberSortController;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest(RandomNumberSortController.class)
public class RandomNumberSortControllerTests {
	@Autowired
    private MockMvc mvc;
 
    @MockBean
    private RandomNumberSortingService randomNumberSortingService;
    
    @Test
    public void getAllREquestsSuccess() throws Exception{
    	int[] origArray = { 2, 7, 9, 1, 6, 0, 1 };
		int[] sortArray = { 0, 1, 1, 2, 6, 7, 9 };
		int noOfExchange = 4;
		long time = 2222L;
		RandomNumberSort randomNumberSort = new RandomNumberSort(origArray, sortArray, noOfExchange, time);
		
		List<RandomNumberSort> allRequests = Arrays.asList(randomNumberSort);
		given(randomNumberSortingService.getRequestHistory()).willReturn(allRequests);
		mvc.perform(get("/api/sort/getAll")
		.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$",hasSize(1)))
		.andExpect(jsonPath("$[0].numberOfExchanges",is(randomNumberSort.getNumberOfExchanges())))
		
		;
    }
}
