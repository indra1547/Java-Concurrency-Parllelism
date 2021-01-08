package com.indra.Java8.concurrency;

import java.util.ArrayList;
import java.util.List;

/*
 * Producer add 0,1,2,3,4,5 items in the list
 * Consumer removes item in the list.
 * Both methods runs in infinite loop
 * In this approach we will be using low 
 * level synchronization using wait and notify methods
 * */

public class ProducerConsumerDemo {
	
	private List<Integer> list = new ArrayList<>();
	private static final Integer UPPER_LIMIT = 5;
	private static final Integer LOWER_LIMIT = 0;
	
	private int value = 0;
	
	private final Object lock = new Object();
	
	public void consumer() throws InterruptedException {
		
		synchronized(lock) {
			
			while(true) {
				if(list.size() == LOWER_LIMIT) {
					System.out.println("Waiting for adding items");
					value = 0;
					lock.wait();
				}else {
					System.out.println("Removing item: " + list.remove(list.size()-1));
					lock.notify();
				}
				
				Thread.sleep(500);
			}
			
		}
		
	}
	
	public void producer() throws InterruptedException {
		
		synchronized(lock) {
			
			while(true) {
				if(list.size() == UPPER_LIMIT) {
					System.out.println("Waiting for removing items");
					lock.wait();
				}else {
					System.out.println("Adding items" + value);
					list.add(value);
					value++;
					//We can call notify here - The other will be notified only it is in
					//waiting status.
					lock.notify();
				}
				
				Thread.sleep(500);
			}
			
		}
		
	}

	public static void main(String[] args) {
		
		ProducerConsumerDemo process = new ProducerConsumerDemo();
		
		Thread t1 = new Thread(() -> {
			
			try {
				process.producer();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		Thread t2 = new Thread(() -> {
			
			try {
				process.consumer();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		t1.start();
		t2.start();

	}

}
