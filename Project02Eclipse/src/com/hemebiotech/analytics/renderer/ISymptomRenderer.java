package com.hemebiotech.analytics.renderer;

import java.util.Map;

public interface ISymptomRenderer {
    /**
     * Generate the file content/string form of a symptoms map
     * @return generated file content
     */
    String renderSymptoms(Map<String, Integer> symptoms);
}
