package practices;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class EmployeeMain {

	public static void main(String[] args) {
		PojoEmployee e = new PojoEmployee(101,"King",43000);
		List<PojoEmployee> employees = new ArrayList<>();
		employees.add(e);
		employees.add(new PojoEmployee(102,"Suraj",50000));
		employees.add(new PojoEmployee(102,"Suraj",15000));
		employees.add(new PojoEmployee(103,"Palash",5500));
		employees.add(new PojoEmployee(104,"Sheshank",5000));
		
		Iterator<PojoEmployee> itr = employees.iterator();
		System.out.println("ArrayList elements:");
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		Set<PojoEmployee> set = new HashSet<>();
		set.add(new PojoEmployee(101,"King",5000));
		set.add(new PojoEmployee(102,"Suraj",50000)); //This object and the object below are duplicate but since they are created using  new keyword , they got different hashcode and are not considered as duplicate by the jvm.
		//To avoid this insertion of duplicate elements in the Set we have overridden hashcode() and equals() in the CollectionsPractice.java class in collection package.
		set.add(new PojoEmployee(102,"Suraj",50000));
		set.add(new PojoEmployee(103,"Palash",5500));
		set.add(new PojoEmployee(104,"Sheshank",5000));
		
		itr=set.iterator();
		System.out.println("\nHashSet Elements:");
		for (PojoEmployee pojoEmployee : set) {
			System.out.println(pojoEmployee);
		}
		
	}

}
