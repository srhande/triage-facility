/**File Header: This file is similar to the Heap.java file. The difference is that these implementations are for a String heap. We use the compareTo method of the String class to compare the priorities of the Strings.
 *@author Samruddhi Hande Email: shande@ucsd.edu */
package com.cse.ds.sorting;

import java.util.Arrays;

import com.cse.ds.heaps.Tuple;

/**
 * 
 * @author harsh
 *
 */
/**Class Header: In this class, we implement the methods for handling and manipulating a String heap. I used the same instance variables here and pretty similar method implementations as well. */
public class StringHeap {
	
	private String[] data; //stores data in accordance with heap rules
	private int last_idx; //keeps track of last index where an element was inserted
	private int size; //size of heap
	
    //construct empty heap
	public StringHeap() {
		// TODO Auto-generated constructor stub
		data = new String[1];
		last_idx = 0;
		size = 0;
	}
	
	/**
	 * Create a heap out of an array of Strings.
	 * @param arr - array of Strings used to create heap
	 */
	public StringHeap(String arr[]) {
		// TODO: Implementation here
		data = new String[arr.length + 1];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == null) {
				throw new IllegalArgumentException("array element is null");
			}
			data[i+1] = arr[i];
		}
		last_idx = arr.length;
		size = arr.length;
		for (int i = size/2; i >= 1; i--) {
			heapify(i);
		}
		
	}
	
	/**
	 * This corrects a single violation at position i, if left and right 
	 * subtrees are max heaps.
	 * @param i - position to be heapified
	 */
	public void heapify(int i) {
		// TODO: Implementation here
		int leftChild = 2*i;
		int rightChild = (2*i)+1 ;
		int largest = i;
		//System.out.println(largest);
		//System.out.println(size);
        //if value of index i is out of bounds, throw IllegalArgumentException
		if (i > data.length) {
			throw new IllegalArgumentException("Cannot Heapify index greater than heap size.");
		}
		//System.out.println(this);
        //check if leftChild is in bounds and compare the data
		if (leftChild < data.length && (data[leftChild].compareTo(data[largest]) >= 0)) {
			largest = leftChild;
			//System.out.println(largest);
		}
        //check if rightChild is in bounds and compare the data
		if (rightChild < data.length && (data[rightChild].compareTo(data[largest]) >= 0)) {
			largest = rightChild;
			//System.out.println(largest);
		}
		//System.out.println(largest);
        //heapify is a recursive function
		if (largest != i) {
			String temp = data[i];
			data[i]= data[largest];
			data[largest] = temp;
			heapify(largest);
		}
	}
	
	/**
	 * This function returns the max element from the heap without removing 
	 * the element from heap.
	 * @return the max String element - data[1]
	 */
	public String getMax() {
		// TODO: Implementation here
		return data[1];
	}
	
	/**
	 * This function removes and returns the max element from the heap
	 * @return the max element from heap - maxString
	 */
	public String heappop() {
		// TODO: Implementation here
		if (size < 1) {
			return null;
		}
		//System.out.println(this);
		String maxString = data[1];
		data[1] = data[size];
		data[size] = "";
		//size--;
		last_idx--;
		//heapify(1);
		size--;
		heapify(1);
		//System.out.println(this);
		return maxString;
	}

	/**
	 * This function returns the size of the heap.
	 * @return size - size of heap
	 */
	public int getSize()
	{
		// TODO: Implementation here
		return size;
	}
		
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return Arrays.toString(data);
	}
}
