package com.hemebiotech.analytics;

import com.hemebiotech.analytics.processor.BasicSymptomProcessor;
import com.hemebiotech.analytics.reader.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.renderer.SimpleSymptomRender;
import com.hemebiotech.analytics.sorter.AlphabeticalSymptomSorter;
import com.hemebiotech.analytics.writter.WriteSymptomFileFromData;

public class Main {
	public static void main(String args[]) {
		// Create the instance of the main "Counter" Service
		AnalyticsCounter analyticsCounter = new AnalyticsCounter(
				new ReadSymptomDataFromFile(
						args.length > 0 ? args[0] : "symptoms.txt"
				),
				new WriteSymptomFileFromData(
						args.length > 1 ? args[1] : "result.txt",
						new SimpleSymptomRender()
				),
				new AlphabeticalSymptomSorter(),
				new BasicSymptomProcessor()
		);

		// Read lines of the content of "symptoms.txt"
		if(!analyticsCounter.readSymptoms()) {
			// If the file, doesn't exist, isn't accessible or is empty, then exit the program with the error code "1"
			System.exit(1);
			return;
		}

		// Process raw file content by using a IProcessor class (retrieve symptoms and count them) and store it as a result
		analyticsCounter.processSymptoms();

		// Sort processed results by using a ISorter class (sort results alphabeticaly)
		analyticsCounter.sortResults();

		// Write the processed & sorted results in a text file by using a IWriter class
		analyticsCounter.writeResults();
	}
}
