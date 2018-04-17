package com.nitin.demorandomsort.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.nitin.demorandomsort.business.domain.RandomNumberSort;

public interface RandomNumberSortingRepository extends CrudRepository<RandomNumberSort, Integer> {

}
