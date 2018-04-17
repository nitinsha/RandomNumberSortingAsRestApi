package com.nitin.demorandomsort.business.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nitin.demorandomsort.business.domain.RandomNumberSort;
import com.nitin.demorandomsort.data.repository.RandomNumberSortingRepository;
import com.nitin.demorandomsort.utility.RandomSortUtility;

@Service
public class RandomNumberSortingService {
Logger log = LoggerFactory.getLogger(RandomNumberSortingService.class);
	@Autowired
	RandomNumberSortingRepository repository;

	public RandomNumberSortingService() {

	}

	public RandomNumberSort getSortedIntegers(int[] ids) {
		int[] SortedIds = ids;
		long startTime = System.nanoTime();
		int numberOfExchanges = new RandomSortUtility().sort(SortedIds);
		long timTakenToSort = System.nanoTime()- startTime ;
		
		RandomNumberSort randonNumberSort = new RandomNumberSort(ids, SortedIds,numberOfExchanges,timTakenToSort);
		
		randonNumberSort = repository.save(randonNumberSort);
		log.info("Saved Entry to DB:\n"+randonNumberSort.toString());
		return randonNumberSort;
	}
	
	public List<RandomNumberSort> getRequestHistory(){
		List<RandomNumberSort> list = new ArrayList<>();
		repository.findAll().forEach(list::add);
		return list;
	}
	public long count(){
		return repository.count();
	}

}
