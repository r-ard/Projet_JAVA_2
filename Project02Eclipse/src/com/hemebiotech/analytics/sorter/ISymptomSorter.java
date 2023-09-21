package com.hemebiotech.analytics.sorter;

import java.util.Map;

public interface ISymptomSorter {
    /**
     * Sort the input symptoms map
     * @return sorted symptoms map
     */
    Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms);
}
