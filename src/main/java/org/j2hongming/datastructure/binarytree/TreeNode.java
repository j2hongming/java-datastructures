package org.j2hongming.datastructure.binarytree;

public class TreeNode {

	TreeNode leftchild;
	TreeNode rightchild;
	TreeNode parent;
	String data;
	
	public TreeNode(String data) {
		super();
		this.data = data;
		this.leftchild = null;
		this.rightchild = null;
		this.parent = null;
	}

	public void showData(){
		System.out.print(this.data);
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
