package com.hemebiotech.analytics;

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

    private List<String> rawResults;
    private Map<String, Integer> results;

    public AnalyticsCounter(
            ISymptomReader reader,
            ISymptomWritter writter,
            ISymptomSorter sorter
    ) {
        this.rawResults = null;
        this.results = null;
        this.reader = reader;
        this.writter = writter;
        this.sorter = sorter;
    }

    public void readResults() {
        if(this.reader != null) {
            this.rawResults = this.reader.GetSymptoms();
        }
    }

    public void processResults() {
        if(this.rawResults != null) {
            Map<String, Integer> results = new HashMap<>();

            for(String symptom : this.rawResults) {
                if(!results.containsKey(symptom)) {
                    results.put(symptom, 0);
                }

                results.put(symptom, results.get(symptom) + 1);
            }

            this.results = results;
        }
    }

    public void sortResults() {
        if(this.results != null && this.sorter != null) {
            this.sorter.setSymptoms(this.results);
            this.results = this.sorter.getSortedSymptoms();
        }
    }

    public void writeResults() {
        if(this.writter != null && this.results != null) {
            this.writter.setSymptoms(this.results);
            this.writter.writeSymptoms();
        }
    }
}
