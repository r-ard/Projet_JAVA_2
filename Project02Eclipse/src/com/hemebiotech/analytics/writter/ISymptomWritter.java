package com.hemebiotech.analytics.writter;

import java.util.Map;

public interface ISymptomWritter {
    void setSymptoms(Map<String, Integer> symptoms);

    /**
     * Write symptoms to a drive as a text file
     */
    void writeSymptoms();
}
