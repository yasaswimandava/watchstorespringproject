package com.mindtree.watchstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.watchstore.entity.Store;
import com.mindtree.watchstore.entity.Watch;
@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {


	

}
