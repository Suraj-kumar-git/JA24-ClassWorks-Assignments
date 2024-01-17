package sorting.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Student {
	int sid;
	String name;
	int roll;
	static String school="CPPS";
	int totalmarks;
	int fees;
	
	Student(){
	}
	Student(int sid,String name,int roll,int totalmarks,int fees){
		this.sid=sid;
		this.name=name;
		this.roll=roll;
		this.totalmarks=totalmarks;
		this.fees=fees;
	}
	
	@Override
	public String toString() {
		return "SID: "+this.sid+", Name: "+this.name+", Roll: "+this.roll+", School: "+school+", Total marks: "+this.totalmarks+", Fees: "+this.fees;
	}
	
	public static void main(String[] args) {
		List<Student> students = new ArrayList<>();
		students.add(new Student(1,"Suraj",79,93,45000));
		students.add(new Student(2,"Palash",9,89,105000));
		students.add(new Student(3,"Aanchal",69,63,55000));
		students.add(new Student(4,"Ayushi",70,83,75000));
		students.add(new Student(5,"Sidhi",29,99,95000));
		
		Iterator<Student> itr = students.iterator();
		System.out.println("Before sorting students:\n");
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		Collections.sort(students,new SortByTotalMarks());
		System.out.println("\nAfter sorting the students according to their totalmarks:\n");
		itr=students.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		Collections.sort(students,new SortByName());
		itr=students.iterator();
		System.out.println("\nAfter sorting Students according to their name:\n");
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
	
}

class SortByTotalMarks implements Comparator<Student>{
	@Override
	public int compare(Student s1, Student s2) {
		return s1.totalmarks-s2.totalmarks;
	}
}

class SortByName implements Comparator{

	@Override
	public int compare(Object o1,Object o2) {
		Student s1 =(Student)o1;
		Student s2 = (Student)o2;
		return s1.name.compareTo(s2.name);
	}	
}
