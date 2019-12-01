package com.mukesh.pizza.services;

import java.util.Set;

import com.mukesh.pizza.entities.Location;
import com.mukesh.pizza.exceptions.BusinessException;

public interface LocationServices {
	public void addLocation(Location location)throws BusinessException;
	public void updateLocation(Location location)throws BusinessException;
	public void deleteLocation(String lid)throws BusinessException;
	public Location getLocationById(String lid)throws BusinessException;
	public Set<Location> getLocations()throws BusinessException;
	public Location getLocationByName(String lname)throws BusinessException;
}
