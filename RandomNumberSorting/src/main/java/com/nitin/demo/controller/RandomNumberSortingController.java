package com.nitin.demo.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nitin.demo.dto.RandonNumberSortingDTO;
import com.nitin.demo.service.RandomNumberSortingService;

@RestController
@RequestMapping("/test/")
public class RandomNumberSortingController {

	@Autowired
	private RandomNumberSortingService service;

	@RequestMapping(value = "/sort", params = "ids", method = RequestMethod.GET)
	@ResponseBody
	public String getSortedIntegers(@RequestParam String ids) {
		int[] items = Arrays.asList(ids.split(",")).stream().map(String::trim).mapToInt(Integer::parseInt).toArray();

		int[] sortedArray = service.getSortedIntegers(items);
		
		List<Integer> sortedList = Arrays.stream(sortedArray).boxed().collect(Collectors.toList());
		String joinedString = sortedList.stream().map(String::valueOf).collect(Collectors.joining(", ", "[", "]"));

		System.out.println("Returning sorted joined string" + joinedString);
		return joinedString;

	}
	@RequestMapping(value = "/getAll",method = RequestMethod.GET)
	@ResponseBody
	public List<RandonNumberSortingDTO> getRequestHistory() {
		
		return service.getRequestHistory();
	}

}
