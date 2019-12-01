package com.mukesh.pizza.services;

import java.util.Set;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mukesh.pizza.daos.ShopDao;
import com.mukesh.pizza.entities.Shop;
import com.mukesh.pizza.exceptions.BusinessException;

@Service
public class ShopServiceImpl implements ShopService {
	@Autowired
	ShopDao shopDao;

	public void addShop(Shop shop) throws BusinessException {
		if(shop.getSname().length()>1 && shop.getSname().length()<10)
		{
		shopDao.addShop(shop);
		}
		else
		{
			throw new BusinessException("Shop Name should be greater than 1 and less than 10");
		}

	}

	public void updateShop(Shop shop) throws BusinessException {
		if(shop.getSname().length()>1 && shop.getSname().length()<10)
		{
		shopDao.updateShop(shop);
		}
		else
		{
			throw new BusinessException("Shop Name should be greater than 1 and less than 10");
		}
	}

	public void deleteShop(String sid) throws BusinessException {
		if(sid.startsWith("SH_") && sid.length()==6)
		{
			shopDao.deleteShop(sid);
		}
		else
		{
			throw new BusinessException("Delete Shop should start with SH_ and should have 6 characters");
		}

	}

	public Shop getShopById(String sid) throws BusinessException {
		if(sid.startsWith("SH_") && sid.length()==6)
		{
			Shop shop = shopDao.getShopById(sid);
			return shop;
		}
		else
		{
			throw new BusinessException("GetShopById should start with SH_ and should have 6 characters");
		}
	}

	public Set<Shop> getShops() throws BusinessException {
		Set<Shop> shop = shopDao.getShops();
		if(shop == null)
		{
			throw new BusinessException("Get Shops should not be null");
		}
		else
		{
			return shop;
		}
	}

	public Shop getShopByName(String sname) throws BusinessException {
		if((sname.length()>1) && (sname.length()<10) )
		{
			Shop shop = shopDao.getShopByName(sname);
			return shop;
		}
		else
		{
			throw new BusinessException("Shop Name should be greater than 1 and less than 10");
		}
		
	}
	
	public List<Shop> getShopsByLocationName(String lname)throws BusinessException {
		List<Shop> shops=shopDao.getShopsByLocationName(lname);
		return shops;
	}

}
