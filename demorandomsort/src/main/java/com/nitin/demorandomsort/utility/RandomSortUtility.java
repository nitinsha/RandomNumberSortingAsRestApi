package com.nitin.demorandomsort.utility;

public class RandomSortUtility {
	private int[] numbers;
	private int number;
	int numberOfExchanges;
	
	
	public  int sort(int[] values) {
		numberOfExchanges=0;
		this.numbers = values;
		number = values.length;
		quicksort(0, number - 1);
		return numberOfExchanges ; 
	}

	private void quicksort(int low, int high) {
		int i = low, j = high;

		int pivot = numbers[(low + high) / 2];

		// Divide into two lists
		while (i <= j) {
			// If the current value from the left list is smaller then the pivot
			// element then get the next element from the left list
			while (numbers[i] < pivot) {
				i++;
			}
			// If the current value from the right list is larger then the pivot
			// element then get the next element from the right list
			while (numbers[j] > pivot) {
				j--;
			}

			// If we have found a values in the left list which is larger then
			// the pivot element and if we have found a value in the right list
			// which is smaller then the pivot elment then we exchange the
			// values.
			if (i <= j) {
				exchange(i, j);
				i++;
				j--;
			}
		}
		// Recursion
		if (low < j)
			quicksort(low, j);
		if (i < high)
			quicksort(i, high);
	}

	private void exchange(int i, int j) {
		numberOfExchanges++;
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
}
