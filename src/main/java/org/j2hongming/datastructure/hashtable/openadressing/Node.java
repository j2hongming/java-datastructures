package org.j2hongming.datastructure.hashtable.openadressing;

/**
 * @author Chiu CC
 * @see http://alrightchiu.github.io/SecondRound/hash-tableopen-addressing.html
 */
public class Node {

	private int key;
	private String value;
	
	public Node(){this.key = 0; this.value ="";}
	public Node(int key, String value) {
		super();
		this.key = key;
		this.value = value;
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
	
	
	
}
