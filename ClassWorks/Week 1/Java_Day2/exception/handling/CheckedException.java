package exception.handling;

import java.util.ArrayList;
import java.util.List;

public class CheckedException {
	public static void main(String[] args){
		List<BankAccount> listBank = new ArrayList<>();
		listBank.add(new BankAccount(1,"Suraj",20000));
		listBank.add(new BankAccount(2,"Surbhi",2000));
		listBank.add(new BankAccount(3,"Aanchal",20000));
		listBank.add(new BankAccount(4,"Siddhi",24000));
		listBank.add(new BankAccount(5,"Ayushi",120000));
		listBank.add(new BankAccount(6,"Palash",200));
		
		try {
			for (BankAccount bankAccount : listBank) {
				if(bankAccount.getBalance()<1000) {
					throw new CustomException("For user "+bankAccount.getName()+" amount is below 1000 to withdraw.");
				}
				else {
					System.out.println("1000$ withdrawn successfully for user: "+bankAccount.getName());
					bankAccount.withdraw(1000);
				}
			}
		}catch(CustomException e) {
			System.err.println(e.getMessage());
		}
		
	}
}

class BankAccount {
	private int id;
	private String name;
	private double balance;

	public BankAccount() {

	}

	public BankAccount(int id, String name, double balance) {
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void withdraw(double withdrawAmount) {
		balance -= withdrawAmount;
	}

	@Override
	public String toString() {
		return "BankAccount [id=" + id + ", name=" + name + ", balance=" + balance + "]";
	}

}
