package com.hemebiotech.analytics.writter;

import com.hemebiotech.analytics.renderer.ISymptomRenderer;

import java.io.FileWriter;
import java.util.Map;

public class WriteSymptomFileFromData implements ISymptomWritter {
    private Map<String, Integer> symptoms;
    private String fileName;
    private ISymptomRenderer renderer;

    public WriteSymptomFileFromData(String fileName, ISymptomRenderer renderer) {
        this.symptoms = null;
        this.fileName = fileName;
        this.renderer = renderer;
    }

    @Override
    public void setSymptoms(Map<String, Integer> symptoms) {
        this.symptoms = symptoms;
    }

    @Override
    public boolean writeSymptoms() {
        if(this.fileName != null && this.symptoms != null) {
            FileWriter writer = null;
            try {
                writer = new FileWriter(this.fileName);
                if(this.renderer != null) {
                    this.renderer.setSymptoms(this.symptoms);
                    writer.write( this.renderer.renderSymptoms() );
                }
            }
            catch(Exception error) {
                error.printStackTrace();
                return false;
            }
            finally {
                if(writer != null) {
                    try {
                        writer.close();
                    }
                    catch (Exception error) {
                        error.printStackTrace();
                    }
                }
            }
            return true;
        }
        return false;
    }
}
