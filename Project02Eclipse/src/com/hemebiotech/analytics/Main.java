package com.hemebiotech.analytics;

import com.hemebiotech.analytics.reader.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.renderer.SimpleSymptomRender;
import com.hemebiotech.analytics.sorter.AlphabeticalSymptomSorter;
import com.hemebiotech.analytics.writter.WriteSymptomFileFromData;

public class Main {
	public static void main(String args[]) throws Exception {
		AnalyticsCounter analyticsCounter = new AnalyticsCounter(
				new ReadSymptomDataFromFile(args.length > 0 ? args[0] : "symptoms.txt"),
				new WriteSymptomFileFromData(args.length > 1 ? args[1] : "result.txt", new SimpleSymptomRender()),
				new AlphabeticalSymptomSorter()
		);

		// Lire le contenu du fichier "symptoms.txt"
		analyticsCounter.readResults();

		// Process le contenu du fichier "symptoms.txt" afin de faire un répertoire des symptomes ainsi que leur fréquence
		analyticsCounter.processResults();

		// Trier le résultat obtenu par le process à l'aide de notre classe de triage
		analyticsCounter.sortResults();

		// Ecrire le résultat dans le fichier "result.out"
		analyticsCounter.writeResults();
	}
}
