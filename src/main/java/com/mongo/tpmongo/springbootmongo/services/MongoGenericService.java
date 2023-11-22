package com.mongo.tpmongo.springbootmongo.services;



import com.mongodb.Function;
import com.mongodb.client.*;
import org.bson.Document;


public class MongoGenericService {
    protected MongoDatabase database;
    protected MongoCollection<Document> collection;

    protected MongoClient getMongoClient() {
        return MongoClients.create("mongodb://localhost:27017/");
    }

    protected  <T> T inTx(Function<MongoCollection<Document>, T> toExecute, String collectionName) {
        MongoClient mongoClient = this.getMongoClient();
        database = mongoClient.getDatabase("local");
        collection = database.getCollection(collectionName);
        try {
            T t = toExecute.apply(collection);
            return t;
        } catch (Exception e) {
            throw e;
        } finally {
            mongoClient.close();
        }
    }

}
