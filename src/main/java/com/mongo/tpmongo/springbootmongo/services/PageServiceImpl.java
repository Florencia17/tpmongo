package com.mongo.tpmongo.springbootmongo.services;


import com.mongodb.client.MongoClient;
import com.mongodb.client.model.Filters;
import com.mongo.tpmongo.springbootmongo.api.PageService;
import com.mongo.tpmongo.springbootmongo.model.Page;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class PageServiceImpl extends MongoGenericService implements PageService {

    public List<Page> findById(String id) {
        List<Page> pages;
        try {
            pages = inTx(collection -> {
                return collection.find(Filters.eq("_id", new ObjectId(id)))
                        .map(document -> Page.builder()
                                .id(String.valueOf(document.getObjectId("_id")))
                                .title(document.getString("title"))
                                .text(document.getString("text"))
                                .author(document.getString("author"))
                                .date(LocalDate.parse(document.getString("date"), DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                                .build())
                        .into(new ArrayList<>());
            }, "pages");
        } catch (Exception e) {
            throw e;
        }
        return pages;
    }
}
