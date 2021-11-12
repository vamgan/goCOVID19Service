package com.tracker.gocovid19service.controller;

import com.tracker.gocovid19service.model.MongoDumpObject;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

public class MongoDBDump {
    @Autowired
    public static void dumpRequest(String requestURL, String responseFromAPI, long apiResponseTime) throws JSONException {

//        ConnectionString connectionString = new ConnectionString("mongodb+srv://vamgan:vamgan1234@cluster0.vvcxz.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
//        MongoClientSettings settings = MongoClientSettings.builder()
//                .applyConnectionString(connectionString)
//                .build();
//        MongoClient mongoClient = MongoClients.create(settings);

//        MongoCollection<Document> collection = mongoOps.getCollection("Requests");
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("timeRequested",System.currentTimeMillis());
//        jsonObject.put("requestURL", requestURL);
//        jsonObject.put("responseFromAPI", responseFromAPI);
//        jsonObject.put("APIResponseTime", apiResponseTime);
//        final Document doc = new Document(jsonObject.toString());
//        collection.insertOne(doc);
        MongoDumpObject mongoDumpObject = new MongoDumpObject(requestURL,System.currentTimeMillis(), responseFromAPI, apiResponseTime);
        ApplicationContext ctx =
                new AnnotationConfigApplicationContext(MongoConfig.class);
        MongoOperations mongoTemplate =
                (MongoOperations) ctx.getBean("mongoTemplate");
        mongoTemplate.insert(mongoDumpObject, "Requests");
    }
}
