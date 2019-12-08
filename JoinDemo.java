package com.indra.concurrency.concurrency;

/**
 * In this example, we are trying to explore join feature. As seen in the
 * example, we are trying to print statement"Finished the tasks" after thread 1
 * execution is completed (i.e thread 1 is dead). As soon as thread 1 goes into
 * dead state then the statement is executed, it do not wait for thread 2 to
 * complete.Suppose, if we want to print that statement after execution of both
 * threads, then add both 37 and 38 lines. So, join is powerful method if we
 * would like to do certain action after thread is completed with task/job (or
 * dies).
 *
 */
public class JoinDemo {
	public static void main(String[] args) {
		Thread thread1 = new Thread(new Runnable() {

			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("Thread 1 : " + i);
				}

			}

		});
		Thread thread2 = new Thread(new Runnable() {

			public void run() {
				for (int i = 0; i < 100; i++) {
					System.out.println("Thread 2 :" + i);
				}

			}

		});
		thread1.start();
		thread2.start();

		try {
			thread1.join();
			// thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Finished the tasks");
	}
}
