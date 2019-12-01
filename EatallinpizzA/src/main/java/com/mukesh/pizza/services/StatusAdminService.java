package com.mukesh.pizza.services;

import java.util.List;

import com.mukesh.pizza.entities.Admin;
import com.mukesh.pizza.entities.Order;
import com.mukesh.pizza.exceptions.BusinessException;

public interface StatusAdminService {
	
	public void addAdmin(Admin a) throws BusinessException;
	public void updateAdmin(Admin a) throws BusinessException;
	public void deleteAdmin(String aid) throws BusinessException;
	public Admin login(String aname,String password) throws BusinessException;
	public Admin getAdminById(String aid) throws BusinessException;
	public void updatePassword(Admin a) throws BusinessException;
	public List<Admin> getAdminByType(String type) throws BusinessException;
	public Order getOrderById(String oid) throws BusinessException;
	public List<Order> getAllOrders() throws BusinessException;
	public List<Admin> getAllAdmins() throws BusinessException;
	public void addOrder(Order o) throws BusinessException;
	public void updateOrder(Order o) throws BusinessException;
	public void deleteOrder(String oid) throws BusinessException;
}
