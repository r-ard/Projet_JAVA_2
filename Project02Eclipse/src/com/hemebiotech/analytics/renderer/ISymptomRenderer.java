package com.hemebiotech.analytics.renderer;

import java.util.Map;

public interface ISymptomRenderer {
    void setSymptoms(Map<String, Integer> symptoms);

    /**
     * Generate the file content of a symptoms map
     * @return generated file content
     */
    String renderSymptoms();
}
