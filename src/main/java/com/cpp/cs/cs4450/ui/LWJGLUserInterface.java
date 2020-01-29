/***************************************************************
 * file: LWJGLUserInterface.java
 * author: Bryan Ayala
 * class: CS 4450 - Computer Graphics
 *
 * assignment: Program 1
 * date last modified: 01/29/2020
 *
 * purpose: UserInterface implementation that uses LWGL
 *
 ****************************************************************/

package com.cpp.cs.cs4450.ui;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;

/**
 * This is an impementation of the {@link UserInterface} interface that uses the
 * Lightweight Java Game Library. See <a href="http://legacy.lwjgl.org/index.php.html">http://legacy.lwjgl.org/index.php.html</a> for more info
 *
 * @see <a href="http://legacy.lwjgl.org/index.php.html">LWJGL</a>
 */
public class LWJGLUserInterface implements UserInterface {

    /**
     * The key for the signal to end the program
     */
    private static final int END_PROGRAM_SIGNAL_KEY = Keyboard.KEY_ESCAPE;

    /**
     * Default Constructor. It creates the {@link org.lwjgl.input.Keyboard}.
     */
    public LWJGLUserInterface(){
        try {
            Keyboard.create();
        } catch (LWJGLException e) {
            throw new UserInterfaceException(e.getLocalizedMessage());
        }
    }

    /**
     * Checks if the program has been signaled to end.
     *
     * @return true if the program was signal to end. False, otherwise.
     */
    @Override
    public boolean endProgramSignal() {
        return Keyboard.isKeyDown(END_PROGRAM_SIGNAL_KEY);
    }

    /**
     * Gets input from the user.
     *
     * @return user input
     */
    @Override
    public String getInput() {
        return String.valueOf(Keyboard.getEventCharacter());
    }

}
