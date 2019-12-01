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

import com.mukesh.pizza.entities.AddOn;

import com.mukesh.pizza.services.FoodAdminServices;

@RestController
public class AddOnController {
	
	@Autowired
	FoodAdminServices foodAdminServices;
	

    @RequestMapping(value="/getaddonbyid/{adid}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AddOn>  getAddOnById(@PathVariable("adid") String adid) {
        // TODO Auto-generated method stub
        AddOn a=null;
             try {
                a=foodAdminServices.retriveAddOnById(adid);
            } catch (  Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return new ResponseEntity<AddOn>(HttpStatus.SEE_OTHER);
                
            }
           return ResponseEntity.accepted().body(a);
            
            
    }
    
    @RequestMapping(value="/addaddon",method=RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Map<String, String>> addAddOn(@RequestBody AddOn addon){
    	 Map<String,String> response=new HashMap<String, String>();
		try {
			foodAdminServices.addAddOn(addon);
			 response.put("ok", "AddOn is sucessfully added");
	            return ResponseEntity.accepted().body(response);
		} catch (Exception e) {
			 response.put("error", e.getMessage());
	            return ResponseEntity.badRequest().body(response);
		}
	}

    
    @RequestMapping(value="/updateaddon",method=RequestMethod.PUT, produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Map<String, String>> updateAddOn(@RequestBody AddOn addon){
    	 Map<String,String> response=new HashMap<String, String>();
		try {
			foodAdminServices.updateAddOn(addon);
			response.put("ok", "AddOn is sucessfully updated");
            return ResponseEntity.accepted().body(response);
		} catch (Exception e) {
			response.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(response);
		}
	}
    
    @RequestMapping(value="/deleteaddon/{adid}",method=RequestMethod.DELETE, produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Map<String, String>> deleteAddOn(@PathVariable("adid")String adid){
    	Map<String,String> response=new HashMap<String, String>();
		try {
			foodAdminServices.deleteAddOn(adid);
			response.put("ok", "AddOn is sucessfully deleted");
            return ResponseEntity.accepted().body(response);
		} catch (Exception e) {
			response.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(response);
		}
	}
    
    @RequestMapping(value="/getalladdon",method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AddOn>> getAllAddOns(){
		List<AddOn> addons=null;
		try {
			addons=foodAdminServices.retirveAllAddOn();
		} catch (Exception e) {
			e.printStackTrace();
			 return new ResponseEntity<List<AddOn>>(HttpStatus.SEE_OTHER);
		}
		 return ResponseEntity.accepted().body(addons);
	}
	
    @RequestMapping(value="/getaddonbyname/{adname}",method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
   	public ResponseEntity<AddOn> getAddOnByName(@PathVariable("adname")String adname){
    	AddOn a=null;
   		try {
   			a=foodAdminServices.retriveAddOnByName(adname);
   		} catch (Exception e) {
   			e.printStackTrace();
   		 return new ResponseEntity<AddOn>(HttpStatus.SEE_OTHER);
   		}
   	 return ResponseEntity.accepted().body(a);
   	}
    
    
    @RequestMapping(value="/getaddonbytype/{adOnType}",method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
   	public ResponseEntity<List<AddOn>> getAddOnByType(@PathVariable("adOnType")String adontype){
    	List<AddOn> a=null;
   		try {
   			a=foodAdminServices.retriveAddOnByType(adontype);
   		} catch (Exception e) {
   			e.printStackTrace();
   		 return new ResponseEntity<List<AddOn>>(HttpStatus.SEE_OTHER);
   		}
   	 return ResponseEntity.accepted().body(a);
   	}

}
