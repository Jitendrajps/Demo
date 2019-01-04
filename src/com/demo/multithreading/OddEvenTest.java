package com.demo.multithreading;

public class OddEvenTest {

	public static void main(String args[]) {
		
		Printer printerObj = new Printer();
		
		Thread evenThread = new EvenThread(printerObj,10,"EvenThread");
		Thread oddThread = new OddThread(printerObj,10,"OddThread");
		
		evenThread.start();
		oddThread.start();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		
		System.out.println("Main Thread End");
		
	}

}
