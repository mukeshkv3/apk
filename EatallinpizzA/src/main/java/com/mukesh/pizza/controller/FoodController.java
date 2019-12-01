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


import com.mukesh.pizza.entities.Food;
import com.mukesh.pizza.exceptions.BusinessException;
import com.mukesh.pizza.services.FoodAdminServices;

@RestController
public class FoodController {
	
	@Autowired
	FoodAdminServices foodAdminServices;
	

    @RequestMapping(value="/getfoodbyid/{fid}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Food>  getFoodById(@PathVariable("fid") String fid) {
        Food f=null;
             try {
                f=foodAdminServices.retriveFoodById(fid);
            } catch (  Exception e) {
               
                e.printStackTrace();
                return new ResponseEntity<Food>(HttpStatus.SEE_OTHER);
            }
             return ResponseEntity.accepted().body(f);
          
    }
    
    @RequestMapping(value="/addfood",method=RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Map<String, String>> addFood(@RequestBody Food food){
    	 Map<String,String> response=new HashMap<String, String>();
		try {
			foodAdminServices.addFood(food);
			 response.put("ok", "food is sucessfully added");
	            return ResponseEntity.accepted().body(response);
		} catch (BusinessException e) {
			 response.put("error", e.getMessage());
	            return ResponseEntity.badRequest().body(response);
		}
	}
    
    
   
    @RequestMapping(value="/updatefood",method=RequestMethod.PUT, produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Map<String, String>> updateFood(@RequestBody Food food){
    	Map<String,String> response=new HashMap<String, String>();
		try {
			foodAdminServices.updateFood(food);
			response.put("ok", "food is sucessfully updated");
            return ResponseEntity.accepted().body(response);
		} catch (Exception e) {
			 response.put("error", e.getMessage());
	            return ResponseEntity.badRequest().body(response);
		}
	}
    
    @RequestMapping(value="/deletefood/{fid}",method=RequestMethod.DELETE, produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Map<String, String>> deleteFood(@PathVariable("fid")String fid){
    	Map<String,String> response=new HashMap<String, String>();
		try {
			foodAdminServices.deleteFood(fid);
			response.put("ok", "food is sucessfully deleted");
            return ResponseEntity.accepted().body(response);
			
		} catch (Exception e) {
			 response.put("error", e.getMessage());
	            return ResponseEntity.badRequest().body(response);
			  
		}

	}
    
    @RequestMapping(value="/getallfood",method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    
	public ResponseEntity<List<Food>> getAllFoods(){
		List<Food> foods=null;
		try {
			foods=foodAdminServices.retirveAllFood();
		} catch (Exception e) {
			e.printStackTrace();
			 return new ResponseEntity<List<Food>>(HttpStatus.SEE_OTHER);
		}
		return ResponseEntity.accepted().body(foods);
	}
	
    
    @RequestMapping(value="/getfoodbyname/{fname}",method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
   	public Food getFoodByName(@PathVariable("fname")String fname){
    	 Food f=null;
   		try {
   			f=foodAdminServices.retriveFoodByName(fname);
   		} catch (Exception e) {
   			e.printStackTrace();
   		}
   		return f;
   	}
       
}
