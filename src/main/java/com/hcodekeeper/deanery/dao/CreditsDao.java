package com.hcodekeeper.deanery.dao;

import com.hcodekeeper.deanery.models.UserCredentials;
import com.hcodekeeper.deanery.models.identifiers.Role;

import java.util.Collection;

public interface CreditsDao extends Dao<UserCredentials> {
    UserCredentials getByLoginPassRole(String login, String password, Role role);
    void insert(String login, String password, Role role);


}
