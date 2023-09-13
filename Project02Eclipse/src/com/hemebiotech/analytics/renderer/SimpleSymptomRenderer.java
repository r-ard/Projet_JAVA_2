package com.hemebiotech.analytics.renderer;

import java.util.Map;

public class SimpleSymptomRenderer implements ISymptomRenderer {
    private Map<String, Integer> symptoms;

    public SimpleSymptomRenderer() {
        this.symptoms = null;
    }

    @Override
    public void setSymptoms(Map<String, Integer> symptoms) {
        this.symptoms = symptoms;
    }

    @Override
    public String renderSymptoms() {
        if(this.symptoms == null) {
            return "";
        }

        String out = "";
        for(String key : this.symptoms.keySet())
            out += key + ": " + this.symptoms.get(key).toString() + "\n";
        return out;
    }
}
