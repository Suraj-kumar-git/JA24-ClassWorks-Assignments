package com.hexaware.springjdbc;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hexaware.springjdbc.config.AppConfig;
import com.hexaware.springjdbc.model.Product;
import com.hexaware.springjdbc.service.IProductService;
import com.hexaware.springjdbc.service.IProductServiceImpl;

/**
 * Hello world!
 *
 */
public class App {

	final static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		IProductService product1 = context.getBean(IProductServiceImpl.class);
		

		System.out.println("*****Welcome to Java Full Stack Course with Suraj*****");
		boolean stop = false;

		while (!stop) {
			System.out.println("Choose from the following options:");
			System.out.println("1. Insert new Product");
			System.out.println("2. Update Product");
			System.out.println("3. Delete one Product");
			System.out.println("4. Select one Product");
			System.out.println("5. Select all Products");
			System.out.println("6. Exit");
			int choice = sc.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("Enter new Product record:");
				Product product = readProduct();
				boolean inserted = product1.createProduct(product);
				if (inserted) {
					System.out.println("Product inserted");
				}
				break;
			}
			case 2:
				System.out.println("Enter updated Product record:");
				Product product = readProduct();
				boolean updated = product1.updateProduct(product);
				if (updated) {
					System.out.println("Product updated");
				}
				break;
			case 3:
				System.out.println("Enter the Product ID to delete:");
				int id = sc.nextInt();
				boolean deleted= product1.deleteProductById(id);
				if(deleted) {
					System.out.println("Product deleted");
				}
				break;
			case 4:
				System.out.println("Enter the product ID to select:");
				int id1 = sc.nextInt();
				Product product2 = product1.selectProductById(id1);
				System.out.println(product2);
				break;
			case 5:
				System.out.println("Here u are:");
				List<Product> allProducts= product1.selectAllProducts();
				allProducts.stream().forEach(System.out::println);
				break;
			case 6:
				System.out.println("Goodbye...");
				stop = true;
//				System.exit(0);
				break;
			default:
				System.out.println("Only choose from the given option.");
				break;
			}
		}
	}

	private static Product readProduct() {
		System.out.println("Enter product No: ");
		int pid = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter product Name: ");
		String pname = sc.nextLine();
		System.out.println("Enter product price: ");
		Double price = sc.nextDouble();
		return new Product(pid, pname, price);
	}
}
