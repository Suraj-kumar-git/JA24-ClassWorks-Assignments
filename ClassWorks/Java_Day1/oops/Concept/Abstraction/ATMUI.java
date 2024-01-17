package oops.Concept.Abstraction;

import java.util.Scanner;

public class ATMUI {
	
	public static void main(String[] args) {
		IBankInterface bank = new BankImpl2();
		System.out.println("**** Welcome to ATM ****");
		Scanner sc= new Scanner(System.in);
		boolean stop=false;
		while(!stop) {
			System.out.println("Choose your option:");
			System.out.println("1.Deposit\n2.Withdraw");
			int input = sc.nextInt();
			switch(input) {
			case 1:
				bank.deposit();
				break;
			case 2:
				bank.withdraw();
				break;
			default:
				stop=true;
				break;
			}
		}
	}
}
