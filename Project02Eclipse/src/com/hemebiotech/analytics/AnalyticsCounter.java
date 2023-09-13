package com.hemebiotech.analytics;

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
    public boolean readSymptoms() {
        if(this.reader != null) {
            this.rawSymptoms = this.reader.GetSymptoms();
        }
        return this.rawSymptoms != null;
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
            this.sorter.setSymptoms(this.results);
            this.results = this.sorter.getSortedSymptoms();
        }
    }

    /*
    * Write results to the drive as a text file
    */
    public void writeResults() {
        if(this.writter != null && this.results != null) {
            this.writter.setSymptoms(this.results);
            this.writter.writeSymptoms();
        }
    }
}
