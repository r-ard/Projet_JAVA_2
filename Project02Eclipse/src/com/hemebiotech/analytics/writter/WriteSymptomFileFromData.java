package com.hemebiotech.analytics.writter;

import com.hemebiotech.analytics.renderer.ISymptomRenderer;

import java.io.FileWriter;
import java.util.Map;

public class WriteSymptomFileFromData implements ISymptomWritter {
    private String fileName;
    private ISymptomRenderer renderer;

    public WriteSymptomFileFromData(String fileName, ISymptomRenderer renderer) {
        this.fileName = fileName;
        this.renderer = renderer;
    }

    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) throws Exception {
        if(this.fileName != null && symptoms != null) {
            try(FileWriter writer = new FileWriter(this.fileName)) {
                if(this.renderer != null) {
                    writer.write( this.renderer.renderSymptoms(symptoms) );
                }
            }
            catch(Exception error) {
                throw new Exception("Failed to write the file at \"" + this.fileName + "\"");
            }
        }
        else {
            throw new Exception("Filename or symptoms map null while writting symptoms");
        }
    }
}
