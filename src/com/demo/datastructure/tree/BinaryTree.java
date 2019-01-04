package com.demo.datastructure.tree;

class Node{
	int data;
	Node left, right ;

	public Node(int data) 
	{ 
		this.data = data; 
		this.left = this.right = null; 
	} 

}

public class BinaryTree {

	Node root;

	BinaryTree(){
		root = null;
	}

	BinaryTree(int data){
		root = new Node(data);
	}

	public static void main(String args[]) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);

		tree.root.left = new Node(2);
		tree.root.right = new Node(3);

		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		
		System.out.println("inOrder traversal of binary tree is "); 
		tree.inorderTraverse();
		
		/*
		System.out.println("preOrder traversal of binary tree is "); 
		tree.preorderTraverse();
		
		System.out.println("postOrder traversal of binary tree is "); 
		tree.postorderTraverse();
		*/
	}

	int count = 0;
	private void inorderTraverse(Node node) {
		if(node==null) {
			return;
		}else {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			count ++;
			inorderTraverse(node.left);
			System.out.println("Count is:"+count);
			System.out.println(node.data);			
			inorderTraverse(node.right);
		}
	}
	
	private void preorderTraverse(Node node) {
		if(node==null) {
			return;
		}else {
			
			System.out.println(node.data);
			preorderTraverse(node.left);
			preorderTraverse(node.right);
		}
	}

	private void postorderTraverse(Node node) {
		if(node==null) {
			return;
		}else {
			
			postorderTraverse(node.left);
			postorderTraverse(node.right);
			System.out.println(node.data);
			
		}
	}
	
	
	void inorderTraverse(){
		inorderTraverse(root);   
	} 
	
	void preorderTraverse()  {     
		preorderTraverse(root);  
	} 
	
	void postorderTraverse(){     
		postorderTraverse(root);  
	} 

}


