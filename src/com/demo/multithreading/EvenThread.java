package com.demo.multithreading;

public class EvenThread extends Thread {
	
	private Printer printObj;
	private int maxNum = 0; 
	private String name = "";
	
	public EvenThread(Printer printObj, int maxNum, String name) {
		this.printObj = printObj;
		this.maxNum = maxNum;
		this.name = name;
	}
	
	public void run() {
		
		while(this.printObj.getCount()<=maxNum) {
			
			if(this.printObj.checkEven()) {
			//if(this.printObj.getCount()%2==0) {
				this.printObj.print(this.name);				
			}		
		}		
	}

}
