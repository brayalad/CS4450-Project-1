/***************************************************************
 * file: Line.java
 * author: Bryan Ayala
 * class: CS 4450 - Computer Graphics
 *
 * assignment: Program 1
 * date last modified: 01/29/2020
 *
 * purpose: Model class for a Line
 *
 ****************************************************************/

package com.cpp.cs.cs4450.models.shapes;

import com.cpp.cs.cs4450.graphics.Renderable;
import org.lwjgl.opengl.GL11;

import java.awt.Color;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;
import java.util.Objects;

/**
 * This class is a model for a ellipse. It extends the {@link com.cpp.cs.cs4450.models.shapes.DisplayShape} abstract class
 * and implements the {@link com.cpp.cs.cs4450.graphics.Renderable} interface.
 */
public class Line extends DisplayShape implements Renderable {

    /**
     * Start coordinates
     */
    private Entry<Double, Double> start;

    /**
     * End coordinates
     */
    private Entry<Double, Double> end;


    /**
     * Constructor
     *
     * @param color The color of the line
     * @param start The start coordinates of the line
     * @param end The end coordinates of the line
     */
    public Line(final Color color, final Entry<Double, Double> start, final Entry<Double, Double> end){
        super(color);
        this.start = start;
        this.end = end;
    }

    /**
     * Constructor
     *
     * @param color The color of the line
     * @param x0 The x coordinate for the start of the line
     * @param y0 The y coordinate for the start of the line
     * @param x1 The x coordinate for the end of the line
     * @param y1 The y coordinate for the end of the line
     */
    public Line(final Color color, final double x0, final double y0, final double x1, final double y1){
        this(color, new SimpleEntry<>(x0, x1), new SimpleEntry<>(y0, y1));
    }

    /**
     * Gets the start coordinate
     *
     * @return {@link #start}
     */
    public Entry<Double, Double> getStart() {
        return start;
    }

    /**
     * Sets the start coordinate
     *
     * @param start The start coordinate
     */
    public void setStart(final Entry<Double, Double> start) {
        this.start = start;
    }

    /**
     * Gets the end coordinate
     *
     * @return {@link #end}
     */
    public Entry<Double, Double> getEnd() {
        return end;
    }

    /**
     * Sets the end coordinate
     *
     * @param end The end coordinate
     */
    public void setEnd(final Entry<Double, Double> end) {
        this.end = end;
    }

    /**
     * Renders the line
     */
    @Override
    public void render() {
        GL11.glBegin(GL11.GL_LINES);
        GL11.glColor3f(color.getRed(), color.getGreen(), color.getBlue());
        GL11.glVertex2d(start.getKey(), end.getKey());
        GL11.glVertex2d(start.getValue(), end.getValue());
        GL11.glEnd();
    }

    /**
     * Overloaded {@link Object#toString()} method.
     *
     * @return Returns a string representation of the line
     */
    @Override
    public String toString(){
        return "Line:\n" +
                "\tStart: [" + start.getKey() + "," + end.getKey() + "]\n" +
                "\tEnd: [" + start.getValue() + "," + end.getValue() + "]\n";


    }

    /**
     * Overloaded {@link Object#equals(Object)} method.
     *
     * @param obj the reference object with which to compare.
     *
     * @return true if this object is the same as the obj argument; false otherwise.
     */
    @Override
    public boolean equals(final Object obj){
        if(obj == null) { return false; }
        if(obj == this) { return true; }
        if(getClass() != obj.getClass()){
            return false;
        }

        final Line other = (Line) obj;

        return Objects.equals(start, other.start) && Objects.equals(end, other.end) && Objects.equals(color, other.color);
    }

}
