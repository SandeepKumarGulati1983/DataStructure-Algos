package com.DS.Tree;

import com.DS.Tree.BST.BinaryTree;

public class Main {

	public static void main(String[] args) {

		BinaryTree tree = new BinaryTree();

		Node a = new Node('A', 1);
		Node star = new Node('*', 2);
		Node plus = new Node('+', 4);
		Node b = new Node('B', 3);
		Node c = new Node('C', 5);
		Node twelve = new Node('x', 12);
		Node ten = new Node('x', 10);
		Node fifteen = new Node('x', 15);
		Node seven = new Node('x', 7);

		tree.insertChild(star);
		tree.insertChild(a);
		tree.insertChild(plus);
		tree.insertChild(b);
		tree.insertChild(c);
		tree.insertChild(twelve);
		tree.insertChild(ten);
		tree.insertChild(fifteen);
		tree.insertChild(seven);

//		tree.postOrder(star);
//		System.out.println("====================");
//		tree.preOrder(tree.rootNode);
//		System.out.println("====================");
//		tree.inOrder(tree.rootNode);

//		Node keyNode = tree.find(4);
		//Node keyNode = tree.delete(1); // No kid 
		//Node keyNode = tree.delete(5); // only right childs
		//Node keyNode = tree.delete(10);  // only left child
		Node keyNode = tree.delete(5);  // have both kids 
		
		if (keyNode == null) {
			System.out.println("key not exist in the tree");
		} else {
			System.out.println("parent /successor  : " + keyNode.data +" : left : " +keyNode.leftChild.data+" : right : " +keyNode.rightChild.data);
		}

	}

	// page - 386
	// static BinaryTree functionTree() {
	//
	//
	// //return tree;
	//
	// }

}
