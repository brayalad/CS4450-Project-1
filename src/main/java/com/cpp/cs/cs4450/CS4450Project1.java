/***************************************************************
 * file: CS4459Project1.java
 * author: Bryan Ayala
 * class: CS 4450 - Computer Graphics
 *
 * assignment: Program 1
 * date last modified: 01/29/2020
 *
 * purpose: Program will display either a line, circle, or ellipse based
 * on coordinates read from a txt file.
 *
 ****************************************************************/

package com.cpp.cs.cs4450;


import com.cpp.cs.cs4450.application.ComputerGraphicsApplication;
import com.cpp.cs.cs4450.config.Configuration;

/**
 * CS 4450 Project 1
 *
 * Write a Java program which uses the LWJGL library to draw a window of 640x480 in the center of the screen.
 * Your program should then read in coordinates from a file titled coordinates.txt and draw the primitives in the
 * same window using the algorithms for each primitive as discussed in class. The program should draw the
 * primitives in different colors (red for lines, blue for circles and green for ellipses) on a black background.Use
 * the glVertex2f() command to plot the primitives pixel by pixel. Finally, your program should also use the
 * input.Keyboard class to have the escape key quit your application.
 */
public final class CS4450Project1 extends ComputerGraphicsApplication {

    /**
     * The main method. This is where the program begins to run
     *
     * @param args command line arguments
     */
    public static void main(final String ...args) { launch(args); }

}
