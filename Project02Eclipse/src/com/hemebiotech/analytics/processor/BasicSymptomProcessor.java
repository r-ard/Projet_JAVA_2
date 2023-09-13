package com.hemebiotech.analytics.processor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BasicSymptomProcessor implements ISymptomProcessor {
    public BasicSymptomProcessor() { }

    @Override
    public Map<String, Integer> processSymptoms(List<String> symptoms) {
        Map<String, Integer> results = new HashMap<>();

        if(symptoms != null) {
            for(String symptom : symptoms) {
                if(!results.containsKey(symptom)) {
                    results.put(symptom, 0);
                }

                results.put(symptom, results.get(symptom) + 1);
            }
        }

        return results;
    }
}
