package com.vip.concurrent;

public class SynchronizedDemo {
	public static String name = "����";
	public static String gender = "��"; 
	
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
				if ("����".equals(SynchronizedDemo.name)) {
					SynchronizedDemo.name = "��÷÷";
					SynchronizedDemo.gender = "Ů";
				} else {
					SynchronizedDemo.name = "����";
					SynchronizedDemo.gender = "��";
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
