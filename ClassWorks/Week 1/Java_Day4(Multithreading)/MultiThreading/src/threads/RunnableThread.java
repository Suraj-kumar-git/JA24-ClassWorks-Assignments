package threads;

public class RunnableThread implements Runnable{

	public static void main(String[] args) {
		Runnable t1=new RunnableThread();
		Thread td = new Thread(t1);
		System.out.println(t1);
		System.out.println(td);
		td.start();
	}
	@Override
	public void run() {
		System.out.println("Thread started...");
	}
}
