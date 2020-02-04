package com.demo.pdfmerge;

import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class PdfMerge {

    public static void merge(boolean overwrite, String mergedFile, List<String> filenames) throws IOException {

        if (new File(mergedFile).exists()) {
            boolean deleted = false;
            if (overwrite) {
                deleted = new File(mergedFile).delete();
            }
            if (!overwrite || !deleted) {
                throw new IOException("Unable to delete or overwrite previously created merge file. Please delete manually.");
            }

        }

        PDFMergerUtility pdfMerger = new PDFMergerUtility();

        pdfMerger.setDestinationFileName(mergedFile);
        PDDocumentInformation documentInformation = new PDDocumentInformation();
        documentInformation.setTitle("Merged Document");
        documentInformation.setCreator("N/A");

        documentInformation.setSubject("Files merged with Apache PDF Box");

        for(String filename: filenames) {
            pdfMerger.addSource(new File(filename));
        }

        pdfMerger.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());
    }
}
