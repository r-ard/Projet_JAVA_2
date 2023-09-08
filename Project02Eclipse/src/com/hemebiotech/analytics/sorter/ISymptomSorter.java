package com.hemebiotech.analytics.sorter;

import java.util.Map;

public interface ISymptomSorter {
    void setSymptoms(Map<String, Integer> symptoms);
    Map<String, Integer> getSortedSymptoms();
}
