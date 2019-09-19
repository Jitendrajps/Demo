package com.demo.multithreading.lock;

public class WorkerThread implements Runnable{
	private String name;
	private SharedObject obj;
	
	public WorkerThread(String name, SharedObject obj) {
		this.name = name;
		this.obj = obj;
	}

	@Override
	public void run() {
		try {
			int count = obj.increaseCounter();
			System.out.println(this.name +" :: "+count);
			//Thread.sleep(1000);			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

}
