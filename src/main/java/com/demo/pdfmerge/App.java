package com.demo.pdfmerge;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        PdfMerge.merge(args[0], args[1], args[2], Boolean.getBoolean(args[3]));
    }
}
