package com.indra.java.concurrency;
/* Executing mutliple tasks with pool of threads */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceThreadPoolMultipleTask {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		Runnable task1 = new Runnable(){
			public void run(){
				System.out.println(Thread.currentThread().getName());
				System.out.println("Task1 started");
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Task1 end");
			}
		};
		Runnable task2 = ()->{
			System.out.println(Thread.currentThread().getName());
			System.out.println("Task2 started");
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Task2 end");
		};
		Runnable task3 = ()->{
			System.out.println(Thread.currentThread().getName());
			System.out.println("Task3 started");
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Task3 end");
		};
		executorService.submit(task1);
		executorService.submit(task2);
		executorService.submit(task3);
		executorService.shutdown();
		
	}

}
