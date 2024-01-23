package basics;

public class Student {
	int sid;
	String name;
	static String school;
	Student(){
		
	}
	Student(int id,String name){
		this.sid=id;
		this.name=name;
	}
	public void printStudent() {
		System.out.println("Student ID: "+this.sid+", Student Name: "+this.name+", School: "+this.school);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s1 = new Student();
		s1.sid=1;
		s1.name="Suraj";
		s1.school="CPPS";
		
		Student s2=new Student(2,"Palash");
		s1.printStudent();
		s2.printStudent();
		
	}

}
