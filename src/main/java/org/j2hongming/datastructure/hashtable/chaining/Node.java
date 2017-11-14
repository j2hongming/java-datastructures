package org.j2hongming.datastructure.hashtable.chaining;

/**
 * @author Chiu CC
 * @see http://alrightchiu.github.io/SecondRound/hash-tablechaining.html
 */
public class Node {

	private int key;
	private String value;
	private Node next;
	
	public Node(){this.key = 0; this.value =""; next = null;}
	public Node(int key, String value) {
		super();
		this.key = key;
		this.value = value;
		this.next = null;
	}
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	
	
	
}
