package com.indra.java.concurrency.ProducerConsumer;

import java.util.*;

public class ProducerConsumerClient {

	public static void main(String[] args) {
		Queue<Integer> sharedQueue = new LinkedList<Integer>();
		Producer producer = new Producer(sharedQueue);
		Consumer consumer = new Consumer(sharedQueue);
		Thread producerThread = new Thread(producer);
		Thread consumerThread = new Thread(consumer);
		producerThread.start();
		consumerThread.start();

	}

}
