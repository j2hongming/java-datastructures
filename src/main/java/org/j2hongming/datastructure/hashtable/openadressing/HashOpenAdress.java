package org.j2hongming.datastructure.hashtable.openadressing;

import org.j2hongming.datastructure.hashtable.QuadraticProbing;
import org.j2hongming.datastructure.hashtable.openadressing.Node;

/**
 * @author Chiu CC
 * @see http://alrightchiu.github.io/SecondRound/hash-tableopen-addressing.html
 */
public class HashOpenAdress implements QuadraticProbing {

	private int tablesize;
	private int count;
	private Node[] hashtable;

	public HashOpenAdress(int m) {
		super();
		this.tablesize = m;
		this.count = 0;
		hashtable = new Node[m];
		for (int i = 0; i < m; i++) {
			hashtable[i] = null;
		}
	}

	/**
	 * OpenAdress的關鍵操作
	 */
	public int quadraticProbing(int key, int i) {
		double c1 = 0.5;
		double c2 = 0.5;
		return ((int) ((key % tablesize) + c1 * i + c2 * i * i) % tablesize);
	}

	public void insert(Node data) {
		int probingCount = 0;

		while (probingCount < this.tablesize) {
			int slotIdx = quadraticProbing(data.getKey(), probingCount);

			if (this.hashtable[slotIdx] == null) {
				this.hashtable[slotIdx] = data;
				this.count++;
				return;
			} else {
				probingCount++;
			}
		}

		throw new RuntimeException("Hash Table Overflow\n");
	}

	public void delete(int key) {
		int probingCount = 0;

		while (probingCount < this.tablesize) {
			int slotIdx = quadraticProbing(key, probingCount);

			if (this.hashtable[slotIdx].getKey() == key) {
				this.hashtable[slotIdx] = null;
				this.count--;
				return;
			} else {
				probingCount++;
			}
		}

		throw new RuntimeException("...data not found\n");
	}

	public String search(int key) {
		int probingCount = 0;

		while (probingCount < this.tablesize) {
			int slotIdx = quadraticProbing(key, probingCount);
			Node current = this.hashtable[slotIdx];
			if (current != null && current.getKey() == key) {
				return current.getValue();
			} else {
				probingCount++;
			}
		}

		throw new RuntimeException("...data not found\n");
	}

	public void showTable() {
		for (int slotIdx = 0; slotIdx < this.hashtable.length; slotIdx++) {
			System.out.print("slot# " + slotIdx);
			if(this.hashtable[slotIdx] != null){		
				System.out.print("(" + this.hashtable[slotIdx].getKey() + ", " + this.hashtable[slotIdx].getValue() + ")");
			}
			else{
				System.out.print("null");
			}
			System.out.println();
		}
	}

	public void showSearchResult(int key) {
		System.out.println(this.search(key));
	}
}
