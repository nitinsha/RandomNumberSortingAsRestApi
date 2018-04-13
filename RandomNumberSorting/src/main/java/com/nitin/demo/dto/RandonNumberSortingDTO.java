package com.nitin.demo.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RandonNumberSortingDTO {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	int[] originalList;
	int[] sortedList;
	
	public RandonNumberSortingDTO(){
		
	}
	public RandonNumberSortingDTO(int[] originalList, int[] sortedList){
		this.originalList=originalList;
		this.sortedList=sortedList;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int[] getOriginalList() {
		return originalList;
	}
	public void setOriginalList(int[] originalList) {
		this.originalList = originalList;
	}
	public int[] getSortedList() {
		return sortedList;
	}
	public void setSortedList(int[] sortedList) {
		this.sortedList = sortedList;
	}
	
}
