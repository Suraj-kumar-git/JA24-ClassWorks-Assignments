package presentation;

import java.util.List;
import java.util.Scanner;

import dao.DeptDAOImpl;
import dao.IDepartmentDAO;
import entity.Department;

public class Client {

	final static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		IDepartmentDAO daoImpl = new DeptDAOImpl();
		
		System.out.println("*****Welcome to Java Full Stack Course with Javeed*****");
		boolean stop=false;

		while(!stop) {
			System.out.println("Choose from the following options:");
			System.out.println("1. Insert new Department");
			System.out.println("2. Update Department");
			System.out.println("3. Delete one Department");
			System.out.println("4. Select one Department");
			System.out.println("5. Select all Department");
			System.out.println("6. Exit");
			int choice = sc.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("Enter new Department record:");
				Department dept = readDepartment();
				int count=daoImpl.insertDept(dept);
				System.out.println(count+" row/s updated.");
				break;
			}
			case 2:
				System.out.println("Enter updated Department record:");
				Department dept = readDepartment();
				int count=daoImpl.updateDept(dept);
				System.out.println(count+ " row/s affected...");
				break;
			case 3:
				System.out.println("Enter the department ID to delete:");
				int id=sc.nextInt();
				int count1 = daoImpl.deleteOneDept(id);
				System.out.println(count1+" row/s affected.");
				break;
			case 4:
				System.out.println("Enter the department ID to select:");
				int id1= sc.nextInt();
				Department department = daoImpl.selectOne(id1);
				System.out.println(department);
				break;
			case 5:
				System.out.println("Here u are:");
				List<Department> allDepartments =daoImpl.selectAll();
				allDepartments.stream().forEach(System.out::println);
				break;
			case 6:
				System.out.println("Goodbye...");
				stop=true;
				System.exit(0);
				break;
			default:
				System.out.println("Only choose from the given option.");
				break;
			}
		}
	}

	private static Department readDepartment() {
		System.out.println("Enter Dept No: ");
		int dno=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Dept Name: ");
		String dname=sc.nextLine();
		System.out.println("Enter Dept location: ");
		String location = sc.nextLine();
		return new Department(dno,dname,location);
	}
}
