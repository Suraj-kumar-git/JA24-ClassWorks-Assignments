package java8.functionalInterface;

import java.util.function.Function;

public class ImplJava8 {

	public static void main(String[] args) {
		MyInterface mi = (int a,int b)->{return a+b;};
		System.out.println(mi.add(5,5));
		mi.sub(10,5);
		System.out.println(mi.sub2(20,10));
		MyInterface.mul(4,5);
		System.out.println(MyInterface.mul2(6, 4));

		
		Function<String, Integer> intConvertor =  Integer::parseInt;
		System.out.println(intConvertor.apply("500"));
	}
}
