package com.demo.jdk8.feature;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ForEachExample {

	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<Integer>();
		
		//putting value into a list
		for(int i=0; i<10; i++) {
			list.add(i);
		}

		// traverse the list through Iterator
		Iterator it = list.iterator();
		
		while(it.hasNext()) {
			System.out.println("Value of list is: "+it.next());
		}
		
		// forEach method implementation as a annonymous class
		list.forEach(new Consumer<Integer>() {
			public void accept(Integer k) {
				System.out.println("Value of list is: "+ k);
			}
		});
		// traversing with myConsumer class, seperate the logic
		MyConsumer action = new MyConsumer();
		list.forEach(action);
		
	}
}
	
	class MyConsumer implements Consumer<Integer>{

		@Override
		public void accept(Integer t) {
			System.out.println("Value of list is: " +t);
			
		}
		
	}


