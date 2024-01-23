package collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class CollectionsPractice {

	public static void main(String[] args) {
		Set<Student> students = new HashSet<>();
		students.add(new Student(101,"King",90));
		students.add(new Student(102,"Suraj",80)); //This object and the object below are duplicate but since they are created using  new keyword , they got different hashcode and are not considered as duplicate by the jvm.
		//To avoid this insertion of duplicate elements in the Set we have overridden hashcode() and equals() in the Student class.
		students.add(new Student(102,"Suraj",80));
		students.add(new Student(103,"Palash",100));
		students.add(new Student(104,"Sheshank",50));
		students.add(new Student(105,"Ayushi",88));
		students.add(new Student(106,"Sidhi",70));
		
		Iterator<Student> itr = students.iterator();
		System.out.println("HashSet Elements:");
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		Set<Student> sortedStudents = new TreeSet<>(new MyComparator());
		sortedStudents.add(new Student(101,"King",90));
		sortedStudents.add(new Student(102,"Suraj",80)); 
		sortedStudents.add(new Student(102,"Suraj",80));
		sortedStudents.add(new Student(103,"Palash",100));
		sortedStudents.add(new Student(104,"Sheshank",50));
		sortedStudents.add(new Student(105,"Ayushi",88));
		sortedStudents.add(new Student(106,"Sidhi",70));
		
		//The Generic class in TreeSet class needs to implement Comparator interface so that TreeSet class can use that for sorting the elements. 
		
		itr = sortedStudents.iterator();
		System.out.println("\nTreeSet Elements:");
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

}
