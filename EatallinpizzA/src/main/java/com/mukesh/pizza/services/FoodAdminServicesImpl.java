package com.mukesh.pizza.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mukesh.pizza.daos.FoodAdminDao;
import com.mukesh.pizza.entities.AddOn;
import com.mukesh.pizza.entities.Food;
import com.mukesh.pizza.exceptions.BusinessException;

@Service
public class FoodAdminServicesImpl implements FoodAdminServices {

	@Autowired
	FoodAdminDao foodAdminDao;

	
	public void addFood(Food f) throws BusinessException {

		if(f.getFname().length()<10 && f.getFname().length()>1)
		{
			if(f.getCost()>10  && f.getCost()<1000)
			{
				if(f.getQuantity()>0 && f.getQuantity()<10)
				{
					foodAdminDao.addFood(f);
				}else
				{
					throw new BusinessException("quantity should be less than 10 and greater than 1");
				}	
			}
			else
			{
				throw new BusinessException("Cost should be more than 10rs and less than 1000rs");
			}

		}else
		{
			throw new BusinessException("name should be less than 10 and greater than 1 letter");
		}

	}

	
	public void updateFood(Food f) throws BusinessException {


		if(f.getFname().length()<10 && f.getFname().length()>1)
		{
			if(f.getCost()>10  && f.getCost()<1000)
			{
				if(f.getQuantity()>0 && f.getQuantity()<10)
				{

					foodAdminDao.updateFood(f);
				}else
				{
					throw new BusinessException("quantity should be less than 10 and greater than 1");
				}	
			}
			else
			{
				throw new BusinessException("Cost should be more than 10rs and less than 1000rs");
			}

		}else
		{
			throw new BusinessException("name should be less than 10 and greater than 1 letter");
		}

	}

	
	public void deleteFood(String fid) throws BusinessException {
		if(fid.startsWith("FO_")&& fid.length()==6)
		{
		foodAdminDao.deleteFood(fid);
		}
		else
		{
			throw new BusinessException("ID should start with FO_ and must have 6 characters ");
		}
	}

	
	public List<Food> retirveAllFood() throws BusinessException {

		List<Food> foods=foodAdminDao.retirveAllFood();
		if(foods!=null)
		{
			return foods;
		}
		else
		{
			throw new BusinessException("no food available");
		}
		
	}

	
	public Food retriveFoodById(String fid) throws BusinessException {
		Food food=foodAdminDao.retriveFoodById(fid);
		if(food!=null)
		{
		return food;
		}
		else
		{
			throw new BusinessException("no food is available by this ID");
		}
	}

	
	public Food retriveFoodByName(String fname) throws BusinessException {
		Food food=foodAdminDao.retriveFoodByName(fname);
		if(food!=null)
		{
		return foodAdminDao.retriveFoodByName(fname);
		}
		else {
			throw new BusinessException("no food is available by this Name");
		}
	}

	
	public void addAddOn(AddOn ao) throws BusinessException {

		if(ao.getAdname().length()<10 && ao.getAdname().length()>0)
		{
			if(ao.getCost()>10 && ao.getCost()<1000)
			{
				if(ao.getQuantity()>0 && ao.getQuantity()<10)
				{
					foodAdminDao.addAddOn(ao);
				}else
				{
					throw new BusinessException("quantity should be less than 10 and greater than 1");
				}
			}else
			{
				throw new BusinessException("Cost should be more than 10rs and less than 1000rs");
			}

		}else

		{
			throw new BusinessException("name should be less than 10 and greater than 1 letter");
		}
	}

	
	public void updateAddOn(AddOn ao) throws BusinessException {
		if(ao.getAdname().length()<10 && ao.getAdname().length()>0)
		{
			if(ao.getCost()>10 && ao.getCost()<1000)
			{
				if(ao.getQuantity()>0 && ao.getQuantity()<10)
				{

					foodAdminDao.updateAddOn(ao);
				}else
				{
					throw new BusinessException("quantity should be less than 10 and greater than 1");
				}	
			}else
			{
				throw new BusinessException("Cost should be more than 10rs and less than 1000rs");
			}

		}else
		{
			throw new BusinessException("name should be less than 10 and greater than 1 letter");
		}
	}

	
	public void deleteAddOn(String adid) throws BusinessException {
		
		if(adid.startsWith("TO_")&& adid.length()==6)
		{
			foodAdminDao.deleteAddOn(adid);
		}
		else
		{
			throw new BusinessException("ID should start with TO_ and must have 6 characters ");
		}

		

	}

	
	public List<AddOn> retirveAllAddOn() throws BusinessException {
		
		List<AddOn> addons=foodAdminDao.retirveAllAddOn();
		if(addons!=null)
		{
			return addons;
		}
		else
		{
			throw new BusinessException("no addon is available");
		}

	}

	
	public AddOn retriveAddOnById(String adid) throws BusinessException {

		AddOn addon=foodAdminDao.retriveAddOnById(adid);
		if(addon!=null)
		{
		return addon;
		}
		else
		{
			throw new BusinessException("no addon is available by this ID");
		}
		
		
		
	}

	
	public AddOn retriveAddOnByName(String adname) throws BusinessException {
		AddOn addon=foodAdminDao.retriveAddOnByName(adname);
		if(addon!=null)
		{
			return addon;
		}
		else
		{
			throw new BusinessException("no addon is available by this Name");
		}
		
	}

	
	public List<AddOn> retriveAddOnByType(String adontype) throws BusinessException {
		
		List<AddOn> addons=foodAdminDao.retriveAddOnByType(adontype);
		if(addons!=null)
		{
			return addons;
		}
		else
		{
			throw new BusinessException("no addons by that type is available");
		}

		
	}

}
