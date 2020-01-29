/***************************************************************
 * file: EngineImpl.java
 * author: Bryan Ayala
 * class: CS 4450 - Computer Graphics
 *
 * assignment: Program 1
 * date last modified: 01/29/2020
 *
 * purpose: implementation of Engine interface
 *
 ****************************************************************/

package com.cpp.cs.cs4450.application;

import com.cpp.cs.cs4450.graphics.GraphicsEngine;
import com.cpp.cs.cs4450.ui.UserInterface;

/**
 * This is the programs implementation of the {@link com.cpp.cs.cs4450.application.Engine} interface.
 * All the logic for the program is contained in this class.
 */
public final class EngineImpl implements Engine {
    /**
     * The {@link com.cpp.cs.cs4450.graphics.GraphicsEngine} that is being used by
     * the program to render graphics onto the display.
     */
    private final GraphicsEngine graphicsEngine;

    /**
     * The {@link com.cpp.cs.cs4450.ui.UserInterface} that is used to communicate
     * with the user during the program.
     */
    private final UserInterface userInterface;


    /**
     * Constructor
     *
     * @param graphicsEngine The {@link com.cpp.cs.cs4450.graphics.GraphicsEngine} implementation to be used by the engine.
     * @param userInterface The {@link com.cpp.cs.cs4450.ui.UserInterface} implementation to be used by the engine.
     */
    public EngineImpl(final GraphicsEngine graphicsEngine, final UserInterface userInterface) {
        this.graphicsEngine = graphicsEngine;
        this.userInterface = userInterface;
    }

    /**
     * Starts the program the Engine is running.
     */
    @Override
    public void start() {
        run();
    }

    /**
     * This method contains the loop that runs the program. The loop will stop running if the
     * Display is closed or if the user has ended the program.
     */
    @Override
    public void run() {
        while(!graphicsEngine.displayCloseRequested() && !userInterface.endProgramSignal()){
            graphicsEngine.render();
        }
        graphicsEngine.shutdown();
        System.exit(0);
    }

}
