package synchronization;

public class Admissions implements Runnable {

	@Override
	public synchronized void run() {
		System.out.println("No of seats available: "+seats);
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		if(seats>0) {
			System.out.println("Seat allocated to "+Thread.currentThread().getName());
			seats--;
		}else {
			System.out.println("Better luck next time "+Thread.currentThread().getName());
		}
		System.out.println("Number of Seats left: "+seats);
	}
	int seats=1;
	public static void main(String[] args) {
		Runnable admission = new Admissions();
		Thread t1 = new Thread(admission,"Suraj");
		Thread t2 = new Thread(admission,"Aanchal");
		
		t1.start();
		t2.start();
		
	}

}
