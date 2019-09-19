package com.demo.multithreading;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{

	private BlockingQueue<Message> queue;

	public Producer(BlockingQueue<Message> queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() {
		try {
			for(int i=0;i<100; i++) {
				Message msg = new Message(""+i);
				Thread.sleep(i);
				queue.put(msg);
				System.out.println("Produced is:" + msg.getMessage());
			}
		}catch(InterruptedException ex) {
			ex.printStackTrace();
		}
		
		// adding end message into queue
		try {
			Message msg = new Message("exit");
			Thread.sleep(10);
			queue.put(msg);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
