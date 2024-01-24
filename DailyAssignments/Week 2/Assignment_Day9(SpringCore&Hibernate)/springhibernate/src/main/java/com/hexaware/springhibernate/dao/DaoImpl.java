package com.hexaware.springhibernate.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hexaware.springhibernate.entity.Loan;

@Repository
public class DaoImpl implements IDao {

	Session session;

	@Autowired
	public DaoImpl(SessionFactory sessionFactory) {
		session = sessionFactory.openSession();
	}

	@Override
	public boolean createLoan(Loan loan) {
		Transaction txn = session.beginTransaction();
		Serializable sbz = session.save(loan);
		System.out.println("Loan with id " + sbz.toString() + " is inserted...");
		txn.commit();
		return true;
	}

	@Override
	public boolean updateLoan(Loan loan) {
	    Transaction txn = session.beginTransaction();
	    Loan existingLoan = session.get(Loan.class, loan.getLoanId());
	    existingLoan.setLoanType(loan.getLoanType());
	    existingLoan.setDuration(loan.getDuration());
	    existingLoan.setLoanAmount(loan.getLoanAmount());
	    // No need to save again, as the entity is already attached
	    txn.commit();
	    return true;
	}

	@Override
	public boolean deleteLoan(int id) {
	    Transaction txn = session.beginTransaction();
	    Loan loanToDelete = session.get(Loan.class, id);
	    if (loanToDelete != null) {
	        session.delete(loanToDelete);
	        txn.commit();
	        return true;
	    } else {
	        txn.rollback(); // Rollback the transaction if the entity is not found
	        return false;
	    }
	}

	@Override
	public Loan selectLoanById(int id) {
    	String selectByid = "select l from Loan l where l.loanId= :loanId";
    	Query<Loan> query = session.createQuery(selectByid);
    	query.setParameter("loanId",id);
    	Loan loan = query.getSingleResult();
//		Loan loan = session.get(Loan.class, id);
		return loan;
	}

	@Override
	public List<Loan> selectLoanByStatus(String status) {
		String selectQuery = "select l from Loan l where l.status = ?1"; // Query with named parameter
		Query<Loan> query = session.createQuery(selectQuery, Loan.class);
		query.setParameter(1, "Pending");
		List<Loan> list = query.getResultList();
		return list;
	}

	@Override
	public List<Loan> selectLoanByType(String type) {
		Query<Loan> query = session.createNamedQuery("getAllLoansByType", Loan.class);
		query.setParameter(1, type);
		List<Loan> loansByType = query.getResultList();
		return loansByType;
	}

	@Override
	public List<Loan> selectAllLoans() {
		Query<Loan> query = session.createNamedQuery("getAllLoans", Loan.class);
		List<Loan> allLoans = query.getResultList();
		return allLoans;
	}
}
