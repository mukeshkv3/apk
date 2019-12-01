package com.mukesh.pizza.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.mukesh.pizza.entities.Customer;
import com.mukesh.pizza.exceptions.BusinessException;
import com.mukesh.pizza.services.CustomerService;
@RestController
public class UserAdminController {
	@Autowired
	CustomerService customerService;
	@RequestMapping(value="/loginc/{cname}/{pass}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Customer> Login(@PathVariable("cname")String cname,@PathVariable("pass")String pass) {		
		Customer customer=null;
		try {
		customer=customerService.Login(cname, pass);
		} catch (BusinessException e) {
		
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.accepted().body(customer);
	}
	@RequestMapping(value="/register",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Map<String, String>> Register(@RequestBody Customer customer) {
		Map<String, String> response=new HashMap<String, String>();
		try {
			customerService.customerRegister(customer);
			response.put("Okay", "Success saving data");
			return ResponseEntity.accepted().body(response);
		} catch (BusinessException e) {
			response.put("error", e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}	
	}	

	@RequestMapping(value="/updateprofile",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Map<String, String>> updateCustomerProfile(@RequestBody  Customer customer) {
		Map<String, String> response=new HashMap<String, String>();
		try {
			customerService.updateCustomerProfileDetails(customer);
			response.put("Okay", "Success updating data");
			return ResponseEntity.accepted().body(response);
		} catch (BusinessException e) {
			response.put("error", e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
	}
	
	@RequestMapping(value="/deleteprofile/{cuid}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Map<String, String>> deleteCustomer(@PathVariable("cuid")String cuid){
		Map<String, String> response=new HashMap<String, String>();
		try {
			customerService.deleteCustomerProfileById(cuid);
			response.put("Okay", "Success deleting data");
			return ResponseEntity.accepted().body(response);
		} catch (BusinessException e) {
			response.put("error", e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}	
	}
	
	@RequestMapping(value="/getcustomerbyid/{cuid}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Customer> getCustomerProfileById(@PathVariable("cuid")String cuid){
		Customer customer;
		try {
			customer=customerService.getCustomerProfileById(cuid);
		} catch (BusinessException e) {
			
			e.printStackTrace();
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.accepted().body(customer);	
		
	}
	@RequestMapping(value="/getallprofiles",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Customer> getAllCustomers(){
		List<Customer> customers=null;
		try {
			customers=customerService.getAllCustomers();
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return  customers;
		
	}

}
