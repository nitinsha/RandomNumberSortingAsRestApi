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
		int arrayStartInitialiser = low, arrayEndInitialiser = high;

		int pivot = numbers[(low + high) / 2];

		// Divide into two lists
		while (arrayStartInitialiser <= arrayEndInitialiser) {
			// If the current value from the left list is smaller then the pivot
			// element then get the next element from the left list
			while (numbers[arrayStartInitialiser] < pivot) {
				arrayStartInitialiser++;
			}
			// If the current value from the right list is larger then the pivot
			// element then get the next element from the right list
			while (numbers[arrayEndInitialiser] > pivot) {
				arrayEndInitialiser--;
			}

			// If we have found a values in the left list which is larger then
			// the pivot element and if we have found a value in the right list
			// which is smaller then the pivot elment then we exchange the
			// values.
			if (arrayStartInitialiser <= arrayEndInitialiser) {
				exchange(arrayStartInitialiser, arrayEndInitialiser);
				arrayStartInitialiser++;
				arrayEndInitialiser--;
			}
		}
		// Recursion
		if (low < arrayEndInitialiser)
			quicksort(low, arrayEndInitialiser);
		if (arrayStartInitialiser < high)
			quicksort(arrayStartInitialiser, high);
	}

	private void exchange(int i, int j) {
		numberOfExchanges++;
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
}
