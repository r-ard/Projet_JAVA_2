package com.hemebiotech.analytics.renderer;

import java.util.Map;

public interface ISymptomRenderer {
    void setSymptoms(Map<String, Integer> symptoms);
    String renderSymptoms();
}
