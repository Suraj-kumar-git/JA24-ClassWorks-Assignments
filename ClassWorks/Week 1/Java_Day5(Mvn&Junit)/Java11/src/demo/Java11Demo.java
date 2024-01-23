package demo;

public class Java11Demo {

	public static void main(String[] args) {
		String str="Suraj";
		System.out.println(str.isBlank()); //False
		String str2 = "  Suraj ";
		System.out.println("Original String: "+str2);
		System.out.println("Striping the string: "+str2.strip()+str2.length());
		System.out.println("Striping from left: "+str2.stripLeading()+str2.length());
		System.out.println("Striping from right: "+str2.stripTrailing()+str2.length());
	}

}
