package com.hcodekeeper.deanery.helpers;

import com.hcodekeeper.deanery.configs.Config;
import com.hcodekeeper.deanery.customExceptions.DatabaseURINotFound;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class MongoConnectionManager implements DatabaseConnectionManager<MongoDatabase> {
    private MongoClient mongoClient;
    private Config config;

    public MongoConnectionManager(Config config){
        setConfig(config);
    }

    public Config getConfig(){
        return config;
    }

    public void setConfig(Config config){
        if (config == null){
            throw new IllegalArgumentException("Config is set to null");
        }
        this.config = config;
    }

    @Override
    public void connect() throws IllegalArgumentException, DatabaseURINotFound {
        if (mongoClient != null){
            close();
        }
        ConnectionString connectionString = new ConnectionString(config.getDatabaseURI());
        //include pojos support
        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
        //include java types for mongo
        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                pojoCodecRegistry);
        MongoClientSettings clientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .codecRegistry(codecRegistry)
                .build();
        mongoClient = MongoClients.create(clientSettings);
    }

    @Override
    public MongoDatabase getDatabase(String name) throws MongoException{
        MongoDatabase database = mongoClient.getDatabase(name);
        if (database == null){
            throw new MongoException("Didn't find a database with such name");
        }
        return database;
    }

    @Override
    public void close(){
        mongoClient.close();
    }
}
