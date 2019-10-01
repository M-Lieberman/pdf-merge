package com.demo.pdfmerge;

import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;

import java.io.File;
import java.io.IOException;

public class PdfMerge {

    public static void merge(String file1, String file2, String mergedFile, boolean overwrite) throws IOException {

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

        pdfMerger.addSource(new File(file1));
        pdfMerger.addSource(new File(file2));

        pdfMerger.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());
    }
}
