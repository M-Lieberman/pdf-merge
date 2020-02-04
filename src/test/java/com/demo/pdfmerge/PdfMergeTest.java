package com.demo.pdfmerge;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;


public class PdfMergeTest {

    public static final String RELATIVE_PATH = "src/test/resources/";
    public static final String OUTPUT = RELATIVE_PATH + "merged.pdf";

    @Test
    public void merge2PdfsTest() throws IOException {

        List<String> filenames = List.of (RELATIVE_PATH + "PandP.pdf", RELATIVE_PATH + "Dorian.pdf");
        PdfMerge.merge(true, OUTPUT, filenames);

        File output = new File(OUTPUT);
        assert(output.exists());
    }

    @Test
    public void mergeThenProhibitOverwriteExpectExceptionTest() throws IOException {

        List<String> filenames = List.of (RELATIVE_PATH + "PandP.pdf", RELATIVE_PATH + "Dorian.pdf");

        // create merge file (overwrite output set to true)
        PdfMerge.merge(true, OUTPUT, filenames);
        // try to merge again (overwrite output set to false)
        Assertions.assertThrows(IOException.class, () -> PdfMerge.merge(false, OUTPUT, filenames));
    }

    @Test
    public void missingFilesTest()  {
        List<String> filenames = List.of("unknown.pdf", "unknown.pdf");

        Assertions.assertThrows(FileNotFoundException.class, () -> PdfMerge.merge(true, OUTPUT, filenames));
    }

    // test merge of multiple file
    @Test
    public void merge3PdfsTest() throws IOException {

        List<String> filenames = List.of (RELATIVE_PATH + "PandP.pdf", RELATIVE_PATH + "Dorian.pdf", RELATIVE_PATH + "PandP.pdf");
        PdfMerge.merge(true, OUTPUT, filenames);

        File output = new File(OUTPUT);
        assert(output.exists());
    }



}