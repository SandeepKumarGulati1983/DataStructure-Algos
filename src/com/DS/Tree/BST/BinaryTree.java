package com.DS.Tree.BST;

import com.DS.Tree.Node;

public class BinaryTree {

	public Node rootNode;
	StringBuffer preorderSB, postOrderSB, inOrderSB;

	public BinaryTree() {
		rootNode = null;

	}

	Node currentNode;

	public void insertChild(Node child) {

		if (rootNode == null) {
			rootNode = child;
			currentNode = rootNode;
		} else {

			while (currentNode != null) {
				if (currentNode.data < child.data) {

					if (currentNode.rightChild == null) {
						currentNode.rightChild = child;
						return;
					} else {
						currentNode = currentNode.rightChild;
					}
				} else {
					if (currentNode.leftChild == null) {
						currentNode.leftChild = child;
						return;
					} else {
						currentNode = currentNode.leftChild;
					}
				}

			}
			/*
			 * =======Robert Lafore solution ======== with 2 variable parent and current
			 * node.
			 */

			// Node parentNode;
			// while (true) {
			// parentNode = currentNode;
			// if (currentNode.data < child.data) {
			// currentNode = currentNode.rightChild;
			// if (currentNode == null) {
			// parentNode.rightChild = child;
			// return;
			// }
			// } else {
			// currentNode = currentNode.leftChild;
			// if (currentNode == null) {
			// parentNode.leftChild = child;
			// return;
			// }
			// }
			//
			// }

		}

	}

	public Node find(int key) {

		Node cNode = rootNode;

		while (cNode != null) {

			if (key == cNode.data) {
				return cNode;
			} else if (key > cNode.data) {
				cNode = cNode.rightChild;
			} else
				cNode = cNode.leftChild;
		}

		return null;

	}

	public Node delete(int key) {

		/*
		 * 1. Need to check first that Node has no child 2. Node has only one child 3.
		 * Node has both left and right child
		 */

		Node deleteNode = find(key);
		Node parentNode = rootNode;
		Node currentNode = rootNode;
		boolean leftChild;

		if (key == rootNode.data) { // if we delete the root node
			Node successor = successor(deleteNode);
			successor.leftChild = deleteNode.leftChild;
			if (!successorHasNoLeft)
				successor.rightChild = deleteNode.rightChild;
			return successor;

		}

		while (true) {

			if (key > parentNode.data) {
				currentNode = parentNode.rightChild;
				leftChild = false;
			} else {
				currentNode = parentNode.leftChild;
				leftChild = true;
			}

			if (key == currentNode.data) {
				// ========================================
				if (deleteNode.leftChild == null && deleteNode.rightChild == null) {
					// No child
					if (leftChild) {
						parentNode.leftChild = null;
						return parentNode;
					} else {
						parentNode.rightChild = null;
						return parentNode;
					}
				} else if (deleteNode.leftChild == null) {
					// only right child
					if (leftChild) {
						parentNode.leftChild = currentNode.rightChild;
						return parentNode;
					} else {
						parentNode.rightChild = currentNode.rightChild;
						return parentNode;
					}

				} else if (deleteNode.rightChild == null) {
					// only left child
					if (leftChild) {
						parentNode.leftChild = currentNode.leftChild;
						return parentNode;
					} else {
						parentNode.rightChild = currentNode.leftChild;
						return parentNode;
					}
				} else {
					// have both child -- then need to choose successor.
					Node successor = successor(deleteNode);

					// Condition one -- is it a root node.

					if (leftChild) {
						parentNode.leftChild = successor;

					} else {
						parentNode.rightChild = successor;

					}

					successor.leftChild = deleteNode.leftChild;
					if (!successorHasNoLeft)
						successor.rightChild = deleteNode.rightChild;
					return successor;
				}

			} else {
				parentNode = currentNode;
			}
		}

	}

	boolean successorHasNoLeft = false;

	private Node successor(Node deleteNode) {

		Node current = deleteNode;
		Node parent = deleteNode;

		current = current.rightChild; // step 1 -- take first right
		if (current.leftChild == null) {
			successorHasNoLeft = true;
			return current;
		} else {
			while (true) { // Step 2 -- then extream left - loop
				parent = currentNode;
				current = current.leftChild;
				if (current.leftChild == null) {
					parent.leftChild = null;
					return current;
				}
			}
		}

	}

	// Traversal ======================

	public void preOrder(Node rootNode) {

		if (rootNode != null) {
			System.out.println("Node data : " + rootNode.data + " : Node Label : " + rootNode.label);
			preOrder(rootNode.leftChild);
			preOrder(rootNode.rightChild);
		} else {
			return;
		}

	}

	public void postOrder(Node rootNode) {

		if (rootNode != null) {
			postOrder(rootNode.leftChild);
			postOrder(rootNode.rightChild);
			System.out.println("Node data : " + rootNode.data + " : Node Label : " + rootNode.label);
		} else {
			return;
		}

	}

	public void inOrder(Node rootNode) {

		if (rootNode != null) {
			inOrder(rootNode.leftChild);
			System.out.println("Node data : " + rootNode.data + " : Node Label : " + rootNode.label);
			inOrder(rootNode.rightChild);

		} else {
			return;
		}

	}
}
