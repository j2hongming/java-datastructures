package org.j2hongming.datastructure.hashtable.openadressing;

import org.j2hongming.datastructure.hashtable.chaining.HashChain;

public class HashOpenAdressingApp {

	public static void main(String[] args) {

		HashOpenAdress hashOpenAdressApp = new HashOpenAdress(10);
		hashOpenAdressApp.insert( new Node(12, "Rabbit") );
		hashOpenAdressApp.insert( new Node(17, "Fish") );
		hashOpenAdressApp.insert( new Node(19, "Dog") );
		hashOpenAdressApp.insert( new Node(20, "Cat") );
		hashOpenAdressApp.insert( new Node(26, "Bird") );
		
		hashOpenAdressApp.showTable();
		
		hashOpenAdressApp.showSearchResult(12);
		hashOpenAdressApp.showSearchResult(17);
		
		hashOpenAdressApp.insert( new Node(99, "Horse") );
		hashOpenAdressApp.showTable();
		
		hashOpenAdressApp.delete(19);
		hashOpenAdressApp.showTable();
	}

}
