package com.spring.di.springin5steps.sort;

import org.springframework.stereotype.Component;

import com.spring.di.springin5steps.SortAlgorithm;

@Component("bubbleSort")
// @Primary
public class BubbleSort implements SortAlgorithm {

	@Override
	public int[] sort(int[] array) {
		System.out.println("Bubble sort");
		int temp;
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - 1; j++) {
				if (array[j] > array[j + 1]) {
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		return array;
	}

}
