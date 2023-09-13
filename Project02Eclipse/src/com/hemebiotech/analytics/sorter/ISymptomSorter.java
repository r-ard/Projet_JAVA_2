package com.hemebiotech.analytics.sorter;

import java.util.Map;

public interface ISymptomSorter {
    void setSymptoms(Map<String, Integer> symptoms);

    /**
     * Get sorted symptoms map
     * @return sorted symptoms map
     */
    Map<String, Integer> getSortedSymptoms();
}
