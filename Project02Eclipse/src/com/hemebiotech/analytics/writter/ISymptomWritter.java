package com.hemebiotech.analytics.writter;

import java.util.Map;

public interface ISymptomWritter {
    /**
     * Write symptoms to the drive as a text file
     */
    void writeSymptoms(Map<String, Integer> symptoms) throws Exception;
}
