package com.nitin.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.nitin.demo.dto.RandonNumberSortingDTO;

public interface RandomNumberSortingRepository extends CrudRepository<RandonNumberSortingDTO, Integer> {

}
