package com.spring.di.springin5steps.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.spring.di.springin5steps.SortAlgorithm;

@Component
@Qualifier("quickSortAlgorithm")
// @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class QuickSort implements SortAlgorithm {

	private static final Logger LOGGER = LoggerFactory.getLogger(QuickSort.class);

	private int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int l = low-1;
		for (int i = low; i < high; i++) {
			if (arr[i] <= pivot) {
				l++;
				swap(arr,l,i);
			}
		}
		swap(arr,l+1,high);
		return l+1;
	}

	private void quickSort(int[] arr, int l, int h) {
		if (l <= h) {
			int partition = partition(arr, l, h);
			quickSort(arr, l, partition-1);

			quickSort(arr, partition+1, h);
		}
	}

	@Override
	public int[] sort(int[] array) {
		LOGGER.info("{}", "Quick Sort");
		quickSort(array, 0, array.length - 1);
		return array;
	}

	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
