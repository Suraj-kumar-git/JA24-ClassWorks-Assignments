package threads;

import java.util.Iterator;

public class ThreadDemo extends Thread{

	public static void main(String[] args) { //Green/JVM thread. This is main thread created by JVM.
		System.out.println("Welcome to multithreading");
		ThreadDemo t1 = new ThreadDemo();
//		System.out.println(t1);
		t1.start();
		for(int i=0;i<10;i++) {
			System.out.println("Main Thread");
		}
	}
// local variable: thread level
// instance variable: object level
// static variable: class level
	@Override
	public void run() {
//		System.out.println("run() is called");
		for(int i=0;i<10;i++) {
			System.out.println("Child Thread");
		}
	}

}
