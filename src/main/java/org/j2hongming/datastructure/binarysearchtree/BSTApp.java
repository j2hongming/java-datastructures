package org.j2hongming.datastructure.binarysearchtree;

public class BSTApp {

	public static void main(String[] args) {

		// construct the Binary Search Tree
		BinarySearchTree BST = new BinarySearchTree();
		BST.insertBST(8, "龜仙人");
		BST.insertBST(1000, "悟空");
		BST.insertBST(2, "克林");
		BST.insertBST(513, "比克");
		
		// Traversal
		BST.inOrder(BST.getRoot());
        System.out.println();
		BST.levelOrder(BST.getRoot());
		
		// Search
		TreeNode searchNode = BST.search(1000);
		if(searchNode != null){
			System.out.println();
			System.out.print("Search Success! ");
			searchNode.showData();
			System.out.println();
		}
		else{
			System.out.println("Search Fail! ");
		}
		
		TreeNode searchNode2 = BST.search(77);
		if(searchNode2 != null){
			System.out.println("Search Success! ");
			searchNode2.showData();
		}
		else{
			System.out.println("Search Fail! ");
		}
		
		// Delete
		BST.deleteBST(8);
		// Traversal
		BST.inOrder(BST.getRoot());
        System.out.println();
		BST.levelOrder(BST.getRoot());
		
	}

}
