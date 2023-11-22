package com.mongo.tpmongo.springbootmongo.api;

import com.mongo.tpmongo.springbootmongo.model.Page;
import com.mongo.tpmongo.springbootmongo.model.Page;

import java.util.List;

public interface PageService {

    List<Page> findById(String id);


}
