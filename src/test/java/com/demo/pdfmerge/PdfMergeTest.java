package com.demo.pdfmerge;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public class PdfMergeTest {

    public static final String RELATIVE_PATH = "src/test/resources/";
    public static final String OUTPUT = RELATIVE_PATH + "merged.pdf";

    @Test
    public void mergeTest() throws IOException {

        final String FILE1 = RELATIVE_PATH + "PandP.pdf";
        final String FILE2 = RELATIVE_PATH + "Dorian.pdf";


        PdfMerge.merge(FILE1, FILE2, OUTPUT, true);

        File output = new File(OUTPUT);
        assert(output.exists());
    }

    @Test(expected = IOException.class)
    public void mergeThenProhibitOverwriteExpectExceptionTest() throws IOException {

        final String FILE1 = RELATIVE_PATH + "PandP.pdf";
        final String FILE2 = RELATIVE_PATH + "Dorian.pdf";

        // create merge file (overwrite output set to true)
        PdfMerge.merge(FILE1, FILE2, OUTPUT, true);
        // try to merge again (overwrite output set to false)
        PdfMerge.merge(FILE1, FILE2, OUTPUT, false);
    }

    @Test(expected = FileNotFoundException.class)
    public void missingFiles() throws IOException {
        PdfMerge.merge( "unknown.pdf", "unknown.pdf", OUTPUT, true);
    }



}