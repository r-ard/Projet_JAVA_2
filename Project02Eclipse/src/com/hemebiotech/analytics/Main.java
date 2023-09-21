package com.hemebiotech.analytics;

import com.hemebiotech.analytics.builder.AnalyticsCounterBuilder;
import com.hemebiotech.analytics.processor.BasicSymptomProcessor;
import com.hemebiotech.analytics.reader.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.renderer.SimpleSymptomRenderer;
import com.hemebiotech.analytics.service.AnalyticsCounter;
import com.hemebiotech.analytics.sorter.AlphabeticalSymptomSorter;
import com.hemebiotech.analytics.writter.WriteSymptomFileFromData;

public class Main {
	public static void main(String args[]) throws Exception {
		String inputFile = args.length > 0 ? args[0] : "symptoms.txt";
		String outputFile = args.length > 1 ? args[1] : "result.out";

		// Create the instance of the main "Counter" Service
		AnalyticsCounter analyticsCounter = AnalyticsCounterBuilder.build(
				inputFile,
				outputFile
		);

		// Read lines of the content of {inputFile} by using a IReader class
		analyticsCounter.readSymptoms();

		// Process raw file content by using a IProcessor class (retrieve symptoms and count them) and store it as a result
		analyticsCounter.processSymptoms();

		// Sort processed results by using a ISorter class (sort results alphabeticaly)
		analyticsCounter.sortResults();

		// Write the processed & sorted results in a text file by using a IWriter class
		analyticsCounter.writeResults();

		System.out.println("The result file has been successfully written at \"" + outputFile + "\" !");
	}
}
