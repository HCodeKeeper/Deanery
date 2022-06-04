package com.hcodekeeper.deanery.models;

import org.bson.types.ObjectId;

public interface AbstractPojo {

    ObjectId getId();
    AbstractPojo setId(ObjectId id);
}
