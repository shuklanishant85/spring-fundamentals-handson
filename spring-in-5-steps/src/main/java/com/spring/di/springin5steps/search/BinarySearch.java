package com.spring.di.springin5steps.search;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.spring.di.springin5steps.SortAlgorithm;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BinarySearch implements Search {

	/**
	 * Autowiring by name
	 */
	@Autowired
	@Qualifier("quickSortAlgorithm")
	private SortAlgorithm bubbleSort;

	private static final Logger LOGGER = LoggerFactory.getLogger(BinarySearch.class);

	@Override
	public int search(int[] array, int num) {
		LOGGER.info("{}", bubbleSort);
		int[] sortedArray = bubbleSort.sort(array);
		return binarySearch(sortedArray, num, 0, sortedArray.length-1);
	}

	private int binarySearch(int[] array, int num, int start, int end) {
		int mid = (start + end)/2;
		if (num == array[mid]) {
			return mid;
		}
		if (num > array[mid]) {
			return binarySearch(array, num, mid+1, end);
		} else if (num < array[mid]){
			return binarySearch(array, num, start, mid-1);
		} else {
			return -1;
		}
	}

}
