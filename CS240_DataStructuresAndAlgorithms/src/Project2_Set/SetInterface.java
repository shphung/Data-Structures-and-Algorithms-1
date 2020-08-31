//
//	Name: Phung, Steven
//	Project: 2
//	Due: 10/25/17
//	Course: cs-240-01-f17
//	
//	Description:
//		Implementation of a Set ADT using a singly linked list that extends SetInterface.
//		A Set will not have duplicates.
//
package Project2_Set;

public interface SetInterface<T> {

	//Get current number of entries in set.
	public int getLength();
	
	//Sees if set is empty.
	public boolean isEmpty();
	
	//Adds a new entry to the set.
	public boolean add(T newEntry);
	
	//Removes an unspecified entry from the set.
	public T remove();
	
	//Removes one occurrence of a given entry from the set if possible.
	public boolean remove(T anEntry);
	
	//Removes all entries from the set.
	public void clear();
	
	//Tells whether or not the set has a specified entry.
	public boolean contains(T anEntry);
	
	//Retrieves all data and reallocates them into an array.
	public T[] toArray();

	//Returns true if both sets contain the same elements where order in either set does not count.
	public boolean equals(LinkSet<T> set);
	
	//Returns true if every element in set A is in set B, false otherwise.
	public boolean subset(LinkSet<T> set);
	
	//Returns a set that contains all the elements in set A and B, but only lists duplicates once.
	public LinkSet<T> union(LinkSet<T> set);
	
	//Returns a set containing only elements that are common to A and B, but no duplicates.
	public LinkSet<T> intersection(LinkSet<T> set);
	
	//Returns a set containing only elements that are in A but not in B.
	public LinkSet<T> complement(LinkSet<T> set);
	
	//Returns a string of the object's state at any given moment.
	public String toString();
}