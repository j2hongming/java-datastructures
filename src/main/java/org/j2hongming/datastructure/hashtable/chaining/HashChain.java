package org.j2hongming.datastructure.hashtable.chaining;

import java.util.ArrayList;
import java.util.List;

import org.j2hongming.datastructure.hashtable.HashFunction;

/**
 * @author Chiu CC
 * @see http://alrightchiu.github.io/SecondRound/hash-tablechaining.html
 */
public class HashChain implements HashFunction {

	private int tablesize;
	private int count;
	private Node[] hashtable;

	public HashChain(int m) {
		super();
		this.tablesize = m;
		this.count = 0;
		hashtable = new Node[m];
		for(int i = 0 ; i < m ; i++ ){
			hashtable[i] = null;
		}
	}

	/**
	 * Multiplication method
	 */
	public int hashFunction(int key) {
		double A = 0.6180339887;
		double frac = key * A - Math.floor(key * A);

		return (int) Math.floor(this.tablesize * frac);
	}

	/**
	 * Basic operation
	 */
	public void insert(Node data) {

		// get index of slot
		int index = hashFunction(data.getKey());

			if (this.hashtable[index]== null) {
				this.hashtable[index] = data;
			} else {
				Node firstNode = this.hashtable[index];
				data.setNext(firstNode);
				this.hashtable[index] = data;
			}

	}

	/**
	 * Basic operation
	 */
	public void delete(int key) {
		// get index of slot
		int index = hashFunction(key);
		Node current = this.hashtable[index];
		Node previous = null;

		while (current != null && current.getKey() != key) {
			previous = current;
			current = current.getNext();
		}

		// 1. data not found
		// 2. data found at first node in list
		// 3. data found at other position in list
		if (current == null) {
			System.out.println("Data Not Found");
			return;
		} else {
			if (previous == null) {
				this.hashtable[index] = current.getNext();
			} else {
				previous.setNext(current.getNext());
				current = null;
			}

		}

		this.count--;

	}

	/**
	 * Basic operation
	 */
	public String search(int key) {
		// get index of slot
		int index = hashFunction(key);
		Node current = this.hashtable[index];

		while (current != null) {
			if (current.getKey() == key) {
				return current.getValue();
			}
			current = current.getNext();
		}
		return "...no such data";
	}

	public void showTable() {
		for (int slotIdx = 0; slotIdx < this.hashtable.length; slotIdx++) {
			System.out.print("slot# " + slotIdx);
			if (this.hashtable[slotIdx] != null) {

				Node current = this.hashtable[slotIdx];
				while (current != null) {
					System.out.print("(" + current.getKey() + ", " + current.getValue() + ")");
					current = current.getNext();
				}
			}
			System.out.println();
		}
	}
	
	public void showSearchResult(int key){
		System.out.println( this.search(key) );
	}

}
