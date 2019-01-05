package com.vip.concurrent;

public class SynchronizedDemo {
	public static String name = "ÀîÀ×";
	public static String gender = "ÄÐ"; 
	
	public static void main(String[] args) {
		new Thread(new T15()).start();
		new Thread(new T16()).start();
	}
	
}

class T16 implements Runnable{

	@Override
	public void run() {
		while(true){
			synchronized (SynchronizedDemo.class) {
				if ("ÀîÀ×".equals(SynchronizedDemo.name)) {
					SynchronizedDemo.name = "º«Ã·Ã·";
					SynchronizedDemo.gender = "Å®";
				} else {
					SynchronizedDemo.name = "ÀîÀ×";
					SynchronizedDemo.gender = "ÄÐ";
				}
			}
		}
	}
	
}
class T15 implements Runnable{
	
	@Override
	public void run() {
		while(true){
			synchronized (SynchronizedDemo.class) {
				System.out.println(SynchronizedDemo.name + ":" +SynchronizedDemo.gender);
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
