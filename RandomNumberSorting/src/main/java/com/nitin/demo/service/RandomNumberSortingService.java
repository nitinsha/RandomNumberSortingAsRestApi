package com.nitin.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nitin.demo.dto.RandonNumberSortingDTO;
import com.nitin.demo.repository.RandomNumberSortingRepository;

@Service
public class RandomNumberSortingService {

	@Autowired
	RandomNumberSortingRepository repository;

	public RandomNumberSortingService() {

	}

	public int[] getSortedIntegers(int[] ids) {
		int[] SortedIds = ids;
		Arrays.sort(SortedIds);
		repository.save(new RandonNumberSortingDTO(ids, SortedIds));
		return SortedIds;
	}
	
	public List<RandonNumberSortingDTO> getRequestHistory(){
		List<RandonNumberSortingDTO> list = new ArrayList<>();
		repository.findAll().forEach(list::add);
		return list;
	}

}
