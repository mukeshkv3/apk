package com.mukesh.pizza.services;

import java.util.Set;
import java.util.List;
import com.mukesh.pizza.entities.Shop;
import com.mukesh.pizza.exceptions.BusinessException;

public interface ShopService {
	public void addShop(Shop shop)throws BusinessException;
	public void updateShop(Shop shop)throws BusinessException;
	public void deleteShop(String sid)throws BusinessException;
	public Shop getShopById(String sid)throws BusinessException;
	public Set<Shop> getShops()throws BusinessException;
	public Shop getShopByName(String sname)throws BusinessException;
	public List<Shop> getShopsByLocationName(String lname) throws BusinessException;
}
