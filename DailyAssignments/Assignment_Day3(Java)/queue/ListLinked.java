package queue;

import java.util.LinkedList;
import java.util.Queue;

import collections.Student;

public class ListLinked {
	public static void main(String[] args) {
		Queue<Student> studentsInLine = new LinkedList<>();
		studentsInLine.offer(new Student(1,"Suraj",99));
		studentsInLine.offer(new Student(2,"Aanchal",79));
		studentsInLine.offer(new Student(3,"Ayushi",69));
		studentsInLine.offer(new Student(1,"Suraj",99));
		studentsInLine.add(new Student(4,"Siddhi",89));
		System.out.println(studentsInLine);
		System.out.println("First element in the queue: "+studentsInLine.peek());
		System.out.println("First Student-"+studentsInLine.poll()+" is done.");
		System.out.println("Remaining in queue: "+studentsInLine);
	}
	
}
