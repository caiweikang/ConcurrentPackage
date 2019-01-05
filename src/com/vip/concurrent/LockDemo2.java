package com.vip.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockDemo2 {
	
	public static String name = "ÀîÀ×";
	public static String gender = "ÄÐ"; 
	
	public static void main(String[] args) {
		
		ReadWriteLock lock = new ReentrantReadWriteLock();
		
		new Thread(new T19(lock)).start();
		new Thread(new T20(lock)).start();
		new Thread(new T20(lock)).start();
	}
	
}

class T19 implements Runnable{
	private ReadWriteLock lock = null;
	public T19(ReadWriteLock lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		while(true){
			lock.writeLock().lock();
			if ("ÀîÀ×".equals(LockDemo1.name)) {
				LockDemo1.name = "º«Ã·Ã·";
				LockDemo1.gender = "Å®";
			} else {
				LockDemo1.name = "ÀîÀ×";
				LockDemo1.gender = "ÄÐ";
			}
			lock.writeLock().unlock();
		}
	}
	
}
class T20 implements Runnable{
	private ReadWriteLock lock = null;
	public T20(ReadWriteLock lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		while(true){
			lock.readLock().lock();
			System.out.println(Thread.currentThread()+":"+LockDemo1.name + ":" +LockDemo1.gender);
			lock.readLock().unlock();
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
