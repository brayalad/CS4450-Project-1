/***************************************************************
 * file: GraphicsEngine.java
 * author: Bryan Ayala
 * class: CS 4450 - Computer Graphics
 *
 * assignment: Program 1
 * date last modified: 02/09/2020
 *
 * purpose: GraphicsEngine is responsible for rendering objects
 *
 ****************************************************************/

package com.cpp.cs.cs4450.graphics;

import com.cpp.cs.cs4450.models.shapes.DisplayShape;

import java.awt.Color;
import java.util.Map;

/**
 * GraphicsEngine is responsible for rendering objects that implement the {@link com.cpp.cs.cs4450.graphics.Renderable} interface
 * to the computer display. This interface should be implemented by any class that renders to the display.
 */
public interface GraphicsEngine {

    /**
     * Method that renders all {@link com.cpp.cs.cs4450.graphics.Renderable} objects to the display.
     */
    void render();

    /**
     * Method that checks to see if a request to close the display has been made.
     *
     * @return If a request to close the display has been made.
     */
    boolean displayCloseRequested();


    /**
     * Method to add a new {@link com.cpp.cs.cs4450.graphics.Renderable} object.
     *
     * @param renderable Object to add to rendered objects.
     *
     * @return If object was added successfully.
     */
    boolean addRenderable(Renderable renderable);

    /**
     * Method to remove {@link com.cpp.cs.cs4450.graphics.Renderable} object.
     *
     * @param renderable Object to remove from rendered objects.
     *
     * @return If object was removed successfully.
     */
    boolean removeRenderable(Renderable renderable);

    /**
     * Method that returns the number of objects to render.
     *
     * @return Amount of objects to render.
     */
    int renderAmount();

    /**
     * Method that shuts down the graphics engine.
     */
    void shutdown();

    /**
     * Method that changes graphics colors
     *
     * @param colors colors to change to
     */
    void changeColors(Map<Class<? extends DisplayShape>, Color> colors);

}
