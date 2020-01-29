/***************************************************************
 * file: ComputerGraphicsApplication.java
 * author: Bryan Ayala
 * class: CS 4450 - Computer Graphics
 *
 * assignment: Program 1
 * date last modified: 01/29/2020
 *
 * purpose: Abstract class to launch program 1
 *
 ****************************************************************/

package com.cpp.cs.cs4450.application;

import com.cpp.cs.cs4450.config.Configuration;
import com.cpp.cs.cs4450.graphics.GraphicsEngine;
import com.cpp.cs.cs4450.graphics.LWJGLGraphicsEngine;
import com.cpp.cs.cs4450.graphics.Renderable;
import com.cpp.cs.cs4450.ui.LWJGLUserInterface;
import com.cpp.cs.cs4450.ui.UserInterface;
import com.cpp.cs.cs4450.util.CoordinateFileParser;
import com.cpp.cs.cs4450.util.DisplayShapeFactory;
import javafx.util.Pair;
import org.lwjgl.opengl.DisplayMode;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The ComputerGraphicsApplication class is an abstract class that is to be extended by any class
 * that contains the main method for a program that displays computer graphics to a display.
 * This class uses values from the {@link com.cpp.cs.cs4450.config.Configuration} class.
 */
public abstract class ComputerGraphicsApplication {
    /**
     * The file path flag used to check if the user passed a file path to the coordinates.txt file
     * in the command line arguments.
     */
    private static final String FILE_PATH_FLAG = "-f";

    /**
     * This is the method that launches the Computer Graphics application. It is responsible
     * for parsing through the command line arguments and initializing objects used in the program
     * and injecting them into other objects as dependencies as needed.
     *
     * @param args command line arguments
     */
    public static void launch(final String ...args){
        if(args == null || args.length == 0)
            launch();

        assert args != null;
        final List<String> arguments = new ArrayList<>(Arrays.asList(args));

        final int indexOfFilePathFlag = arguments.indexOf(FILE_PATH_FLAG);

        launch(((indexOfFilePathFlag != -1) && ((indexOfFilePathFlag + 1) < arguments.size())) ? arguments.get(indexOfFilePathFlag + 1) : Configuration.DEFAULT_FILE_PATH);
    }

    /**
     * Overloaded {@link #launch(String...) launch} that launches application with default configuration of {@link com.cpp.cs.cs4450.config.Configuration#DEFAULT_FILE_PATH}.
     */
    public static void launch(){
        launch(Configuration.DEFAULT_FILE_PATH);
    }

    /**
     * Private overloaded {@link #launch(String...) launch} method that intialized the program based on
     * the coordinated.txt file.
     *
     * @param file The path to the coordinates.txt file
     */
    private static void launch(final String file){
        try {
            final List<Pair<String, String>> coordinates = CoordinateFileParser.parseCoordinates(file);
            final List<Renderable> renders = new ArrayList<>(DisplayShapeFactory.createShapes(coordinates));

            final DisplayMode displayMode = Configuration.displayMode();

            final GraphicsEngine graphicsEngine = new LWJGLGraphicsEngine(renders, displayMode);
            final UserInterface userInterface = new LWJGLUserInterface();

            final Engine engine = new EngineImpl(graphicsEngine, userInterface);

            engine.start();
        } catch (IOException e) {
            throw new ComputerGraphicsApplicationException(e.getLocalizedMessage());
        }

    }

}
