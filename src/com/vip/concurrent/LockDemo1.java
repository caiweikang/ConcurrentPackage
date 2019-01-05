package com.vip.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo1 {
	
	public static String name = "����";
	public static String gender = "��"; 
	
	public static void main(String[] args) {
		
		Lock lock = new ReentrantLock();
		new Thread(new T17(lock)).start();
		new Thread(new T18(lock)).start();
	}
	
}

class T17 implements Runnable{
	private Lock lock = null;
	public T17(Lock lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		while(true){
			lock.lock();
			if ("����".equals(LockDemo1.name)) {
				LockDemo1.name = "��÷÷";
				LockDemo1.gender = "Ů";
			} else {
				LockDemo1.name = "����";
				LockDemo1.gender = "��";
			}
			lock.unlock();
		}
	}
	
}
class T18 implements Runnable{
	private Lock lock = null;
	public T18(Lock lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		while(true){
			lock.lock();
			System.out.println(LockDemo1.name + ":" +LockDemo1.gender);
			lock.unlock();
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
