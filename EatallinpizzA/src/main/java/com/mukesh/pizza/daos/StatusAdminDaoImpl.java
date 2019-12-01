package com.mukesh.pizza.daos;

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

import com.mukesh.pizza.entities.Admin;
import com.mukesh.pizza.entities.Order;

@Repository
public class StatusAdminDaoImpl implements StatusAdminDao {

	@Autowired
	SessionFactory sessionFactory;

	public void addAdmin(Admin a) {


		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(a);
		session.getTransaction().commit();


	}

	public void updateAdmin(Admin a) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(a);
		session.getTransaction().commit();

	}

	public void deleteAdmin(String aid) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Admin a= (Admin) session.get(Admin.class,aid);
		session.delete(a);
		session.getTransaction().commit();

	}	


	public Admin login(String aname, String password) {
		Session session=sessionFactory.openSession();
		@SuppressWarnings("deprecation")
		Criteria cr=session.createCriteria(Admin.class);
		Criterion aname1=Restrictions.eq("aname", aname);
		Criterion password1=Restrictions.eq("password", password);
		LogicalExpression andExpression=Restrictions.and(aname1, password1);
		cr.add(andExpression);
		Admin admin= (Admin) cr.uniqueResult();
		return admin;
	}

	public Admin getAdminById(String aid) {
		Session session=sessionFactory.openSession();
		@SuppressWarnings("deprecation")
		Criteria cr=session.createCriteria(Admin.class);
		cr.add(Restrictions.eq("aid", aid));
		Admin admin=(Admin) cr.uniqueResult();
		return admin;
	}

	public void updatePassword(Admin a) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.update(a);
		session.getTransaction().commit();
		session.close();
	}



	public Order getOrderById(String oid)
	{
		Session session=sessionFactory.openSession();
		@SuppressWarnings("deprecation")
		Criteria cr=session.createCriteria(Order.class);
		cr.add(Restrictions.eq("oid",oid));
		Order o1=  session.get(Order.class,oid);
		return o1;

	}


	public List<Admin> getAdminByType(String type) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		@SuppressWarnings({ "deprecation", "unchecked" })
		List<Admin> admins=session.createCriteria(Admin.class).add(Restrictions.eq("type", type)).list();
		return admins;
	}


	public List<Order> getAllOrders()
	{
		Session session=sessionFactory.openSession();
		TypedQuery<Order> query=session.createQuery("from Order",Order.class);
		List<Order> orders=query.getResultList();
		return orders;
	}


	public List<Admin> getAllAdmins() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		@SuppressWarnings({ "deprecation", "unchecked" })
		List<Admin> admins=session.createCriteria(Admin.class).list();
		return admins;
	}


	public void addOrder(Order o) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(o);
		session.getTransaction().commit();

	}


	public void updateOrder(Order o) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.update(o);
		session.getTransaction().commit();

	}


	public void deleteOrder(String oid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Order o= session.get(Order.class,oid);
		session.delete(o);
		session.getTransaction().commit();

	}


}
