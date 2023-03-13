package com.tactical.privacy.helpers;

import com.google.gson.GsonBuilder;
import com.tactical.privacy.stats.Logger;

public class ObjectSerializer {

    private static final Logger LOG = Logger.getLogger(ObjectSerializer.class);

    public String toPrettyString(Object obj) {
        try {
            var gson = new GsonBuilder().setPrettyPrinting().create();
            return gson.toJson(obj);
        } catch (Exception ex) {
            LOG.error("Error serializing class!", ex);
            throw ex;
        }
    }
}