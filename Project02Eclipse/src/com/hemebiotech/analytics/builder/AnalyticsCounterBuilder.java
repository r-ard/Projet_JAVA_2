package com.hemebiotech.analytics.builder;

import com.hemebiotech.analytics.processor.BasicSymptomProcessor;
import com.hemebiotech.analytics.reader.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.renderer.SimpleSymptomRenderer;
import com.hemebiotech.analytics.service.AnalyticsCounter;
import com.hemebiotech.analytics.sorter.AlphabeticalSymptomSorter;
import com.hemebiotech.analytics.writter.WriteSymptomFileFromData;

public class AnalyticsCounterBuilder {
    public static AnalyticsCounter build(String inputFile, String outputFile) {
        return new AnalyticsCounter(
                new ReadSymptomDataFromFile(
                        inputFile
                ),
                new WriteSymptomFileFromData(
                        outputFile,
                        new SimpleSymptomRenderer()
                ),
                new AlphabeticalSymptomSorter(),
                new BasicSymptomProcessor()
        );
    }
}
