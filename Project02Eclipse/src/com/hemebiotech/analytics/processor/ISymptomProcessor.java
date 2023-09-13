package com.hemebiotech.analytics.processor;

import java.util.List;
import java.util.Map;

public interface ISymptomProcessor {

    /**
     * Process raw symptoms lines to a result map
     * @param symptoms raw symptoms lines
     * @return processed symptoms as a result map (key: symptom, value: amount)
     */
    Map<String, Integer> processSymptoms(List<String> symptoms);
}
