package com.indra.java.concurrency.ProducerConsumer;

import java.util.Queue;

public class Consumer implements Runnable {
	Queue<Integer> sharedQueue;

	Consumer(Queue<Integer> sharedQueue) {
		this.sharedQueue = sharedQueue;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (sharedQueue) {
				while (sharedQueue.isEmpty()) {
					try {
						System.out.println("Consumer is waiting to produce objects by Producer..");
						sharedQueue.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				int data = sharedQueue.poll();
				System.out.println("Consumed::" + data);
				sharedQueue.notify();
			}
		}

	}

}
