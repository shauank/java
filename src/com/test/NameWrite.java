package com.test;

@Annotation
class MyNameThread1 implements Runnable {
	NameWrite nameWrite;
	MyNameThread2 myNameThread2;

	public MyNameThread1(NameWrite nameWrite) {
		this.nameWrite = nameWrite;
	}

	public void setMyNameThread2(MyNameThread2 myNameThread2) {
		this.myNameThread2 = myNameThread2;
	}

	@Override
	public void run() {
		while (!nameWrite.finishReading()) {
			synchronized (this) {
				System.out.println(Thread.currentThread().getName());
				System.out.println(this.nameWrite.getCharactor());
				synchronized (this.myNameThread2) {
					this.myNameThread2.notify();
				}
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

class MyNameThread2 implements Runnable {

	NameWrite nameWrite;
	MyNameThread1 myNameThread1;

	public MyNameThread2(NameWrite nameWrite) {
		this.nameWrite = nameWrite;
	}

	public void setMyNameThread1(MyNameThread1 myNameThread1) {
		this.myNameThread1 = myNameThread1;
	}

	@Override
	public void run() {
		while (!nameWrite.finishReading()) {
			synchronized (this) {
				System.out.println(Thread.currentThread().getName());
				System.out.println(this.nameWrite.getCharactor());
				synchronized (this.myNameThread1) {
					this.myNameThread1.notify();
				}
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}

public class NameWrite {

	public char[] nameArry;
	int position = 0;

	public static void main(String[] args) throws InterruptedException {
		String name = "My name is Shaunak";
		NameWrite nameWrite = new NameWrite();
		nameWrite.nameArry = name.toCharArray();

		MyNameThread1 myNameThread1 = new MyNameThread1(nameWrite);
		MyNameThread2 myNameThread2 = new MyNameThread2(nameWrite);
		myNameThread1.setMyNameThread2(myNameThread2);
		myNameThread2.setMyNameThread1(myNameThread1);

		Thread th1 = new Thread(myNameThread1);
		Thread th2 = new Thread(myNameThread2);

		th1.start();
		Thread.sleep(10);
		th2.start();
	}

	public synchronized boolean finishReading() {
		return position == nameArry.length;
	}

	public synchronized char getCharactor() {
		char chr = nameArry[position];
		position++;
		return chr;
	}
}
