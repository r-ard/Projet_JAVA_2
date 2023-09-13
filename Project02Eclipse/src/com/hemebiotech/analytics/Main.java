package com.hemebiotech.analytics;

import com.hemebiotech.analytics.processor.BasicSymptomProcessor;
import com.hemebiotech.analytics.reader.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.renderer.SimpleSymptomRenderer;
import com.hemebiotech.analytics.service.AnalyticsCounter;
import com.hemebiotech.analytics.sorter.AlphabeticalSymptomSorter;
import com.hemebiotech.analytics.writter.WriteSymptomFileFromData;

public class Main {
	public static void main(String args[]) {
		String inputFile = args.length > 0 ? args[0] : "symptoms.txt";
		String outputFile = args.length > 1 ? args[1] : "result.txt";

		// Create the instance of the main "Counter" Service
		AnalyticsCounter analyticsCounter = new AnalyticsCounter(
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

		// Read lines of the content of "symptoms.txt"
		if(!analyticsCounter.readSymptoms()) {
			// If the file, doesn't exist, isn't accessible or is empty, then exit the program with the error code "1"
			System.out.println("Failed to read the symptoms file at \"" + inputFile + "\".");
			System.exit(1);
			return;
		}

		// Process raw file content by using a IProcessor class (retrieve symptoms and count them) and store it as a result
		analyticsCounter.processSymptoms();

		// Sort processed results by using a ISorter class (sort results alphabeticaly)
		analyticsCounter.sortResults();

		// Write the processed & sorted results in a text file by using a IWriter class
		if(!analyticsCounter.writeResults()) {
			// If the out file creation fails, exit the program with the error code "2"
			System.out.println("Failed to write the result file at \"" + outputFile + "\".");
			System.exit(2);
			return;
		}

		System.out.println("The result file has been successfully written at \"" + outputFile + "\" !");
	}
}
