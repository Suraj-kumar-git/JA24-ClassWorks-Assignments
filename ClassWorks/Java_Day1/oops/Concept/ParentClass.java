package oops.Concept;

public class ParentClass {
	int pid=100;
	
	public ParentClass() {
		super(); //Can also be written by the compiler if we don't write. This will call the immediate parent class. This time Object class
		System.out.println("ParentClass object created..");
	}
	
	public void m1() {
		System.out.println("m1() is called from parent");
	}
}
