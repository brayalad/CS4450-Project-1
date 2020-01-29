/***************************************************************
 * file: UserInterface.java
 * author: Bryan Ayala
 * class: CS 4450 - Computer Graphics
 *
 * assignment: Program 1
 * date last modified: 01/29/2020
 *
 * purpose: Interface for user to use the program
 *
 ****************************************************************/

package com.cpp.cs.cs4450.ui;

/**
 * Interface for the user to interact with the program,
 */
public interface UserInterface {

    /**
     * Checks if the program has been signaled to end.
     *
     * @return true if the program was signal to end. False, otherwise.
     */
    boolean endProgramSignal();

    /**
     * Gets input from the user.
     *
     * @return user input
     */
    String getInput();

}
