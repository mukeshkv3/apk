package com.mukesh.pizza.daos;

import java.util.Set;
import java.util.List;

import com.mukesh.pizza.entities.Shop;


public interface ShopDao {
	public void addShop(Shop shop);
	public void updateShop(Shop shop);
	public void deleteShop(String sid);
	public Shop getShopById(String sid);
	public Set<Shop> getShops();
	public Shop getShopByName(String sname);
	public List<Shop> getShopsByLocationName(String lname);

}
