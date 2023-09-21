package com.hemebiotech.analytics.renderer;

import java.util.Map;

public class SimpleSymptomRenderer implements ISymptomRenderer {

    public SimpleSymptomRenderer() {

    }

    @Override
    public String renderSymptoms(Map<String, Integer> symptoms) {
        if(symptoms == null) {
            return "";
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(String key : symptoms.keySet())
            stringBuilder.append(key + ": " + symptoms.get(key).toString() + "\n");
        return stringBuilder.toString();
    }
}
