package ru.burytia.cft;

import java.util.ArrayList;

public class ArgsParser {
    private static final String INT_KEY = "-i";
    private static final String STR_KEY = "-s";
    private static final String ASC_KEY = "-a";
    private static final String DES_KEY = "-d";

    public InputFileParameters parser(String[] args) {

        SortDirection sortDirection = SortDirection.ASC;
        DataType dataType = null;
        String outFile = null;
        ArrayList<String> inFiles = new ArrayList<>();
        if (args.length != 0) {
            for (String i : args) {
                if (i.equals(INT_KEY)) {
                    dataType = DataType.INT;
                } else if (i.equals(STR_KEY)) {
                    dataType = DataType.STRING;
                } else if (i.equals(DES_KEY)) {
                    sortDirection = SortDirection.DESC;
                } else if (i.equals(ASC_KEY)) {
                    sortDirection = SortDirection.ASC;
                } else if ((outFile == null) && !i.startsWith("-")) {
                    outFile = i;
                } else if (!i.startsWith("-")) {
                    inFiles.add(i);
                } else {
                    throw new IllegalArgumentException("Illegal Arguments in command line");
                }
            }
            } else {throw new IllegalArgumentException("Empty command line");}
            return new InputFileParameters(sortDirection, dataType, outFile, inFiles);
        }
    }


