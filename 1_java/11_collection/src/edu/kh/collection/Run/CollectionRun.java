package edu.kh.collection.Run;

import edu.kh.collection.model.service.CollectionService;

public class CollectionRun {
	
	public static void main(String[] args) {
		
		CollectionService cs = new CollectionService();
		
		cs.displayMenu();
//		cs.ex();
	}

}
