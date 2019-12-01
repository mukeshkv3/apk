package com.mukesh.pizza.daos;

import java.util.List;

import com.mukesh.pizza.entities.AddOn;
import com.mukesh.pizza.entities.Food;


public interface FoodAdminDao {
	
	public void addFood(Food f);
	public void updateFood(Food f);
	public void deleteFood(String fid);
	public List<Food> retirveAllFood();
	public Food retriveFoodById(String fid);
	public Food retriveFoodByName(String fname);
	
	
	public void addAddOn (AddOn ao);
	public void updateAddOn(AddOn ao);
	public void deleteAddOn(String adid);
	public List<AddOn> retirveAllAddOn();
	public AddOn retriveAddOnById(String adid);
	public AddOn retriveAddOnByName(String adname);
	public List<AddOn> retriveAddOnByType(String adontype);

}
