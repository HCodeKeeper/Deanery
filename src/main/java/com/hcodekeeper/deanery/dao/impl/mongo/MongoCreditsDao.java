package com.hcodekeeper.deanery.dao.impl.mongo;

import com.hcodekeeper.deanery.dao.CreditsDao;
import com.hcodekeeper.deanery.models.UserCredentials;
import com.hcodekeeper.deanery.models.identifiers.Role;
import com.hcodekeeper.deanery.models.identifiers.User;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.Collection;

public class MongoCreditsDao extends AbstractMongoDao<UserCredentials> implements CreditsDao {

    MongoCreditsDao(MongoDatabase db) {
        super(db);
        this.collection = db.getCollection("Credits", UserCredentials.class);
    }

    @Override
    public UserCredentials getByLoginPassRole(String login, String password, Role role) {
        MongoCursor<UserCredentials> cursor = collection
                .find(Filters.eq("password", password))
                .cursor();
        while(cursor.hasNext()){
            UserCredentials credentials = cursor.next();
            if (credentials.getLogin().equals(login) & credentials.getRole().equals(role)){
                cursor.close();
                return credentials;
            }
        }
        cursor.close();
        return null;
    }

    @Override
    public void insert(String login, String password, Role role) {
        UserCredentials credentials = new UserCredentials()
                .setLogin(login)
                .setPassword(password)
                .setRole(role);

        insert(credentials);
    }
}
