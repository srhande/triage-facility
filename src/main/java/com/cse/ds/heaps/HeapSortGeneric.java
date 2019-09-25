/**File Header: This file is to sort the heap of generic elements. We implement the sorting method.
 *@author Samruddhi Hande Email: shande@ucsd.edu */
package com.cse.ds.heaps;

import com.cse.ds.heaps.Heap;
import com.cse.ds.heaps.Tuple;

/**
 * 
 * @author harsh
 *
 * @param <E>
 */
/**Class Header: This class contains the heap generic sorting method. The instance variables are data and priority. We use these to initialize the heap sorting algorithm with the data and the corresponding priority of the data. */
public class HeapSortGeneric<E> {
	
	private E[] data; //data
	private int[] priority; //corresponding priority
	
    //initialize data and priority
	public HeapSortGeneric(E[] data, int[] priority) {
		//TODO: Fill in implementation
		this.data = data;
		this.priority = priority;
		if (data.length != priority.length) {
			throw new IllegalArgumentException("Data and priority arrays are not same length");
		}
	}
	
	/**
	 * This method sorts the value and returns a new array
     * @param ascending - if true, order is ascending; if false, order is descending
	 * @return the sorted array of values
	 */
	public E[] sort(boolean ascending) {
		//TODO: Fill in implementation
		Heap tempHeap = new Heap();
		E[] sortedHeap = (E[]) new Object[data.length];
		for (int i = 0; i < data.length; i++) {
			Tuple dataTuple = new Tuple(priority[i], data[i]);
			tempHeap.heappush(dataTuple);
		}
		if (!ascending) {
			for (int i = 0; i < sortedHeap.length; i++) {
				sortedHeap[i] = (E) (tempHeap.heappop()).value;
			}
		} else {
			for (int i = sortedHeap.length - 1; i >= 0; i--) {
				sortedHeap[i] = (E) (tempHeap.heappop()).value;
			}
		}
		return sortedHeap;
	}
}
