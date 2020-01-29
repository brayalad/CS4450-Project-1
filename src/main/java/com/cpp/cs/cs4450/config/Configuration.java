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
import org.lwjgl.opengl.DisplayMode;


import java.awt.Color;
import java.util.Map;

/**
 * This is the configuration class that is used by the {@link com.cpp.cs.cs4450.application.ComputerGraphicsApplication} class
 * to launch the program.
 */
public final class Configuration {

    /**
     * The default coordinates.txt file path.
     */
    public static final String DEFAULT_FILE_PATH = "/Users/bryanayala/Workplace/ComputerGraphicProject1/src/main/java/com/cpp/cs/cs4450/coordinates.txt";

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
