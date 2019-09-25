/**File Header: This file implements a service where patients come into a hospiral and are queued. They are then see by doctors in the order of their priority. There are several methods implemented that help us achieve this task.
 *@author Samruddhi Hande Email: shande@ucsd.edu */
package com.cse.ds.hospital;

import com.cse.ds.heaps.Heap;
import com.cse.ds.heaps.Tuple;

/**
 * 
 * @author harsh
 *
 */
/**Class Header: This class creates the triage facility service and is called TriageFacility. It implements the methods required to handle it. There is one instance variable which is the heap of patients itself. */
public class TriageFacility {
	
	private Heap heap; //heap in which patients will be organized by priority.
	
    //initializes TriageFacility by constructing a generic heap where each element has a value (patient name) & an integer priority (patient's priority based on age)
	public TriageFacility(String[] patients) {
		//TODO: Implementation here
		this.heap = new Heap();
		for (int i = 0; i < patients.length; i++) {
			if (patients[i] == null) {
				throw new IllegalArgumentException("a patient is null");
			}
			String[] split = patients[i].split(":"); //name is split[0]
			int age = Integer.parseInt(split[1]); //age
			int priority = Math.abs(95-age);
			Tuple triage = new Tuple(priority, split[0]);
			heap.heappush(triage);
		}
	}
	
    /** removes and returns the patient with highest priority from the TriageFacility.
     *@return patient with highest priority */
	public String serviceNextPatient() {
		//TODO: Implementation here
        //if no patient is found, return null
		if (getTriageLength() == 0) {
			return null;
		}
		return (String) heap.heappop().value;
	}
	
    /** takes new patient string and adds to TriageFacility
     *@param - patient to be added to TriageFacility */
	public void addNewPatient(String patient) {
		//TODO: Implementation here
		if (patient == null) {
			throw new IllegalArgumentException("patient cannot be null");
		}
		String[] split = patient.split(":");
		int age = Integer.parseInt(split[1]);
		int priority = Math.abs(95-age);
		Tuple triage = new Tuple(priority, split[0]);
		heap.heappush(triage); //use heappush method to add patient
	}
	
    /** returns number of patients who still need to be serviced by TriageFacility */
	public int getTriageLength() {
		//TODO: Implementation here
		return heap.getSize();
	}
}
