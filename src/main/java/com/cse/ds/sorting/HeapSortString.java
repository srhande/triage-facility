/** File Header: This file is to sort the StringHeaps. We are given the option to  implement the Sorting interface in this file.
 *@author Samruddhi Hande Email: shande@ucsd.edu */
package com.cse.ds.sorting;

import com.cse.ds.heaps.Heap;
import com.cse.ds.heaps.Tuple;

/**
 * 
 * @author harsh
 *
 */
/**Class Header: This class is called HeapSortString and it implements the sorting interface. It does not have any instance variables. It contains the sort method that sorts the values in the array.*/
public class HeapSortString implements Sorting<String> {
	
    /** This method sorts the values in the array.
     @param array - String array to be sorted
     @param ascending - if true, sorted in ascending order; if false, sorted in descending order */
	@Override
	public void sort(String[] array, boolean ascending) {
		// TODO Auto-generated method stub
		StringHeap tempHeap = new StringHeap(array);
		if (!ascending) {
			for (int i = 0; i < array.length; i++) {
				array[i] = tempHeap.heappop();
				//System.out.println(tempHeap);
			}
			//print(array);
		} else {
			for (int i = array.length - 1; i >= 0; i--) {
				array[i] = tempHeap.heappop();
				//System.out.println(tempHeap);
			}
			//print(array);
		}
	}

}
