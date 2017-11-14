package org.j2hongming.datastructure.hashtable.chaining;

public class HashChainApp {

	public static void main(String[] args) {

		HashChain hashChainApp = new HashChain(3);
		hashChainApp.insert( new Node(12, "Rabbit") );
		hashChainApp.insert( new Node(17, "Fish") );
		hashChainApp.insert( new Node(19, "Dog") );
		hashChainApp.insert( new Node(20, "Cat") );
		hashChainApp.insert( new Node(26, "Bird") );
		
		hashChainApp.showTable();
		
		hashChainApp.showSearchResult(12);
		hashChainApp.showSearchResult(28);
		
		hashChainApp.insert( new Node(99, "Horse") );
		hashChainApp.showTable();
		
		hashChainApp.delete(19);
		hashChainApp.showTable();
	}

}
