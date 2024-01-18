package java8.functionalInterface;

public class ImplJava7 implements MyInterface{

	public static void main(String[] args) {
		MyInterface mi = new ImplJava7();
		System.out.println(mi.add(5,50));
	}

	@Override
	public int add(int a, int b) {
		return a+b;
	}

}
