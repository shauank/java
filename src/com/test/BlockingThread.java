package com.test;

abstract class State implements Runnable {
	boolean state = true;

	public void toggleState() {
		this.state = !this.state;
	}
}

class MyThread1 extends State {

	MyThread2 myThread2;

	public void setAnotherThread(MyThread2 myThread2) {
		this.myThread2 = myThread2;
	}

	@Override
	public void run() {
//		while (this.state) {
			try {
				synchronized (this) {
					System.out.println("in 1");
//					this.myThread2.toggleState();
//					this.toggleState();
					this.wait();					
					synchronized (this.myThread2) {
						this.myThread2.notify();
					}
				}

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
//		}
	}
}

class MyThread2 extends State {

	MyThread1 myThread1;

	public void setAnotherThread(MyThread1 myThread1) {
		this.myThread1 = myThread1;
	}

	@Override
	public void run() {
//		while (this.state) {
			try {
				synchronized (this) {
					System.out.println("in 2");
					synchronized (this.myThread1) {
						this.myThread1.notify();
					}
					this.wait();
//					this.myThread1.toggleState();
//					this.toggleState();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
//		}
	}
}

public class BlockingThread {
	public static void main(String[] args) {
		MyThread1 myThread1 = new MyThread1();
		MyThread2 myThread2 = new MyThread2();
		myThread1.setAnotherThread(myThread2);
		myThread2.setAnotherThread(myThread1);

		myThread1.state = true;
		myThread2.state = false;

		Thread th1 = new Thread(myThread1);
		Thread th2 = new Thread(myThread2);
		th1.start();
//		myThread2.state = true;
		th2.start();
	}
}
