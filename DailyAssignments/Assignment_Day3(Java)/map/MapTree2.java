package map;

import java.util.TreeMap;

import collections.MyComparator;
import collections.Student;

public class MapTree2 {
	public static void main(String[] args) {
//		TreeMap<Student,Integer> treeMap = new TreeMap<>();	This will not give compilation error but throws RunTime Exception
		TreeMap<Student,Integer> treeMap = new TreeMap<>(new MyComparator());	//This will not throw RunTime Exception as we are passing an object of class which implements the Comparator<Student> and overides the compare method. This will help jvm compare two objects.
		
		treeMap.put(new Student(1,"Suraj",79),79);
		treeMap.put(new Student(2,"Aanchal",69),69);
		treeMap.put(new Student(3,"Ayushi",89),89);
		treeMap.put(new Student(4,"Siddhi",99),99);
		treeMap.put(new Student(5,"Palash",59),9);
		System.out.println(treeMap);
	}
}
