package com.mindtree.watchstore.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.watchstore.entity.Store;
import com.mindtree.watchstore.entity.Watch;
import com.mindtree.watchstore.exception.service.WatchStoreApplicationServiceException;
import com.mindtree.watchstore.service.WatchStoreService;

@RestController
@RequestMapping("/watchstore")
public class WatchStoreController {
	@Autowired
	WatchStoreService watchservice;
	
	@PostMapping("/addstore")
	public String addStore(@RequestBody Store store)
	{
		String result="";
		try {
			result=watchservice.insertStore(store);
		} catch (WatchStoreApplicationServiceException e) {
			return e.getMessage();
		}
		return result;
		}
	@PostMapping("/addwatch/{storeid}")
	public String addWatch(@RequestBody Watch watch, @PathVariable long storeid)
	{
		String result="";
		try {
			result= watchservice.insertWatch(watch,storeid);
		} catch (WatchStoreApplicationServiceException e) {
			return e.getMessage();
		}
		return result;
		
	}
	@GetMapping("/display")
	public List<Watch> displayWatches()
	{
		List<Watch> result=null;
		try {
			result=watchservice.getWatches();
		} catch (WatchStoreApplicationServiceException e) {
			e.getMessage();
		}
		return result;
	}

}
