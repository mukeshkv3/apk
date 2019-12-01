package com.mukesh.pizza.controller;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.List;

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

import com.mukesh.pizza.entities.Shop;
import com.mukesh.pizza.exceptions.BusinessException;
import com.mukesh.pizza.services.ShopService;

@RestController
public class ShopAdminController {
	@Autowired
	ShopService shopService;
	
	
	@RequestMapping(value="/shops", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Set<Shop> getShops()	{
		Set<Shop> shops=null;
		try
		{
			shops =shopService.getShops();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		return shops;
	}
	
	@RequestMapping(value="/shop", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
		public ResponseEntity<Map<String, String>> addShop(@RequestBody Shop shop)
		{
		Map<String, String> response=new HashMap<String, String>();
			try
			{
				shopService.addShop(shop);
				response.put("ok", "success saving data");
				return ResponseEntity.accepted().body(response);
			}
			catch(BusinessException e)
			{
				response.put("ok", e.getMessage());
			}
			return ResponseEntity.badRequest().body(response);
		}
	
	@RequestMapping(value="/updateshop", method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Map<String, String>> updateShops(@RequestBody Shop shop)
	{
		 Map<String,String> response=new HashMap<String, String>();
		try
		{
			shopService.updateShop(shop);
			response.put("ok", "success saving data");
	         return ResponseEntity.accepted().body(response);
		}
		catch(Exception e)
		{
			response.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(response);
		}
	}
	
	@RequestMapping(value="/shop/{sid}", method=RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable("sid")String sid)
	{
		try
		{
			shopService.deleteShop(sid);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping(value="/shopbyid/{sid}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Shop> getShopById(@PathVariable("sid")String sid)
	{
		Shop shops=null;
		try
		{
			shops=shopService.getShopById(sid);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return new ResponseEntity<Shop>(HttpStatus.SEE_OTHER);
		}
		return ResponseEntity.accepted().body(shops);
	}
	
	@RequestMapping(value="/shopbyname/{sname}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Shop> getShopByName(@PathVariable("sname")String sname)
	{
		Shop shops = null;
		try
		{
			shops = shopService.getShopByName(sname);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return new ResponseEntity<Shop>(HttpStatus.SEE_OTHER);
		}
		return ResponseEntity.accepted().body(shops);
	}
	
	@RequestMapping(value="/listofshopsbylocationname/{lname}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Shop> getAllShopsByLocationName(@PathVariable("lname")String lname){
		List<Shop> shops=null;
		try {
			shops=	shopService.getShopsByLocationName(lname);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return shops;
	}

}
