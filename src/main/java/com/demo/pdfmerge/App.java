package com.demo.pdfmerge;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class App
{
    public static void main(String... args) throws IOException {

        // TODO add error handling
        final var overwriteMergeFile = Boolean.getBoolean(args[0]);
        final var mergedFilename = args[1];
        final List<String> filenames = Arrays.asList(Arrays.copyOfRange(args, 2, args.length-1));
        PdfMerge.merge(overwriteMergeFile, mergedFilename, filenames);
    }
}
