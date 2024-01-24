package com.hexaware.assignment3;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	static final SessionFactory sessionFactory;
	static {
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
		sessionFactory = metadata.getSessionFactoryBuilder().build();
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
