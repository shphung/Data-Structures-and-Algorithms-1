//
//	Name: Phung, Steven
//	Project: 1
//	Due: 10/16/17
//	Course: cs-240-01-f17
//	
//	Description:
//		Implementation of classes ArrayBag, BagInterface, and ArrayBagTest, with a main in ArrayBagTest that will run through all features in the ADT.
//
package Project1_ArrayBag;

public interface BagInterface<T> {

	//Get current number of entries in bag.
	public int getCurrentSize();
	
	//Sees if bag is empty.
	public boolean isEmpty();
	
	//Adds a new entry to the bag.
	public boolean add(T newEntry);
	
	//Removes an unspecified entry from the bag.
	public T remove();
	
	//Removes one occurence of a given entry from the bag if possible.
	public boolean remove(T anEntry);
	
	//Removes all entries from the bag.
	public void clear();
	
	//Counts how many times an entry appears in the bag.
	public int getFrequencyOf(T anEntry);
	
	//Tells whether or not the bag has a specified entry.
	public boolean contains(T anEntry);
	
	//Retrieves all data and reallocates them into an array.
	public T[] toArray();
}