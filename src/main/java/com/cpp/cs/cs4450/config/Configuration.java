/***************************************************************
 * file: Configuration.java
 * author: Bryan Ayala
 * class: CS 4450 - Computer Graphics
 *
 * assignment: Program 1
 * date last modified: 01/29/2020
 *
 * purpose: configuration for the progmram
 *
 ****************************************************************/

package com.cpp.cs.cs4450.config;

import com.cpp.cs.cs4450.models.shapes.Circle;
import com.cpp.cs.cs4450.models.shapes.DisplayShape;
import com.cpp.cs.cs4450.models.shapes.Ellipse;
import com.cpp.cs.cs4450.models.shapes.Line;
import com.cpp.cs.cs4450.util.OperatingSystem;
import com.cpp.cs.cs4450.util.OperatingSystem.OperatingSystemUtils;
import org.lwjgl.opengl.DisplayMode;


import java.awt.Color;
import java.nio.file.Paths;
import java.util.Map;

/**
 * This is the configuration class that is used by the {@link com.cpp.cs.cs4450.application.ComputerGraphicsApplication} class
 * to launch the program.
 */
public final class Configuration {

    /**
     * The current working directory of the project
     */
    public static final String CURRENT_WORKING_DIRECTORY_PATH = Paths.get(".").toAbsolutePath().normalize().toString();

    /**
     * OS being used.
     */
    private static final OperatingSystem OPERATING_SYSTEM = OperatingSystemUtils.getOS();

    /**
     * Default file path for coordinates.txt file
     */
    private static final String DEFAULT_COORDINATES_FILE_PATH = "+src+main+java+com+cpp+cs+cs4450+coordinates.txt";

    /**
     * The Default file path to be used.
     */
    public static final String COORDINATES_FILE_PATH = CURRENT_WORKING_DIRECTORY_PATH + DEFAULT_COORDINATES_FILE_PATH.replaceAll("\\+", OPERATING_SYSTEM.getDelimiter());

    /**
     * The display windows default horizontal size;
     */
    public static final int DEFAULT_HORIZONTAL_WINDOW_SIZE = 640;

    /**
     * The display windows default vertical size.
     */
    public static final int DEFAULT_VERTICAL_WINDOW_SIZE = 480;

    /**
     * Map of the default colors for the programs {@link com.cpp.cs.cs4450.models.shapes.DisplayShape} shapes.
     */
    public static final Map<Class<? extends DisplayShape>, Color> DEFAULT_DISPLAY_SHAPE_COLORS = Map.of(
            Line.class, Color.RED,
            Circle.class, Color.BLUE,
            Ellipse.class, Color.GREEN
    );

    /**
     * Method that creates a new default display mode.
     *
     * @return A default display mode.
     */
    public static DisplayMode displayMode(){
        return new DisplayMode(DEFAULT_HORIZONTAL_WINDOW_SIZE, DEFAULT_VERTICAL_WINDOW_SIZE);
    }

}
