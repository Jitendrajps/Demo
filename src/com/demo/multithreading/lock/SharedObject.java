package com.demo.multithreading.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedObject {
	
	Lock lock = new ReentrantLock();

	private int count = 0;
	
	// use lock() method
	public int increaseCounter() {
		lock.lock();
		try {
			count ++;
		}finally {
			lock.unlock();
		}
		return count;
	}
	
	// use tryLock() method
	public int decreaseCounter() throws InterruptedException {
		boolean islockAquired = lock.tryLock(1,TimeUnit.SECONDS);
		
		if(islockAquired) {
			try {
				count--;
			}finally {
				lock.unlock();
			}
		}
		
		return count;
	}
	
}
