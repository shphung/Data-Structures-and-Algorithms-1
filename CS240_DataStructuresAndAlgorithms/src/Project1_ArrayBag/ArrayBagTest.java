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

public class ArrayBagTest {

	public static void main(String[] args) {
		
		//Prints the required I/O
		printRequiredIO();
		
		//Tests the implementation of getCurrentSize, isEmpty, add, remove, remove specified object, clear, and getFrequencyOf.
		printTestRun1();
		
		//Tests the implementation of getCurrentSize, add, and toArray.
		printTestRun2();
	}

	private static void printRequiredIO() {
		System.out.println("S. Phung's Bag ADT");
	}

	private static void printTestRun1() {
		BagInterface<Object> testList1 = new ArrayBag<>();
		
		System.out.println("\nList 1's current size: " + testList1.getCurrentSize()
							+ "\nIs List 1 Empty? " + testList1.isEmpty()
							+ "\nAdding an integer 1 to the list. Success? " + testList1.add(1)
							+ "\nList 1's current size: " + testList1.getCurrentSize()
							+ "\nIs List 1 Empty? " + testList1.isEmpty()
							+ "\nAdding a character 'a' to the list. Success? " + testList1.add('a')
							+ "\nDoes List 1 contain an integer 1? " + testList1.contains(1)
							+ "\nAdding an integer 2 to the list. Success? " + testList1.add(2)
							+ "\nDoes List 1 contain an integer 3? Success? " + testList1.contains(3)
							+ "\nAdding the string 'watch' to the list three times. Success? \n	1." + testList1.add("watch")
							+ "\n	2." + testList1.add("watch") + "\n	3." +  testList1.add("watch")
							+ "\nHow many times does 'watch' appear in list 1? " + testList1.getFrequencyOf("watch")
							+ "\nList 1's current size: " + testList1.getCurrentSize()
							+ "\nNow removing 1 'watch' : " + testList1.remove("watch")
							+ "\nHow many times does 'watch' appear in list 1 now? " + testList1.getFrequencyOf("watch")
							+ "\nList 1's current size: " + testList1.getCurrentSize()
							+ "\nRemoving an element... Item removed: " + testList1.remove()
							+ "\nHow many times does 'watch' appear in list 1 now? " + testList1.getFrequencyOf("watch")
							+ "\nList 1's current size: " + testList1.getCurrentSize()
							+ "\nClearing entire list... ");
		testList1.clear();
		System.out.println("List 1's current size: " + testList1.getCurrentSize());
	}

	private static void printTestRun2() {
		BagInterface<String> testList2 = new ArrayBag<>(5);
		
		System.out.println("\n\nList 2's current size: " + testList2.getCurrentSize()
							+ "\nFilling list with strings...");
		System.out.println("Adding: 'Apple,' 'Bee,' 'Can,' 'Door,' 'Elephant.'");
		testList2.add("Apple");
		testList2.add("Bee");
		testList2.add("Can");
		testList2.add("Door");
		testList2.add("Elephant");
		System.out.println("List 2's current size: " + testList2.getCurrentSize());
		System.out.println("Converting list to array and printing out...");
		Object[] words = testList2.toArray();
		for(Object w : words) {
			System.out.println("Word is: " + w);
		}
	}
}