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

public class Node<T> {

	//Generic field type keeps a reference of the element's data.
	private T data;
	//The link of the list, keeps track of node after first node.
	private Node<T> next;
	
	//Constructor that initializes a node with data but no reference for next.
	public Node(T data) {
		this(data, null);
	}
	
	//Constructor that initializes a node with both data and next references.
	public Node(T data, Node<T> next) {
		this.setData(data);
		this.setNextNode(next);
	}
	
	//Method that allows retrieval of a node's data.
	public T getData() {
		return data;
	}
	
	//Method that allows a node's data to be changed.
	public void setData(T data) {
		this.data = data;
	}
	
	//Method that allows you to obtain the node after the current node.
	public Node<T> getNextNode() {
		return next;
	}
	
	//Method that allows you to change the reference of next node to another node.
	public void setNextNode(Node<T> next) {
		this.next = next;
	}
}