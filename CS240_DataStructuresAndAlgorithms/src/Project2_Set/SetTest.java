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

public class SetTest {

	public static void main(String[] args) {
		RequiredIO();
		
		//For each case: subset, union, intersection, and complement are tested.
		case1();
		case2();
		case3();
		case4();
		case5();
	}
	
	private static void RequiredIO() {
		System.out.println("S. Phung's Set ADT\n");
	}

	private static void case1() {
		System.out.println("Case 1: A and B are equal but distinct sets");
		System.out.println("*******************************************\n");
		
		LinkSet<Object> a = new LinkSet<>();
		a.add(3);
		a.add(2);
		a.add(1);
		LinkSet<Object> b = new LinkSet<>();
		b.add(3);
		b.add(1);
		b.add(2);
		
		System.out.println("A is: " + a.toString());
		System.out.println("B is: " + b.toString() + '\n');
		
		System.out.println("Set A contains a 1: " + a.contains(1));
		System.out.println("Set A contains a 5: " + a.contains(5) + '\n');
		
		System.out.println("A is equal to B: " + a.equals(b));
		System.out.println("B is equal to A: " + b.equals(a) + '\n');
		
		System.out.println("A is a subset of B: " + a.subset(b));
		System.out.println("B is a subset of A: " + b.subset(a) + '\n');
		
		System.out.println("A union B: " + a.union(b));
		System.out.println("A intersection B: " + a.intersection(b));
		System.out.println("A complement B: " + b.complement(a) + '\n');
		
		System.out.println("A is: " + a.toString());
		System.out.println("Size of A: " + a.getLength());
		System.out.println("Removing specific element '2' from A. " + a.remove(2));
		System.out.println("A is: " + a.toString());
		System.out.println("Size of A: " + a.getLength());
		System.out.println("Removing element from A.");
		a.remove();
		System.out.println("A is: " + a.toString());
		System.out.println("Size of A: " + a.getLength());
		System.out.println("Removing element from A.");
		a.remove();
		System.out.println("A is: " + a.toString());
		System.out.println("Size of A: " + a.getLength() + '\n');
	}

	private static void case2() {
		System.out.println("Case 2: A and B are such that they have different sizes but one is a subset of the other");
		System.out.println("****************************************************************************************\n");
		
		LinkSet<Object> a = new LinkSet<>();
		a.add(1);
		LinkSet<Object> b = new LinkSet<>();
		b.add(2);
		b.add(1);
		
		System.out.println("A is: " + a.toString());
		System.out.println("B is: " + b.toString() + '\n');
		
		System.out.println("Set A contains a 1: " + a.contains(1));
		System.out.println("Set A contains a 5: " + a.contains(5) + '\n');
		
		System.out.println("A is equal to B: " + a.equals(b));
		System.out.println("B is equal to A: " + b.equals(a) + '\n');
		
		System.out.println("A is a subset of B: " + a.subset(b));
		System.out.println("B is a subset of A: " + b.subset(a) + '\n');
		
		System.out.println("A union B: " + a.union(b));
		System.out.println("A intersection B: " + a.intersection(b));
		System.out.println("A complement B: " + b.complement(a) + '\n');
	}

	private static void case3() {
		System.out.println("Case 3: A and B are non-empty and different in size but have common elements");
		System.out.println("****************************************************************************\n");
		
		LinkSet<Object> a = new LinkSet<>();
		a.add(3);
		a.add(2);
		a.add(1);
		LinkSet<Object> b = new LinkSet<>();
		b.add(5);
		b.add(4);
		b.add(3);
		b.add(2);
		
		System.out.println("A is: " + a.toString());
		System.out.println("B is: " + b.toString() + '\n');
		
		System.out.println("Set A contains a 1: " + a.contains(1));
		System.out.println("Set A contains a 5: " + a.contains(5) + '\n');
		
		System.out.println("A is equal to B: " + a.equals(b));
		System.out.println("B is equal to A: " + b.equals(a) + '\n');
		
		System.out.println("A is a subset of B: " + a.subset(b));
		System.out.println("B is a subset of A: " + b.subset(a) + '\n');
		
		System.out.println("A union B: " + a.union(b));
		System.out.println("A intersection B: " + a.intersection(b));
		System.out.println("A complement B: " + b.complement(a) + '\n');
	}

	private static void case4() {
		System.out.println("Case 4: They are non-empty with nothing in common");
		System.out.println("*************************************************\n");
		
		LinkSet<Object> a = new LinkSet<>();
		a.add(1);
		LinkSet<Object> b = new LinkSet<>();
		b.add(3);
		b.add(2);
		
		System.out.println("A is: " + a.toString());
		System.out.println("B is: " + b.toString() + '\n');
		
		System.out.println("Set A contains a 1: " + a.contains(1));
		System.out.println("Set A contains a 5: " + a.contains(5) + '\n');
		
		System.out.println("A is equal to B: " + a.equals(b));
		System.out.println("B is equal to A: " + b.equals(a) + '\n');
		
		System.out.println("A is a subset of B: " + a.subset(b));
		System.out.println("B is a subset of A: " + b.subset(a) + '\n');
		
		System.out.println("A union B: " + a.union(b));
		System.out.println("A intersection B: " + a.intersection(b));
		System.out.println("A complement B: " + b.complement(a) + '\n');
	}

	private static void case5() {
		System.out.println("Case 5: One is non-empty and the other is empty");
		System.out.println("***********************************************\n");
		
		LinkSet<Object> a = new LinkSet<>();
		LinkSet<Object> b = new LinkSet<>();
		b.add(3);
		b.add(1);
		b.add(2);
		
		System.out.println("A is: " + a.toString());
		System.out.println("B is: " + b.toString() + '\n');
		
		System.out.println("Set A contains a 1: " + a.contains(1));
		System.out.println("Set A contains a 5: " + a.contains(5) + '\n');
		
		System.out.println("A is equal to B: " + a.equals(b));
		System.out.println("B is equal to A: " + b.equals(a) + '\n');
		
		System.out.println("A is a subset of B: " + a.subset(b));
		System.out.println("B is a subset of A: " + b.subset(a) + '\n');
		
		System.out.println("A union B: " + a.union(b));
		System.out.println("A intersection B: " + a.intersection(b));
		System.out.println("A complement B: " + b.complement(a) + '\n');
	}
}