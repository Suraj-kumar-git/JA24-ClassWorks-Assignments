package java8.functionalInterface;

@FunctionalInterface
public interface MyInterface {
//	public abstract int add(int a, int b);
	// OR
	int add(int a,int b);
	default void sub(int a, int b) {
		System.out.println(Math.abs(a-b));
	}
	default int sub2(int a,int b) {
		return Math.abs(a-b);
	}
	static void mul(int a, int b) {
		System.out.println(a*b);
	}
	static int mul2(int a, int b) {
		return a*b;
	}
	
}
