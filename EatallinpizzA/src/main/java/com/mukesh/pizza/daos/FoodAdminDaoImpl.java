package com.mukesh.pizza.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mukesh.pizza.entities.AddOn;
import com.mukesh.pizza.entities.Food;

@Repository
public class FoodAdminDaoImpl implements FoodAdminDao {
	
	@Autowired
	SessionFactory sessionFactory;
	

	
	public void addFood(Food f) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(f);
		session.getTransaction().commit();
	}

	
	public void updateFood(Food f) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.update(f);
		session.getTransaction().commit();
	}

	
	public void deleteFood(String fid) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Food f=(Food)session.get(Food.class, fid);
		session.delete(f);
		session.getTransaction().commit();

	}

	
	public List<Food> retirveAllFood() {
		Session session=sessionFactory.openSession();
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<Food> foods=session.createCriteria(Food.class).list();
		return foods;
	}

	
	public Food retriveFoodById(String fid) {
		Session session=sessionFactory.openSession();
		Food f=(Food)session.get(Food.class, fid);
		return f;
	}

	
	public Food retriveFoodByName(String fname) {
		 Session s=sessionFactory.openSession();
	        @SuppressWarnings("deprecation")
			Criteria cr=s.createCriteria(Food.class);
	        cr.add(Restrictions.eq("fname", fname));
	        Food f=(Food) cr.uniqueResult();
	        return f;
	}

	
	public void addAddOn(AddOn ao) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(ao);
		session.getTransaction().commit();

	}

	
	public void updateAddOn(AddOn ao) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.update(ao);
		session.getTransaction().commit();

	}

	
	public void deleteAddOn(String adid) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		AddOn a=(AddOn)session.get(AddOn.class, adid);
		session.delete(a);
		session.getTransaction().commit();

	}

	
	@SuppressWarnings("deprecation")
	public List<AddOn> retirveAllAddOn() {
		Session session=sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<AddOn> addons=session.createCriteria(AddOn.class).list();
		return addons;
	}

	
	public AddOn retriveAddOnById(String adid) {
		Session session=sessionFactory.openSession();
		AddOn addon=(AddOn)session.get(AddOn.class, adid);
		return addon;
	}

	
	public AddOn retriveAddOnByName(String adname) {
		 Session s=sessionFactory.openSession();
	        @SuppressWarnings("deprecation")
			Criteria cr=s.createCriteria(AddOn.class);
	        cr.add(Restrictions.eq("adname", adname));
	        AddOn a=(AddOn) cr.uniqueResult();
	        return a;
	}

	

	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<AddOn> retriveAddOnByType(String adontype)  {
		
		Session s=sessionFactory.openSession();
		 List<AddOn> a=s.createCriteria(AddOn.class).add(Restrictions.eq("adOnType", adontype)).list();
        return  a;
}

}