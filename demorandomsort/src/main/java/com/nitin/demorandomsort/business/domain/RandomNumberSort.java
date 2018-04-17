package com.nitin.demorandomsort.business.domain;

import java.util.Arrays;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RandomNumberSort {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	int[] originalList;
	int[] sortedList;
	int numberOfExchanges;
	long sortingTimeNanoSecond;

	public RandomNumberSort() {

	}

	public RandomNumberSort(int[] originalList, int[] sortedList, int numberOfExchanges, long sortingTimeNanoSecond) {
		super();
		this.originalList = originalList;
		this.sortedList = sortedList;
		this.numberOfExchanges = numberOfExchanges;
		this.sortingTimeNanoSecond = sortingTimeNanoSecond;
	}

	public String toString() {
		return "Id:" + this.id + "originalList:"
				+ Arrays.stream(this.originalList).boxed().collect(Collectors.toList()).stream().map(String::valueOf)
						.collect(Collectors.joining(", ", "[", "]"))
				+ "sortedList:"
				+ Arrays.stream(this.sortedList).boxed().collect(Collectors.toList()).stream().map(String::valueOf)
						.collect(Collectors.joining(", ", "[", "]"))
				+ "numberOfExchanges:" + this.numberOfExchanges + "sortingTime(ns):" + this.sortingTimeNanoSecond;
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

	public int getNumberOfExchanges() {
		return numberOfExchanges;
	}

	public void setNumberOfExchanges(int numberOfExchanges) {
		this.numberOfExchanges = numberOfExchanges;
	}

	public long getSortingTimeNanoSecond() {
		return sortingTimeNanoSecond;
	}

	public void setSortingTimeNanoSecond(long sortingTimeNanoSecond) {
		this.sortingTimeNanoSecond = sortingTimeNanoSecond;
	}

}
