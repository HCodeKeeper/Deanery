package com.hcodekeeper.deanery.services;

import com.hcodekeeper.deanery.models.identifiers.Role;

public interface CreditService {
    boolean isRegistered(String login, String password, Role role);
}
