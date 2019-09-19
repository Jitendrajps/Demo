package com.demo.multithreading;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{

	private BlockingQueue<Message> queue;
	
	public Consumer(BlockingQueue<Message> queue) {
		this.queue = queue;
	}
		
	@Override
	public void run() {
		try {
			while(!queue.take().getMessage().equals("exit")) {
				Thread.sleep(10);
				System.out.println("Consumed:" + queue.take().getMessage());
			}
		}catch(InterruptedException ex) {
			ex.printStackTrace();
		}
		
	}

}
