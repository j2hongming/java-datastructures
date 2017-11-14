package org.j2hongming.datastructure.binarysearchtree;

import java.util.LinkedList;
import java.util.Queue;

import org.j2hongming.datastructure.binarysearchtree.TreeNode;

/**
 * @author Chiu CC
 * @see http://alrightchiu.github.io/SecondRound/binary-search-tree-searchsou-xun-zi-liao-insertxin-zeng-zi-liao.html
 *
 */
public class BinarySearchTree {

	private TreeNode root;

	/**
	 * use key to find specific element
	 * @param key
	 * @return
	 * */
	public TreeNode search(int key){
		// Initialization 將curent指向root作為traversal起點
		TreeNode current = this.root;
		
		// 兩種情況跳出迴圈：搜尋成功, 搜尋失敗
		while( current != null && key != current.getKey() ){
			if( key < current.getKey() ){
				// Go Left
				current = current.getLeftchild();
			}
			else{
				// Go Right
				current = current.getRightchild();
			}
		}
		
		return current;
	}
	
	/**
	 * insert key-element in BST
	 * @param key
	 * @return
	 * */
	public void insertBST(int key, String element){
		// 準新手爸媽
		TreeNode readyParent = null;
		// 哨兵
		TreeNode sentinel = null;
		// 欲新增的節點
		TreeNode insertNode = new TreeNode(key, element);
		
		sentinel = this.root;
		
		// 開始移動哨兵
		while( sentinel != null ){
			readyParent = sentinel;
			if( insertNode.getKey() < sentinel.getKey() ){
				// Go Left
				sentinel = sentinel.getLeftchild();
			}
			else{
				// Go Right
				sentinel = sentinel.getRightchild();
			}
		}
		
		// 定位完成，開始新增
		insertNode.setParent(readyParent);
		
		// BST完全為空
		if(readyParent == null){
			this.root = insertNode;
		}
		else if( insertNode.getKey() < readyParent.getKey() ){
			readyParent.setLeftchild(insertNode);
		}
		else{
			readyParent.setRightchild(insertNode);
		}
		
	}
	
	/**
	 * delete key-element in BST
	 * @param key
	 * @return
	 * */
	public void deleteBST(int key){
		
		// Search the delete Node
		TreeNode delNode = this.search(key);
		// Search失敗
		if( delNode == null ){
			System.out.print("Search Fail! ");
			return;
		}
		
		TreeNode delNodeParent = delNode.getParent();
		
		// Case 1: 欲刪除之node沒有child pointer
		// Case 2: 欲刪除之node只有一個child pointer
		// Case 3: 欲刪除之node有兩個child pointer
		
		// Case 1: 欲刪除之node沒有child pointer
		if( delNode.getLeftchild() == null && delNode.getRightchild() == null ){
			
			if( delNode.getKey() < delNodeParent.getKey() ){
				delNodeParent.setLeftchild(null);
			}
			else{
				delNodeParent.setRightchild(null);;
			}
			delNode = null;
		}
		// Case 2: 欲刪除之node只有一個child pointer
		else if( delNode.getLeftchild() == null || delNode.getRightchild() == null ){
			if( delNode.getLeftchild() != null ){
				
				if( delNode.getKey() < delNodeParent.getKey() ){
					delNodeParent.setLeftchild( delNode.getLeftchild() );
				}
				else{
					delNodeParent.setRightchild( delNode.getLeftchild() );;
				}
				delNode = null;
			}
			else{
				if( delNode.getKey() < delNodeParent.getKey() ){
					delNodeParent.setLeftchild( delNode.getRightchild() );
				}
				else{
					delNodeParent.setRightchild( delNode.getRightchild() );;
				}
				delNode = null;
			}
			
		}
		// Case 3: 欲刪除之node有兩個child pointer
		else{
			TreeNode successor = this.inOrderSuccessor( delNode );
			
			// 找successor當替身
			TreeNode tmp = new TreeNode(successor.getKey(), successor.getData());
			// delNode.setKey(successor.getKey());
			// delNode.setData(successor.getData());
			
			// 處理successor, 回到Case 1 或是 Case 2
			deleteBST(successor.getKey());
			delNode.setKey(tmp.getKey());
			delNode.setData(tmp.getData());
		}
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
		// Case 1
		if(current.getRightchild() != null){
			return this.leftMost(current.getRightchild());
		}
		
		// Case 2
		TreeNode successor = current.getParent();
		while( successor != null && current.equals(successor.getRightchild()) ){
			current = successor;
			successor = successor.getParent();
		}
		return successor;
	}
	
	public TreeNode inOrderPredecessor(TreeNode current){
		// Case 1
		if(current.getLeftchild() != null){
			return this.rightMost(current.getLeftchild());
		}
		
		// Case 2
		TreeNode successor = current.getParent();
		while( successor != null && current.equals(successor.getLeftchild()) ){
			current = successor;
			successor = successor.getParent();
		}
		return successor;
		
	}
	
	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}
	
	
}
