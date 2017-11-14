package org.j2hongming.datastructure.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Chiu CC
 * @see http://alrightchiu.github.io/SecondRound/binary-tree-traversalxun-fang.html
 * @see http://alrightchiu.github.io/SecondRound/binary-tree-jian-li-yi-ke-binary-tree.html
 */
public class BinaryTree {

	TreeNode root;

	public BinaryTree(){}
	public BinaryTree(String str){
		levelOrderConstruct(str);
	}
	
	public void levelOrderConstruct(String strData){
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		
		// root
		TreeNode current = new TreeNode(strData.substring(0, 1));
		this.setRoot(current);
		
		char[] data = strData.toCharArray();
		for ( int i = 1 ; i < data.length ; i++ ) {
			
			// current left child
			if (data[i] >= 65 && data[i] <= 90){
				TreeNode newNode = new TreeNode( String.valueOf(data[i]) );
				newNode.setParent(current);
				current.setLeftchild(newNode);
				q.add(newNode);
			}
			
			i++;
			if(i == data.length){break;}
			
			// current right child
			if (data[i] >= 65 && data[i] <= 90){
				TreeNode newNode = new TreeNode( String.valueOf(data[i]) );
				newNode.setParent(current);
				current.setRightchild(newNode);
				q.add(newNode);
			}
			current = q.poll();
		}
	}
	
	public void insertLevelOrder(String data){
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		TreeNode current = this.root;
		
		while( current != null ){
			if(current.getLeftchild() != null){
				q.add(current.getLeftchild());
			}
			else{
				TreeNode newNode = new TreeNode(data);
				newNode.setParent(current);
				current.setLeftchild(newNode);
				break;
			}
			
			if(current.getRightchild() != null){
				q.add(current.getRightchild());
			}
			else{
				TreeNode newNode = new TreeNode(data);
				newNode.setParent(current);
				current.setRightchild(newNode);
				break;
			}
			current = q.poll();
		}
	}
	
	public TreeNode getRoot() {
		return root;
	}

	// Traversal
	public void preOrder(TreeNode current){
		if( current != null ){
			current.showData(); // V
			preOrder(current.getLeftchild()); // L
			preOrder(current.getRightchild()); // R
		}
	}
	
	public void inOrder(TreeNode current){
		if( current != null ){
			inOrder(current.getLeftchild()); // L
			current.showData(); // V
			inOrder(current.getRightchild()); // R
		}
	}
	
	public void postOrder(TreeNode current){
		if( current != null ){
			postOrder(current.getLeftchild()); // L
			postOrder(current.getRightchild()); // R
			current.showData(); // V
		}
	}
	
	public void levelOrder(TreeNode root){
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		
		while( !q.isEmpty() ){
			TreeNode current = q.poll();
			current.showData();
			
			if( current.getLeftchild() != null ){
				q.add(current.getLeftchild());
			}
			if( current.getRightchild() != null ){
				q.add(current.getRightchild());
			}
		}
	}
	
	public TreeNode leftMost(TreeNode current){
		while( current.getLeftchild() != null ){
			current = current.getLeftchild();
		}
		return current;
	}
	
	public TreeNode rightMost(TreeNode current){
		while( current.getRightchild() != null ){
			current = current.getRightchild();
		}
		return current;	
	}
	
	public TreeNode inOrderSuccessor(TreeNode current){
		// Case 1: 存在右子樹，上到下
		if(current.getRightchild() != null){
			return this.leftMost(current.getRightchild());
		}
		
		// Case 2: 下到上，第一個非右子樹的節點
		TreeNode successor = current.getParent();
		while( successor != null && current.equals(successor.getRightchild()) ){
			current = successor;
			successor = successor.getParent();
		}
		return successor;
	}
	
	public TreeNode inOrderPredecessor(TreeNode current){
		// Case 1: 存在左子樹，上到下
		if(current.getLeftchild() != null){
			return this.rightMost(current.getLeftchild());
		}
		
		// Case 2:　下到上，第一個非左子樹的節點
		TreeNode successor = current.getParent();
		while( successor != null && current.equals(successor.getLeftchild()) ){
			current = successor;
			successor = successor.getParent();
		}
		return successor;
		
	}
	
	public void inOrderUsingParent(TreeNode root){
		// 若以inOrder方式Traversal的觀點來看，找到整個Tree中的第一個人
		TreeNode current = this.leftMost(root);
		
		while( current != null ){
			current.showData();
			current = this.inOrderSuccessor(current);
		}
	}
	
	public void inOrderReverseUsingParent(TreeNode root){
		// 若以inOrder方式Traversal的觀點來看，找到整個Tree中的最後一個人
		TreeNode current = this.rightMost(root);
		
		while( current != null ){
			current.showData();
			current = this.inOrderPredecessor(current);
		}
	}
	
	public void setRoot(TreeNode root) {
		this.root = root;
	}
	
	
}
