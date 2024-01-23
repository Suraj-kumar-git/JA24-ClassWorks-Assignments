package oops.Concept;

public class ChildClass extends ParentClass {
	int cid=99;
	
	public ChildClass() {
		super(); //Can also be written by the compiler if we don't write. This will call the immediate parent class.
		System.out.println("ChildClass object created...");
	}
	
	public void m2() {
		System.out.println("m2() is called from Child..");
	}
	public String toString() {
		return "Child object printed...";
	}
	public static void main(String[] args) {
		ChildClass c1 = new ChildClass(); //First parent class constructor will be called using super().
		System.out.println(c1.toString());
	}
}
