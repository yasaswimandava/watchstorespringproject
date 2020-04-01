package com.mindtree.watchstore.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.watchstore.entity.Store;
import com.mindtree.watchstore.entity.Watch;
import com.mindtree.watchstore.exception.service.WatchStoreApplicationServiceException;
import com.mindtree.watchstore.exception.service.custom.StoreAlreadyExistsException;
import com.mindtree.watchstore.exception.service.custom.StoreDoesnotExistException;
import com.mindtree.watchstore.exception.service.custom.WatchNotFoundException;
import com.mindtree.watchstore.repository.StoreRepository;
import com.mindtree.watchstore.repository.WatchRepository;
import com.mindtree.watchstore.service.WatchStoreService;

@Service
public class WatchStoreServiceImplementation implements WatchStoreService {
	@Autowired
	WatchRepository watchrepository;

	@Autowired
	StoreRepository storerepository;

	@Override
	public String insertStore(Store store) throws WatchStoreApplicationServiceException {
		List<Store> stores = storerepository.findAll();
		if (stores.isEmpty()) {
			storerepository.save(store);
		} else {
			for (int i = 0; i < stores.size(); i++) {
				if (stores.get(i).getStorename().equalsIgnoreCase(store.getStorename())) {
					throw new StoreAlreadyExistsException("store already present");
				}
			}
			storerepository.save(store);

		}

		return "store added successfully";
	}

	@Override
	public String insertWatch(Watch watch, long storeid) throws WatchStoreApplicationServiceException {
		Store stores = storerepository.findById(storeid).orElse(null);

		if (stores != null) {
			watch.setStore(stores);

			watchrepository.save(watch);

		} else {
			throw new StoreDoesnotExistException("store id not found");
		}

		return "watch added successfully";
	}

	@Override
	public List<Watch> getWatches() throws WatchStoreApplicationServiceException {
		
		List<Watch> result=watchrepository.findAll();
		if(result.isEmpty())
		{
			throw new WatchNotFoundException("no wathes are their in database");
		}
		return result;
	}

}
