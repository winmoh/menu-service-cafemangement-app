package com.cafemanager.menuservice.repository;

import com.cafemanager.menuservice.model.menu;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MenuRepository extends MongoRepository<menu,String> {
}
