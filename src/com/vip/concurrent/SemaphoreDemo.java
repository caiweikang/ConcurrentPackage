package com.vip.concurrent;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(3,true);
		
		for(int i=1;i<Integer.MAX_VALUE;i++){
			new Thread(new T11(semaphore,i)).start();
		}
		
	}
}

class T11 implements Runnable{
	private Semaphore semaphore = null;
	private int i;
	
	public T11(Semaphore semaphore,int i) {
		this.semaphore = semaphore;
		this.i = i;
	}
	
	@Override
	public void run() {
		try {
			semaphore.acquire();
			System.out.println("游客"+i+"得到了执行权限");
			Thread.sleep(i*1000);
			semaphore.release();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}