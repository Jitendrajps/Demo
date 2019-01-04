package com.demo.datastructure.linkedlist;


public class SingleLinkedList {

	Node head;

	static class Node {
		int data; 
		Node next; 

		Node(int d){
			data = d;
			next = null;			
		}
	}

	public static void main(String args[]) {
		//creat linkedlist with empty node
		SingleLinkedList llist = new SingleLinkedList();

		//create the four nodes
		llist.head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		Node fourth = new Node(4);


		llist.head.next = second; // Link first node with the second node 
		second.next = third;// Link second node with the third node 
		third.next = fourth;// Link third node with the fourth node 
		
		// add the data into front of linkedlist
		llist.push(0);
		llist.insertAfter(second, 5);
		llist.appendAtLast(7);
		// Traverse the list
		llist.printList();

	}

	/*this function add the new node into linkedlist*/
	private void push(int new_data) { 
		Node new_node = new Node(new_data);
		new_node.next = head;
		head = new_node;
	}
	
	/*this function add the new node into linkedlist*/
	private void insertAfter(Node prev_node, int new_data) { 
		
		if(prev_node == null) {
			System.out.println("previous node cannot be null");
			return;
		}
		Node new_node = new Node(new_data);
		new_node.next = prev_node.next;
		prev_node.next = new_node;
	}
	
	public void appendAtLast(int new_data) {
		
		Node new_node = new Node(new_data);
		
		if(head==null) {
			head = new Node(new_data);
			return;
		}
		
		new_node.next = null;
		
		Node last = head;
		while(last.next!=null)
			last = last.next;
		
		last.next = new_node;
	}
	
	/*this function traverse the linkedlist*/
	private void printList() {
		Node node = head;

		while(node!=null) {
			System.out.println("Data is:"+node.data);
			node = node.next;
		}
	}
}
