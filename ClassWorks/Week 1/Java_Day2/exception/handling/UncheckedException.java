package exception.handling;

public class UncheckedException {
	static String str;
	public static void main(String[] args) {
		int result=0;
		try {
//			result=10/0; This time second Exception NullPointerException is catched; result is commented;
//			int length=str.length(); This time ArithmeticException is catched as length is commented;
			result=10/0;
		}catch(NullPointerException e) {
			System.out.println("NullPointerException is Catched");
			e.printStackTrace();
		}catch(ArithmeticException e) {
			System.out.println("ArithmeticException is Catched");
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("This is finally block. This will always be executed.");
		}
	}
}
