package com.demo.multithreading.lock;

public class LockTest {
	
	public static void main(String[] args) {
		SharedObject obj = new SharedObject();
		WorkerThread work = new WorkerThread("Thread1", obj);
		Thread t1 = new Thread(work);
		WorkerThread work1 = new WorkerThread("Thread1", obj);
		Thread t2 = new Thread(work1);
		
		t1.start();
		t2.start();
		
		
	}
	
}


