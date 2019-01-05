package com.vip.concurrent;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
	public static void main(String[] args) throws Exception {
		CountDownLatch cdl = new CountDownLatch(3);
		
		new Thread(new T3(cdl)).start();
		new Thread(new T4(cdl)).start();
		new Thread(new T5(cdl)).start();
		//await�����������������֪��cdl�е����ֱ��ݼ�Ϊ0�Ż��ͷ�����
		cdl.await();
		Thread.sleep(1000);
		System.out.println("���ˣ����Կ�ʼ�����ˣ�����~");
	}
}

/**
 * ���
 */
class T5 implements Runnable{
	private CountDownLatch cdl = null;
	public T5(CountDownLatch cdl) {
		this.cdl = cdl;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(3000);
			System.out.println("T5�߳���������ˣ�����~");
			// Countdown()������ִ��һ����ֵ��1
			cdl.countDown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
/**
 * ����
 */
class T4 implements Runnable{
	private CountDownLatch cdl = null;
	public T4(CountDownLatch cdl) {
		this.cdl = cdl;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(2000);
			System.out.println("T4�߳����׻����ˣ�����~");
			cdl.countDown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
/**
 * ���
 */
class T3 implements Runnable{
	private CountDownLatch cdl = null;
	public T3(CountDownLatch cdl) {
		this.cdl = cdl;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
			System.out.println("T3�߳���˻����ˣ�����~");
			cdl.countDown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}