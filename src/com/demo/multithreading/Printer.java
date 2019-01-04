package com.demo.multithreading;

public class Printer {

	private int count = 0; 
	
	public synchronized void print(String name) {		
		try {
			System.out.println(name+" :" + count);
			count = count + 1;
			wait(1000);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		notify();
	}

	public int getCount() {
		return count;
	}
	
	public synchronized boolean checkEven() {
		if(this.getCount()%2==0) {
			return true;
		}else {
			return false;
		}
	}
	
}
