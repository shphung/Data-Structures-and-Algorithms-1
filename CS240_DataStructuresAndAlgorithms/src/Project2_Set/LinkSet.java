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

public final class LinkSet<T> implements SetInterface<T>{
	
	//Keeps track of head node
	private Node<T> firstNode;
	//Keeps track of amount of elements in set list
	private int numberOfEntries;
	
	//Constructor to initialize the linked set.
	public LinkSet() {
		firstNode = null;
		numberOfEntries = 0;
	}
	
	//Get current number of entries in set.
	public int getLength() {
		return numberOfEntries;
	}
	
	//Sees if set is empty.
	public boolean isEmpty() {
		return (numberOfEntries == 0);
	}
	
	//Adds a new entry to the set.
	public boolean add(T newEntry) {
		boolean result;
		
		if(!contains(newEntry)) {
			Node<T> newNode = new Node<T>(newEntry);
			newNode.setNextNode(firstNode);
			firstNode = newNode;
			numberOfEntries++;
			result = true;
		} else {
			result = false;
		}
		return result;
	}
	
	//Removes an unspecified entry from the set.
	public T remove() {
		T removeNode = null;
		if(numberOfEntries > 0) {
			removeNode = firstNode.getData();
			firstNode.setNextNode(firstNode.getNextNode());
			numberOfEntries--;
		}
		return removeNode;
	}
	
	//Removes one occurrence of a given entry from the set if possible.
	public boolean remove(T anEntry) {
		if((firstNode.getNextNode() != null)) {
			Node<T> currentNode = firstNode.getNextNode();
			Node<T> previousNode = firstNode;
			while(currentNode != null) {
				if(currentNode.getData().equals(anEntry)) {
					previousNode.setNextNode(currentNode.getNextNode());
					currentNode.setNextNode(null);
					numberOfEntries--;
					return true;
				}
				previousNode = previousNode.getNextNode();
				currentNode = currentNode.getNextNode();
			}
		}
		return false;
	}
	
	//Removes all entries from the set.
	public void clear() {
		while(!isEmpty()) {
			remove();
		}
	}
	
	//Tells whether or not the set has a specified entry.
	public boolean contains(T anEntry) {
		boolean found = false;
		Node<T> currentNode = firstNode;
		
		while(!found && (currentNode != null)) {
			if(currentNode.getData().equals(anEntry)) {
				found = true;
			} else {
				currentNode = currentNode.getNextNode();
			}
		}
		return found;
	}
	
	//Retrieves all data and reallocates them into an array.
	@SuppressWarnings("unchecked")
	public T[] toArray() {
		Node<T> currentNode = firstNode;
		T[] result = (T[])new Object[numberOfEntries];
		int index = 0;
		
		while ((index < numberOfEntries) && (currentNode != null)) {
			result[index] = currentNode.getData();
			currentNode = currentNode.getNextNode();
		}
		return result;
	}
	
	//Returns true if both sets contain the same elements where order in either set does not count.
	public boolean equals(LinkSet<T> set) {
		if(this.getLength() == set.getLength()) {
			Node<T> currentNode = set.firstNode.getNextNode();
			for(int i = 0; i < set.getLength(); i++) {
				if(!contains(currentNode.getData())) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	//Returns true if every element in set A is in set B, false otherwise.
	public boolean subset(LinkSet<T> set) {
		if(numberOfEntries == 0) {
			return true;
		}
		Node<T> currentNode = firstNode;
		for(int i = 0; i < this.getLength(); i++) {
			if(!set.contains(currentNode.getData())) {
				return false;
			}
			currentNode = currentNode.getNextNode();
		}
		return true;
	}
	
	//Returns a set that contains all the elements in set A and B, but only lists duplicates once.
	public LinkSet<T> union(LinkSet<T> set) {
		LinkSet<T> unionSet = new LinkSet<T>();
		
		Node<T> currentNode = this.firstNode;
		for(int i = 0; i < this.getLength(); i++) {
			unionSet.add(currentNode.getData());
			currentNode = currentNode.getNextNode();
		}
		
		currentNode = set.firstNode;
		for(int i = 0; i < set.getLength(); i++) {
			if(!contains(currentNode.getData())) {
				unionSet.add(currentNode.getData());
			}
			currentNode = currentNode.getNextNode();
		}
		return unionSet;
	}
	
	//Returns a set containing only elements that are common to A and B, but no duplicates.
	public LinkSet<T> intersection(LinkSet<T> set) {
		LinkSet<T> intersectionSet = new LinkSet<T>();
		
		Node<T> currentNode = set.firstNode;
		for(int i = 0; i < set.getLength(); i++) {
			if(contains(currentNode.getData())) {
				intersectionSet.add(currentNode.getData());
			}
			currentNode = currentNode.getNextNode();
		}
		return intersectionSet;
	}
	
	//Returns a set containing only elements that are in A but not in B.
	public LinkSet<T> complement(LinkSet<T> set) {
		LinkSet<T> complementSet = new LinkSet<T>();
		
		Node<T> currentNode = set.firstNode;
		for(int i = 0; i < set.getLength(); i++) {
			if(!this.contains(currentNode.getData())) {
				complementSet.add(currentNode.getData());
			}
			currentNode = currentNode.getNextNode();
		}
		return complementSet;
	}
	
	//Returns a string of the object's state at any given moment.
	public String toString() {
		String s;
		
		if(numberOfEntries == 0) {
			return "{}";
		} else {
			s = "{";
			Node<T> currentNode = firstNode;
			for(int i = 0; i < numberOfEntries; i++) {
				if(i < numberOfEntries - 1) {
					s += currentNode.getData().toString() + ", ";
				} else {
					s += currentNode.getData().toString() + "}";
				}
				currentNode = currentNode.getNextNode();
			}
		}
		return s;
	}
}