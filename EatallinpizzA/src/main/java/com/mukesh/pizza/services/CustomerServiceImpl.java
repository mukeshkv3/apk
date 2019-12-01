package com.mukesh.pizza.services;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mukesh.pizza.daos.CustomerDao;
import com.mukesh.pizza.entities.Customer;
import com.mukesh.pizza.exceptions.BusinessException;
@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	CustomerDao customerDao;
	public void customerRegister(Customer customer) throws BusinessException{
		if(customer.getCname().matches("[A-Z]{1}[a-z]{3,10}")) {
			if(customer.getPass().length()<8){
				if(customer.getMobile()>0) {
					if(customer.getEmail().matches("[A-Z]{1}[a-z]{3,10}@gmail.com")) {
						if(customer.getAddress().length()<=30) {
							if(customer.getPincode()>1) {
								if(customer.getCreditcard().length()==16) {
									try {
										customerDao.customerRegister(customer);
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}else throw new BusinessException("credit card length should be 12");
							}else throw new BusinessException("Pincode length should be 6");
						}else throw new BusinessException("Address length shold be 30");
					}else throw new BusinessException("email sholud be [A-Z]{1}[a-z]{3,10}@gmail.com");
				}else throw new BusinessException("Password size should be equal to 10");
			}else throw new BusinessException("Password length should be greter than are equalt to 8");
		}else throw new BusinessException("Name Should be in the formate of [A-Z]{1}[A-Z]{3} ");

	}
	public Customer Login(String cname, String pass)throws BusinessException {
		if(cname.matches("[A-Z]{1}[a-z]{3,10}")) {
			if(pass.length()<8){
			Customer customer=	customerDao.Login(cname, pass);
			return customer;
			}else throw new BusinessException("Password length should be greter than are equalt to 8");
		}else throw new BusinessException("Name Should be in the formate of [A-Z]{1}[A-Z]{3} ");
	}
	public void updateCustomerProfileDetails(Customer customer) throws BusinessException {
		if(customer.getCname().matches("[A-Z]{1}[a-z]{3,10}")) {
			if(customer.getPass().length()<8){
				if(customer.getMobile()>0) {
					if(customer.getEmail().matches("[A-Z]{1}[a-z]{3,10}@gmail.com")) {
						if(customer.getAddress().length()<=30) {
							if(customer.getPincode()>1) {
								if(customer.getCreditcard().length()==16) {
									customerDao.updateCustomerProfileDetails(customer);
								}else throw new BusinessException("credit card length should be 12");
							}else throw new BusinessException("Pincode length should be 6");
						}else throw new BusinessException("Address length shold be 30");
					}else throw new BusinessException("email sholud be [A-Z]{1}[a-z]{3-10}@gmail.com");
				}else throw new BusinessException("Password size should be equal to 10");
			}else throw new BusinessException("Password length should be greter than are equalt to 8");
		}else throw new BusinessException(" Name Should be in the formate of [A-Z]{1}[A-Z]{3} ");


	}
	public void deleteCustomerProfileById(String cuid) throws BusinessException {
		
		customerDao.deleteCustomerProfileById(cuid);
	}
	public Customer getCustomerProfileById(String cuid) throws BusinessException {
		Customer customer=customerDao.getCustomerProfileById(cuid);
		if(customer==null) {
			throw new BusinessException("the requested Customer profile id is not available");
		}
		return customer;
	}
	public List<Customer> getAllCustomers() throws BusinessException {
		List<Customer> customers=customerDao.getAllCustomers();
		if(customers==null) {
			throw new BusinessException("there is no Customer profile details available");
		}
		return customers;
	}


}
