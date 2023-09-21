package com.hemebiotech.analytics.sorter;

import java.util.Map;
import java.util.TreeMap;

public class AlphabeticalSymptomSorter implements ISymptomSorter {

    public AlphabeticalSymptomSorter() {
    }

    @Override
    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
        return symptoms == null ? null : new TreeMap<>(symptoms);
    }
}
