package com.hexaware.springhibernate;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hexaware.springhibernate.entity.Loan;
import com.hexaware.springhibernate.service.IService;
import com.hexaware.springhibernate.service.ServiceImpl;

/**
 * Hello world!
 *
 */
public class App {
	final static Scanner sc = new Scanner(System.in);
    public static void main( String[] args ){
    	
    	ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    	IService service = context.getBean(ServiceImpl.class);
    	
    	System.out.println("Welcome to my 3rd Assignment...");
		boolean stop = false;

		while (!stop) {
			System.out.println("Choose from the following options:");
			System.out.println("1. Create Loan");
			System.out.println("2. Update loan");
			System.out.println("3. Delete one loan");
			System.out.println("4. Select one loan by id");
			System.out.println("5. Select loans by status");
			System.out.println("6. Select loans by type");
			System.out.println("7. Select all loans");
			System.out.println("8. Exit");
			int choice = sc.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("Enter new Loan :");
				Loan loan = readLoan();
				boolean isCreated = service.createLoan(loan);
				if (isCreated) {
					System.out.println("Loan inserted");
				}
				break;
			}
			case 2:
				System.out.println("Enter updated loan record:");
				Loan loan = readLoan();
				boolean isUpdated= service.updateLoan(loan);
				if (isUpdated) {
					System.out.println("Loan updated");
				}
				break;
			case 3:
				System.out.println("Enter the Loan ID to delete:");
				int id = sc.nextInt();
				boolean isDeleted= service.deleteLoan(id);
				if (isDeleted) {
					System.out.println("Loan deleted");
				}
				break;
			case 4:
				System.out.println("Enter the Loan ID to select:");
				int id1 = sc.nextInt();
				Loan loan2 = service.selectLoanById(id1);
				System.out.println(loan2);
				break;
			case 5:
				System.out.println("Enter the Loan Status(Pending/Approved/Rejected) to select:");
				sc.nextLine();
				String status = sc.nextLine();
				List<Loan> loansByStatus = service.selectLoanByStatus(status);
				loansByStatus.stream().forEach(System.out::println);
				break;
			case 6:
				System.out.println(
						"Enter the Loan type(Home Loan/Business Loan/Personal Loan/Gold Loan/Vehicle Loan) to select:");
				sc.nextLine();
				String type = sc.nextLine();
				List<Loan> loansByType = service.selectLoanByType(type);
				loansByType.stream().forEach(System.out::println);
				break;
			case 7:
				System.out.println("Here u are:");
				List<Loan> allLoans = service.selectAllLoans();
				allLoans.stream().forEach(System.out::println);
				break;
			case 8:
				System.out.println("Goodbye...");
				stop = true;
//    				System.exit(0);
				break;
			default:
				System.out.println("Only choose from the given option.");
				break;
			}
		}
	}

	private static Loan readLoan() {
		System.out.println("Enter loanID: ");
		int lid = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Loan Type(Home Loan/Business Loan/Personal Loan/Gold Loan/Vehicle Loan): ");
		String type = sc.nextLine();
		System.out.println("Enter loan amount: ");
		Double price = sc.nextDouble();
		System.out.println("Enter the duration of loan");
		int duration = sc.nextInt();
		return new Loan(lid, type, price, duration);
	}
}

