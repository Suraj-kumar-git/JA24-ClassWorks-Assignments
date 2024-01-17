package all.strings;

public class DifferentStrings {

	public static void main(String[] args) {
		String str1 = "Suraj";
		StringBuilder sbstr1 = new StringBuilder("SB-Suraj");
		StringBuffer sbfstr1 = new StringBuffer("SBF-Suraj");
		String str2="SB-Suraj";
		StringBuilder sbstr2 = new StringBuilder("SB-Suraj");
		System.out.println(sbstr1==sbstr2); //false
		System.out.println(sbstr1.equals(sbstr2)); //false
		System.out.println(str1.equals(sbstr2)); //false
		System.out.println(sbstr1.equals(str2)); //false
		String str3="Suraj";
		System.out.println(str1==str3); //true
		System.out.println(str1.equals(str3)); //true
		String str4= new String("Suraj");
		System.out.println(str1==str4); //false
		System.out.println(str1.equals(str4)); //true
		String str5 = new String("Suraj").intern();// Explicitly interning the string
		System.out.println(str5);
		System.out.println(str1==str5); //true
		System.out.println(str1.equals(str5)); //true
	}

}
