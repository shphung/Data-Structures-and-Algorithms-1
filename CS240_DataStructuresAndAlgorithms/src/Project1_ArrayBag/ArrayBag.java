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

public final class ArrayBag<T> implements BagInterface<T> {

	private final T[] bag;
	private int numberOfEntries;
	private static final int DEFAULT_CAPACITY = 25;
	
	public ArrayBag() {
		this(DEFAULT_CAPACITY);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayBag(int customCapacity) {
		T[] tempbag = (T[])new Object[customCapacity];
		bag = tempbag;
		numberOfEntries = 0;
	}
	
	public int getCurrentSize() {
		return numberOfEntries;
	}
	
	public boolean isEmpty() {
		return (numberOfEntries == 0);
	}
	
	public boolean add(T newEntry) {
		boolean result = true;
		bag[numberOfEntries] = newEntry;
		numberOfEntries++;
		return result;
	}
	
	public T remove() {
		T removedEntry = null;
		if(numberOfEntries > 0) {
			removedEntry = bag[numberOfEntries];
			bag[numberOfEntries] = null;
			numberOfEntries--;
		}
		return removedEntry;
	}
	
	public boolean remove(T anEntry) {
		boolean remove = false;
		int index = 0;
		while((index < numberOfEntries) && (!anEntry.equals(bag[index]))) {
			index++;
		}
		if((index == numberOfEntries) && (!anEntry.equals(bag[index]))) {
			return remove;
		} else if((index < numberOfEntries) && (anEntry.equals(bag[index]))) {
			bag[index] = bag[numberOfEntries];
			bag[numberOfEntries] = null;
			numberOfEntries--;
			remove = true;
		}
		return remove;
	}
	
	public void clear() {
		while(!isEmpty()) {
			remove();
		}
	}
	
	public int getFrequencyOf(T anEntry) {
		int frequency = 0;
		int index = 0;
		while(index <= numberOfEntries) {
			if(anEntry.equals(bag[index])) {
				frequency++;
			}
			index++;
		}
		return frequency;
	}
	
	public boolean contains(T anEntry) {
		boolean found = false;
		for(int i = 0; i < numberOfEntries; i++) {
			if(anEntry.equals(bag[i])) {
				found = true;
			} 
			i++;
		}
		return found;
	}
	
	@SuppressWarnings("unchecked")
	public T[] toArray() {
		T[] result = (T[])new Object[numberOfEntries];
		int index1 = 0;
		int index2 = 0;
		
		while((index1 < numberOfEntries) && (bag[index2] != null)) {
			result[index1] = bag[index2];
			index1++;
			index2++;
		}
		return result;
	}
}
