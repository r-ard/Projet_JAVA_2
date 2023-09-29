package com.hemebiotech.analytics.service;

import com.hemebiotech.analytics.processor.ISymptomProcessor;
import com.hemebiotech.analytics.reader.ISymptomReader;
import com.hemebiotech.analytics.sorter.ISymptomSorter;
import com.hemebiotech.analytics.writter.ISymptomWritter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalyticsCounter {
    private ISymptomReader reader;
    private ISymptomWritter writter;
    private ISymptomSorter sorter;
    private ISymptomProcessor processor;

    private List<String> rawSymptoms;
    private Map<String, Integer> results;

    public AnalyticsCounter(
            ISymptomReader reader,
            ISymptomWritter writter,
            ISymptomSorter sorter,
            ISymptomProcessor processor
    ) {
        this.rawSymptoms = null;
        this.results = null;
        this.reader = reader;
        this.writter = writter;
        this.sorter = sorter;
        this.processor = processor;
    }

    /*
    * Read the raw symptoms from a file by using the injected ISymptomReader
    */
    public void readSymptoms() throws Exception {
        if(this.reader != null) {
            this.rawSymptoms = this.reader.getSymptoms();
        }
        if(this.rawSymptoms.isEmpty()) throw new Exception("Symptoms file content is null");
    }

    /*
    * Process raw symptoms by using the injected ISymptomProcessor
    */
    public void processSymptoms() {
        if(this.rawSymptoms != null && this.processor != null) {
            this.results = this.processor.processSymptoms(this.rawSymptoms);
        }
    }

    /*
    * Sort results by using the injected ISymptomSorter
    */
    public void sortResults() {
        if(this.results != null && this.sorter != null) {
            this.results = this.sorter.sortSymptoms(this.results);
        }
    }

    /*
    * Write results to the drive by using the injected ISymptomWriter
    */
    public void writeResults() throws Exception {
        if(this.writter != null && this.results != null) {
            this.writter.writeSymptoms(this.results);
        }
    }
}
