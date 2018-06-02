package com.deepakchandwani.revision.algorithms;


public class SortingAllgorithmsKeyMustKnow {

	public static void main(String[] args) {
		
		
		int[] arr = { 14, 12, 1, 4, 31, 2, 7, 11, 24 };
		
		// this is a quick work so un comment and test single class is helpfull
		// self notes so works.
		
		// new SortingDemo().insertionSort(arr);
		// new SortingDemo().selectionSort(arr);
		// new SortingDemo().bubbleSort(arr);
		// new SortingDemo().recursiveBubbleSort(arr, arr.length);
		// new SortingDemo().mergeSort(arr ,0, arr.length-1);
		// shellSort(arr);
		new SortingAllgorithmsKeyMustKnow().quickSort(arr, 0, arr.length-1);

		new SortingAllgorithmsKeyMustKnow().print(arr);

		// shri comment

	}

	private static void shellSort(int[] arr) {
		int increment = arr.length;

		while (increment >= 1)

		{
			for (int start = 0; start < increment; start++) {
				new SortingAllgorithmsKeyMustKnow().modifiedInsertionSort(arr, increment, start);
			}

			increment = increment / 2;
		}
	}

	void insertionSort(int[] arr) {

		int length = arr.length;

		for (int i = 1; i < length; i++) { // right hand side array to compare

			int j = i - 1; // left hand side element

			int curr = arr[i]; // first right element

			// compare till you find the one lowest
			while (j >= 0 && arr[j] > curr) { // this will break where the left
												// item is smaller than the
												// compared right object
				// if

				arr[j + 1] = arr[j]; // as it is greater keep moving right , so
										// duplication occurs but curr is
										// preserved

				j = j - 1; // as we are comparing the left elements so going
							// left to right
				// j wili go 1 below the location

			}
			// j+1 is the current location
			arr[j + 1] = curr;

		}

		print(arr);

	}

	void modifiedInsertionSort(int[] arr, int increment, int start) {

		int n = arr.length;

		for (int i = start; i < n; i = i + increment) {

			int curr = arr[i]; // current element starting at 1
			int j = i - increment; // to start with current element at i-1 and
									// can go till oth element
			// in case 123450 12345 will move one position to right

			while (j >= start && arr[j] > curr) {

				arr[j + increment] = arr[j];
				j = j - increment;
			}

			arr[j + increment] = curr;
		}

	}

	void selectionSort(int[] arr) {

		int length = arr.length;
		for (int i = 0; i < length - 1; i++) { // starts from o th element to
												// last but one element

			int min_idx = i; // comparision occurs with ith element

			for (int j = i + 1; j < length; j++) { // this starts from i+1 array
													// and till last elemnt

				if (arr[j] < arr[min_idx])
					min_idx = j;
			}

			swap(arr, i, min_idx);
		}

		print(arr);

	}

	private void swap(int[] arr, int i, int min_idx) {
		int temp = arr[min_idx];
		arr[min_idx] = arr[i];
		arr[i] = temp;
	}

	void bubbleSort(int[] arr) {

		int length = arr.length;
		for (int i = 0; i < length - 1; i++) {

			for (int j = 0; j < length - 1 - i; j++)

			{

				if (arr[j] > arr[j + 1]) {
					int temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;
				}
			}
		}

		print(arr);
	}

	void recursiveBubbleSort(int[] arr, int len) {

		if (len == 1) {
			print(arr);
			return;
		}

		for (int j = 0; j < len - 1; j++) // do recursion and move it to right
											// most part
		{
			if (arr[j] > arr[j + 1]) {
				int temp = arr[j + 1];
				arr[j + 1] = arr[j];
				arr[j] = temp;

			}
		}
		recursiveBubbleSort(arr, len - 1);
	}

	void mergeSort(int[] arr, int left, int right) {
		if (left < right) {
			// find middle

			int middle = (left + right) / 2;
			// do left half

			mergeSort(arr, left, middle);

			// do right half

			mergeSort(arr, middle + 1, right);
			// merge

			mergeOfMergeSort(arr, left, middle, right);
		}
	}

	void mergeOfMergeSort(int[] arr, int left, int middle, int right) {
		int len1Arr = middle - left + 1; // as index starts with 0; <------- imp
		int len2Arr = right - middle;

		int[] t1 = new int[len1Arr];
		int[] t2 = new int[len2Arr];

		// copy the original arrays

		for (int i = 0; i < len1Arr; i++) {
			t1[i] = arr[left + i];
		}

		for (int i = 0; i < len2Arr; i++) {
			t2[i] = arr[middle + 1 + i];
		}

		int first = 0;
		int second = 0;
		int dest = left; // this has to be left index not the zero

		while (first < len1Arr && second < len2Arr) {

			if (t1[first] < t2[second]) {
				arr[dest] = t1[first];
				first++;
			} else {
				arr[dest] = t2[second];
				second++;
			}

			dest++;
		}

		// copy remaining elements

		while (first < len1Arr) {
			arr[dest] = t1[first];
			first++;
			dest++;
		}

		while (second < len2Arr) {
			arr[dest] = t2[second];
			second++;
			dest++;
		}

	}
	
	void quickSort(int []arr , int low , int high )
	{
		
		if ( low<high )
				{
					
			       int partition = partition(arr, low, high);			       
			       quickSort(arr, low, partition-1);
			       quickSort(arr, partition+1, high);
			       
				}
		
	}

	int partition(int[] arr, int low, int high)

	{
		int i = low - 1;
		int pivot = arr[high];

		for (int j = low; j < high; j++) {

			if (arr[j] <= pivot) {
				swap(arr, j, i+1);
				i++;
			}

		}

		swap(arr, i + 1, high);

		return i + 1;

	}

	void print(int[] arr) {

		for (int value : arr) {
			System.out.println(value);
		}
	}

}
