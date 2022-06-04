package com.hcodekeeper.deanery.models;
import com.hcodekeeper.deanery.models.identifiers.Role;
import com.hcodekeeper.deanery.models.identifiers.User;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

public class UserCredentials implements AbstractPojo{
    @BsonProperty(value = "_id")
    private ObjectId id;
    private String login;
    private String password;
    private Role role;
    private ObjectId userId;

    public UserCredentials(){

    }

    public ObjectId getId() {
        return id;
    }

    @Override
    public AbstractPojo setId(ObjectId id) {
        this.id = id;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public UserCredentials setLogin(String login) {
        this.login = login;
        return this;
    }

    public UserCredentials setUserId(ObjectId userId){
        this.userId = userId;
        return this;
    }

    public ObjectId getUserId(){
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public UserCredentials setPassword(String password) {
        this.password = password;
        return this;
    }

    public Role getRole() {
        return role;
    }

    public UserCredentials setRole(Role role) {
        this.role = role;
        return this;
    }
}
