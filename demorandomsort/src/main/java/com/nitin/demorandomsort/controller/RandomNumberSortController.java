package com.nitin.demorandomsort.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nitin.demorandomsort.business.domain.RandomNumberSort;
import com.nitin.demorandomsort.business.service.RandomNumberSortingService;

@Controller
@RequestMapping("/api/sort")
public class RandomNumberSortController {
	Logger log = LoggerFactory.getLogger(RandomNumberSortController.class);
	@Autowired
	private RandomNumberSortingService randomNumberSortingService;

	@RequestMapping(method = RequestMethod.GET)
	public String getRandomNumbersSorted(@RequestParam(value="numbers",required=false) String numbers, Model model) {
		log.info("Received random number request: " + numbers);
		int[] items = Arrays.asList(numbers.split(",")).stream().map(String::trim).mapToInt(Integer::parseInt)
				.toArray();
		RandomNumberSort randonNumberSort = randomNumberSortingService.getSortedIntegers(items);
		List<Integer> sortedList = Arrays.stream(randonNumberSort.getSortedList()).boxed().collect(Collectors.toList());
		String joinedString = sortedList.stream().map(String::valueOf).collect(Collectors.joining(", ", "[", "]"));
		model.addAttribute("joinedString", joinedString);
		model.addAttribute("numberOfExchanges", randonNumberSort.getNumberOfExchanges());
		model.addAttribute("sortingTimeNanoSecond", randonNumberSort.getSortingTimeNanoSecond());
		log.info("Returning sorted joined string" + joinedString);
		return "result";
	}
	@RequestMapping(value="/getAll", method = RequestMethod.GET)
	public @ResponseBody List<RandomNumberSort> getRandomNumbersSorted() {
		return randomNumberSortingService.getRequestHistory();
	}
	
	
}
