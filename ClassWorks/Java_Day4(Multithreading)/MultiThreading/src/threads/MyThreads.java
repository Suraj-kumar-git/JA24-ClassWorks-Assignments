package threads;

public class MyThreads extends Thread{

	public static void main(String[] args) {
		MyThreads t1 = new MyThreads();
		t1.setPriority(MAX_PRIORITY);
		t1.setName("Child-1");
		System.out.println(t1);
		
		MyThreads t2 = new MyThreads();
		t2.setPriority(8);
		t2.setName("Child-2");
		System.out.println(t2);
		System.out.println("Inside main()");
		System.out.println("Child-1 alive: "+t1.isAlive());
		System.out.println("Child-2 alive: "+t2.isAlive());		
		t1.start();
		t2.start();
		System.out.println("Inside main()");
		System.out.println("Child-1 alive: "+t1.isAlive());
		System.out.println("Child-2 alive: "+t2.isAlive());
	}
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println(Thread.currentThread().getName());
		}
		System.out.println("Inside run()");
//		System.out.println("Child-1 alive: "+t1.isAlive());
//		System.out.println("Child-2 alive: "+t2.isAlive());
	}
}
