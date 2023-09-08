package com.hemebiotech.analytics.writter;

import java.util.Map;

public interface ISymptomWritter {
    void setSymptoms(Map<String, Integer> symptoms);
    void writeSymptoms();
}
