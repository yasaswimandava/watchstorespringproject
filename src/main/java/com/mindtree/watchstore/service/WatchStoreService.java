package com.mindtree.watchstore.service;

import java.util.List;

import com.mindtree.watchstore.entity.Store;
import com.mindtree.watchstore.entity.Watch;
import com.mindtree.watchstore.exception.service.WatchStoreApplicationServiceException;

public interface WatchStoreService {

	String insertStore(Store store) throws WatchStoreApplicationServiceException;

	String insertWatch(Watch watch,long storeid) throws WatchStoreApplicationServiceException;

	List<Watch> getWatches() throws WatchStoreApplicationServiceException;

}
