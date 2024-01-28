package com.hexaware.mappings;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hexaware.mappings.entity.Order;
import com.hexaware.mappings.entity.Product;

/**
 * Hello world!
 *
 */
public class ManyToManyMapping {
    public static void main( String[] args ){
    	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    	Session session = sessionFactory.openSession();
//    	System.out.println(session);

    	Product product1 = new Product(1,"Brush");
    	Product product2 = new Product(2,"ToothPase");
    	Product product3 = new Product(3,"NailCutter");
    	Product product4 = new Product(4,"TongueCleaner");
    	Product product5 = new Product(5,"Sleeper");
    	
    	Order order1 = new Order();
    	order1.setOrderid(101);
    	order1.setPurchaseDate(LocalDate.now());
    	order1.addProduct(product1);
    	order1.addProduct(product2);
    	order1.addProduct(product3);
    	
    	Order order2 = new Order();
    	order2.setOrderid(102);
    	order2.setPurchaseDate(LocalDate.now());
    	order2.addProduct(product4);
    	order2.addProduct(product5);
    	
    	Transaction txn = session.beginTransaction();
    	session.persist(order1);
    	session.persist(order2);
    	txn.commit();
    	session.close();
    }
}
