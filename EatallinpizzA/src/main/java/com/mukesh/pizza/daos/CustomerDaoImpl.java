package com.mukesh.pizza.daos;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.mukesh.pizza.entities.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	@Autowired
	SessionFactory sessionFactory;
	public void customerRegister(Customer customer)throws SQLException {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
			session.save(customer);
		} catch (Exception e) {
			// TODO: handle exception
		}
		session.getTransaction().commit();
		session.close();	
	}
	public Customer Login(String cname, String pass) {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("deprecation")
		Criteria cr=session.createCriteria(Customer.class);
		Criterion cName=Restrictions.eq("cname", cname);
		Criterion cPass=Restrictions.eq("pass", pass);
		LogicalExpression andExpression=Restrictions.and(cName, cPass);
		cr.add(andExpression);
		Customer cusomer=(Customer) cr.uniqueResult();
		return cusomer;
	}
	public void updateCustomerProfileDetails(Customer customer) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(customer);
		session.getTransaction().commit();
		session.close();

	}
	public void deleteCustomerProfileById(String cuid) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Customer customer=session.get(Customer.class,cuid);
		session.delete(customer);
		session.getTransaction().commit();
		session.close();
	}
	public Customer getCustomerProfileById(String cuid) {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("deprecation")
		Criteria cr =session.createCriteria(Customer.class);
		cr.add(Restrictions.eq("cuid",cuid));
		Customer customer=	(Customer) cr.uniqueResult();
		return customer;
	}
	
	public List<Customer> getAllCustomers() {
		Session session = sessionFactory.openSession();
		TypedQuery<Customer> query=session.createQuery("from Customer", Customer.class);
		List<Customer> customers=query.getResultList();
		return customers;
	}


}
