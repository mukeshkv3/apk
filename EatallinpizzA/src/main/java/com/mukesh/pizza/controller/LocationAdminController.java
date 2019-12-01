package com.mukesh.pizza.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mukesh.pizza.entities.Location;
import com.mukesh.pizza.services.LocationServices;

@RestController
public class LocationAdminController {
	@Autowired
	LocationServices locationServices;

	@RequestMapping(value="/locations", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Set<Location> getLocations() {
		Set<Location> locations = null;
		try
		{
			locations = locationServices.getLocations();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return locations;
	}
	
	@RequestMapping(value="/location", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public  ResponseEntity<Map<String, String>> addLocation(@RequestBody Location location)
	{
		 Map<String,String> response=new HashMap<String, String>();
		try
		{
			locationServices.addLocation(location);
			 response.put("ok", "success saving data");
	         return ResponseEntity.accepted().body(response);
		}
		catch(Exception e)
		{
			response.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(response);
		}
	
}
	
	@RequestMapping(value="/updatelocation", method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Map<String, String>> updateLocations(@RequestBody Location location)
	{
		 Map<String,String> response=new HashMap<String, String>();
		try
		{
			locationServices.updateLocation(location);
			 response.put("ok", "success saving data");
	         return ResponseEntity.accepted().body(response);
		}
		catch(Exception e)
		{
			response.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(response);
		}
	}
	@RequestMapping(value="/location/{lid}", method=RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, String>> delete(@PathVariable("lid")String lid)
	{
		Map<String,String> response=new HashMap<String, String>();
		try
		{
			locationServices.deleteLocation(lid);
			 response.put("ok", "success saving data");
	         return ResponseEntity.accepted().body(response);
		}
		catch(Exception e)
		{
			response.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(response);
		}
	}
	@RequestMapping(value="/locationbyid/{lid}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Location> getLocationById(@PathVariable("lid")String lid)
	{
		Location location = null;
		try
		{
			location = locationServices.getLocationById(lid);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ResponseEntity.accepted().body(location);
	}
	
	@RequestMapping(value="/locationbyname/{lname}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Location> getLocationByName(@PathVariable("lname")String lname)
	{
		Location location = null;
		try
		{
			location = locationServices.getLocationByName(lname);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ResponseEntity.accepted().body(location);
	}
}
	
	
	
	
	
	
	
	