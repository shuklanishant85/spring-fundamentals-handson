package com.spring.di.springin5steps.search;

public class IterativeSearch implements Search {

	@Override
	public int search(int[] array, int num) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == num) {
				return i;
			}
		}
		return -1;

	}

}
