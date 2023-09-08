package com.hemebiotech.analytics.sorter;

import java.util.Map;
import java.util.TreeMap;

public class AlphabeticalSymptomSorter implements ISymptomSorter {
    private Map<String, Integer> symptoms;

    public AlphabeticalSymptomSorter() {
        this.symptoms = null;
    }

    @Override
    public void setSymptoms(Map<String, Integer> symptoms) {
        this.symptoms = symptoms;
    }

    @Override
    public Map<String, Integer> getSortedSymptoms() {
        return new TreeMap<>(this.symptoms);
    }
}
