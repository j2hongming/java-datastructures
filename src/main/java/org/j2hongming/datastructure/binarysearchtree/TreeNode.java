package org.j2hongming.datastructure.binarysearchtree;


/**
 * @author Chiu CC
 * dictionary declaration
 */
public class TreeNode {

	TreeNode leftchild;
	TreeNode rightchild;
	TreeNode parent;
	int key;
	String data;
	
	
	public TreeNode(int key, String data) {
		super();
	    this.setKey(key);
		this.data = data;
		this.leftchild = null;
		this.rightchild = null;
		this.parent = null;
	}

	public void showData(){
		System.out.print(this.data+"("+this.key+")");
	}
	
	public TreeNode getLeftchild() {
		return leftchild;
	}

	public void setLeftchild(TreeNode leftchild) {
		this.leftchild = leftchild;
	}

	public TreeNode getRightchild() {
		return rightchild;
	}

	public void setRightchild(TreeNode rightchild) {
		this.rightchild = rightchild;
	}

	
	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public TreeNode getParent() {
		return parent;
	}

	public void setParent(TreeNode parent) {
		this.parent = parent;
	}
	
	
	
}
