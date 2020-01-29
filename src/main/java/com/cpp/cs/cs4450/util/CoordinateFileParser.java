/***************************************************************
 * file: CoordinateFileParser.java
 * author: Bryan Ayala
 * class: CS 4450 - Computer Graphics
 *
 * assignment: Program 1
 * date last modified: 01/29/2020
 *
 * purpose: Utility class to parse the coordinates.txt file
 *
 ****************************************************************/

package com.cpp.cs.cs4450.util;

import javafx.util.Pair;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * This class is responsible for parsing through the coordinates.txt file
 */
public class CoordinateFileParser {

    /**
     * Private Default Constructor to not allow instantiation.
     */
    private CoordinateFileParser(){}

    /**
     * Parses the coordinates from a file
     *
     * @param file The file path
     *
     * @return List of pairs representing display shape configurations
     *
     * @throws IOException if file is not found
     */
    public static List<Pair<String, String>> parseCoordinates(final String file) throws IOException{
        return readFileToList(file).stream().map(CoordinateFileParser::parseLine).collect(Collectors.toList());
    }

    /**
     * Parses a line from the file.
     *
     * @param line the line to parse
     *
     * @return Pair representing display shape configuration
     */
    private static Pair<String, String> parseLine(final String line){
        final StringTokenizer stringTokenizer = new StringTokenizer(line);

        final List<String> parsedLine = new ArrayList<>();
        while(stringTokenizer.hasMoreElements()){
            parsedLine.add(stringTokenizer.nextToken());
        }

        final String key = parsedLine.remove(0);
        final String value = String.join(" ", parsedLine);

        return new Pair<>(key, value);
    }

    /**
     * Reads a file to a list
     *
     * @param file File path
     *
     * @return List of lines in file
     *
     * @throws IOException if file not found
     */
    private static List<String> readFileToList(final String file) throws IOException {
        return Files.readAllLines(Paths.get(file), StandardCharsets.UTF_8);
    }

}
