package com.mukesh.pizza.daos;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.mukesh.pizza.entities.Shop;
import com.mukesh.pizza.entities.Location;

@Repository
public class ShopDaoImpl implements ShopDao {
	@Autowired
	SessionFactory sessionFactory;

	public void addShop(Shop shop){
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(shop);
		session.getTransaction().commit();
		session.close();
		
	}

	public void updateShop(Shop shop){
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.update(shop);
		session.getTransaction().commit();
		session.close();
		
	}

	public void deleteShop(String sid){
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Shop s=(Shop)session.get(Shop.class,sid);
		session.delete(s);
		session.getTransaction().commit();
		session.close();

		
	}

	public Shop getShopById(String sid){
		Session session=sessionFactory.openSession();
		TypedQuery<Shop> query =session.createQuery("from Shop where sid=:sid", Shop.class);
		query.setParameter("sid", sid);
		Shop s=(Shop) query.getSingleResult();
		return s;
	}

	public Set<Shop> getShops(){
		Session session=sessionFactory.openSession();
		 TypedQuery<Shop> query = session.createQuery("from Shop", Shop.class);
		 List<Shop> shops=query.getResultList();
		 Set<Shop> shopSet=new HashSet<Shop>();
		 shopSet.addAll(shops);
	     // Set<Location> locations = (Set<Location>) query.getResultList();
		return shopSet;
	}

	public Shop getShopByName(String sname){
		Session session=sessionFactory.openSession();
		TypedQuery<Shop> query=session.createQuery("from Shop where sname=:sname", Shop.class);
		query.setParameter("sname", sname);
		Shop s=(Shop) query.getSingleResult();
		return s;
	}

	public List<Shop> getShopsByLocationName(String lname) {
		Session session=sessionFactory.openSession();
		TypedQuery<Location> query = session.createQuery("from Location where lname=:lname",Location.class);
		query.setParameter("lname",lname);
		Location location=query.getSingleResult();		
		TypedQuery<Shop> query1 = session.createQuery("from Shop where location=:location",Shop.class);
		query1.setParameter("location",location);
		List<Shop> shop=query1.getResultList();
		return shop;
	}
}
