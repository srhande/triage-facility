/**File Header: This file is the file that contains the implementation of a generic heap data structure. We define the methods we use to handle and manipulate our heap. The pseudocode algorithms provided in the writeup were used to inspire the implementations.
 *@author Samruddhi Hande Email: shande@ucsd.edu **/
package com.cse.ds.heaps;

import java.util.Arrays;

/**
 * 
 * @author harsh
 *
 */
/**Class Header: This class contains 3 instance variables, data, last_idx, and size. These are too keep track of our heap and the size of it.**/
public class Heap {
	
	private Tuple[] data; //This stores data in accordance with heap rules.
	private int last_idx; //This keeps track of last index where an element was inserted.
	private int size; //size of heap
	
	//create empty heap
	public Heap() {
		data = new Tuple[1];
		last_idx = 0;
		size = 0;
	}
	
	/**
	 * Create a heap out of an array of Tuples.
	 * @param arr - array of Tuples used to create heap
	 */
	public Heap(Tuple arr[]) {
		//TODO: Fill implementation
		data = new Tuple[arr.length + 1]; //create Tuple array of length arr
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == null) {
				throw new IllegalArgumentException("array element is null");
			}
			data[i+1] = arr[i];
		}
		last_idx = arr.length;
		size = arr.length;
		for (int i = size/2; i >= 1; i--) {
			heapify(i); //organize heap
		}
		
	}
	
	/**
	 * This corrects a single violation at position i, if left and right 
	 * subtrees are max heaps.
	 * @param i - position to be heapified
	 */
	public void heapify(int i) {
		//TODO: implement heapify
		int leftChild = 2*i;
		int rightChild = (2*i)+1 ;
		int largest = i;
        //check bounds of left child & compare priorities
		if (leftChild < data.length && data[leftChild].priority > data[largest].priority) {
			largest = leftChild;
		}
        //check bounds of right child & compare priorities
		if (rightChild < data.length && data[rightChild].priority > data[largest].priority) {
			largest = rightChild;
		}
        //heapify is a recursive function
		if (largest != i) {
			Tuple temp = data[i];
			data[i]= data[largest];
			data[largest] = temp;
			heapify(largest);
		}
	}
	
	/**
	 * This function returns the max element from the heap without removing 
	 * the element from heap.
	 * @return the max element without removing it from heap - data[1]
	 */
	public Tuple getMax() {
		//TODO: Fill implementation
		return data[1];
	}
	
	/**
	 * This function removes and returns the max element from the heap
	 * @return max element from heap - variable max
	 */
	public Tuple heappop() {
		//TODO: Fill implementation
        /**if there is nothing to pop, @return null*/
		if (size < 1) {
			return null;
		}
		Tuple max = data[1]; //assign the max to the root element
		data[1] = data[size]; //replace the root element with the last element
		data[size] = new Tuple (Integer.MIN_VALUE, null); //assign the last element with a minimum value
		last_idx--; //update last_idx
		size--; //decrement size since you removed one
		heapify(1); //put the top element where it should be
		return max;
	}
	
	/**
	 * This function increases the priority of a node.
	 * @param i - position of node whose priority needs to be increased
	 * @param priority - priority it needs to be increased to
	 */
	public void increasePriority(int i, int priority) throws IllegalArgumentException {
		if (priority < data[i].priority) {
			throw new IllegalArgumentException("Priority less than current");
		}
		data[i] = new Tuple(priority, data[i].value);
		while (i > 1 && (data[i/2].priority < data[i].priority)) {
			Tuple temp = data[i];
			data[i] = data[i/2];
			data[i/2] = temp;
			i = i/2;
		}
	}
	
	/**
	 * This function pushes a new element in the heap
	 * @param arg - element to be pushed
	 */
	public void heappush(Tuple arg) {
		//TODO: Fill implementation
		if (arg == null) {
			throw new IllegalArgumentException("cannot push null");
		}
		if(data.length == size + 1) {
			Tuple [] newData = new Tuple[data.length+1];
			for(int i = 1; i < data.length; i++) {
				newData[i] = data [i];
				last_idx = i;
			}
			data = newData;
		}
		last_idx++;
		size++;
		data[size] = new Tuple(Integer.MIN_VALUE, arg.value);
		increasePriority(size, arg.priority);
	}
	
	/**
	 * This function returns the size of the heap.
	 * @return last_idx - size of heap
	 */
	public int getSize()
	{
		//TODO: Fill implementation
		return last_idx;
	}
		
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return Arrays.toString(data);
	}
}
