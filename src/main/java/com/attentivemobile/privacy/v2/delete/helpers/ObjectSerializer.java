package com.attentivemobile.privacy.v2.delete.helpers;

import com.attentivemobile.privacy.v2.delete.stats.Logger;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ObjectSerializer {

    private static final Logger LOG = Logger.getLogger(ObjectSerializer.class);

    public String toPrettyString(Object obj) {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            return gson.toJson(obj);
        } catch (Exception ex) {
            LOG.error("Error serializing class!", ex);
            throw ex;
        }
    }

    public String toString(Object obj) {
        try {
            Gson gson = new GsonBuilder().create();
            return gson.toJson(obj);
        } catch (Exception ex) {
            LOG.error("Error serializing class!", ex);
            throw ex;
        }
    }
}