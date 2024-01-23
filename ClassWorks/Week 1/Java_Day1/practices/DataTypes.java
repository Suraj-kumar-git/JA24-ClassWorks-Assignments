package practices;

public class DataTypes {

	public static void main(String[] args) {
		int a=50;
		System.out.println(a); //50
		byte b =125;
		System.out.println(b); //125
		byte c = (byte)130;
		System.out.println(c); //-126
		b=(byte) a;
		System.out.println(b); //50
		int i = b;
		System.out.println(i); //50
		
		float f = 234.5342f;
		System.out.println(f); //234.5342
		double d =133242.2323121;
		System.out.println(d); //133242.2323121
		f=(float) d;
		System.out.println(f); //133242.23
		double e =2827328728.2827827383;
		System.out.println(e); //2.8273287282827826E9
		float g =(float) e;
		System.out.println(g); //2.82732877E9
	}

}
