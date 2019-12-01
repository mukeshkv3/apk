package com.mukesh.pizza.services;

import java.util.List;

import com.mukesh.pizza.entities.AddOn;
import com.mukesh.pizza.entities.Food;
import com.mukesh.pizza.exceptions.BusinessException;

public interface FoodAdminServices {
	public void addFood(Food f)throws BusinessException;
	public void updateFood(Food f)throws BusinessException;
	public void deleteFood(String fid)throws BusinessException;
	public List<Food> retirveAllFood()throws BusinessException;
	public Food retriveFoodById(String fid)throws BusinessException;
	public Food retriveFoodByName(String fname)throws BusinessException;
	
	public void addAddOn (AddOn ao)throws BusinessException;
	public void updateAddOn(AddOn ao)throws BusinessException;
	public void deleteAddOn(String adid)throws BusinessException;
	public List<AddOn> retirveAllAddOn()throws BusinessException;
	public AddOn retriveAddOnById(String adid)throws BusinessException;
	public AddOn retriveAddOnByName(String adname)throws BusinessException;
	public List<AddOn> retriveAddOnByType(String adontype)throws BusinessException;

}
