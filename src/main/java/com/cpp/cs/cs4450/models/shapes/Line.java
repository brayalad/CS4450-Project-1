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
import com.cpp.cs.cs4450.models.grid.Pixel;
import org.lwjgl.opengl.GL11;

import java.awt.Color;
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
    private Pixel<Double> start;

    /**
     * End coordinates
     */
    private Pixel<Double> end;

    /**
     * Constructor
     *
     * @param color The color of the line
     * @param start The start coordinates of the line
     * @param end The end coordinates of the line
     */
    public Line(final Color color, final Pixel<Double> start, final Pixel<Double> end){
        super(color);
        this.start = start;
        this.end = end;
    }

    /**
     * Constructor
     *
     * @param color The color of the line
     * @param start The start coordinates of the line
     * @param end The end coordinates of the line
     */
    public Line(final Color color, final Entry<Double, Double> start, final Entry<Double, Double> end){
        this(color, Pixel.of(start), Pixel.of(end));
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
        this(color, Pixel.of(x0, y0), Pixel.of(x1, y1));
    }

    /**
     * Gets the start coordinate
     *
     * @return {@link #start}
     */
    public Pixel<Double> getStart() {
        return start;
    }

    /**
     * Sets the start coordinate
     *
     * @param start The start coordinate
     */
    public void setStart(final Pixel<Double> start) {
        this.start = start;
    }

    /**
     * Gets the end coordinate
     *
     * @return {@link #end}
     */
    public Pixel<Double> getEnd() {
        return end;
    }

    /**
     * Sets the end coordinate
     *
     * @param end The end coordinate
     */
    public void setEnd(final Pixel<Double> end) {
        this.end = end;
    }

    /**
     * Renders the line
     */
    @Override
    public void render() {
        GL11.glBegin(GL11.GL_POINTS);
        GL11.glColor3f(color.getRed(), color.getGreen(), color.getBlue());
        plotLine(start, end);
        GL11.glEnd();
    }

    private void plotLineGL11(){
        GL11.glBegin(GL11.GL_LINES);
        GL11.glColor3f(color.getRed(), color.getGreen(), color.getBlue());
        GL11.glVertex2d(start.getKey(), start.getValue());
        GL11.glVertex2d(end.getKey(), end.getValue());
        GL11.glEnd();
    }



    private void plotLineMidPointAlgorithm(){
        double dx = end.getX() - start.getX();
        double dy = end.getY() - start.getY();

        double d = (2.0 * dy) - dx;

        double incrementRight = 2.0 * dy;
        double incrementUpRight = 2.0 * (dy - dx);

        GL11.glBegin(GL11.GL_POINTS);
        GL11.glColor3f(color.getRed(), color.getGreen(), color.getBlue());

        final double endPointX = end.getX();
        for(double x = start.getX(), y = start.getY(); x <= endPointX; ++x){
            GL11.glVertex2d(x,y);
            if(d >= 0.0){
                ++y;
                d += incrementUpRight;
            } else {
                d += incrementRight;
            }
        }
        GL11.glEnd();
    }

    private void plotLine(final Pixel<Double> start, final Pixel<Double> end){
        plotLine(start.getKey(), start.getValue(), end.getKey(), end.getValue());
    }

    private void plotLine(final double x0, final double y0, final double x1, final double y1){
        if(Math.abs(x1 - x0) > Math.abs(y1 - y0)){
            if(x0 > x1){
                plotLineByX(x1, y1, x0, y0);
            } else {
                plotLineByX(x0, y0, x1, y1);
            }
        } else {
            if(y0 > y1){
                plotLineByY(x1, y1, x0, y0);
            } else {
                plotLineByY(x0, y0, x1, y1);
            }
        }
    }

    private void plotLineByX(final double x0, final double y0, final double x1, final double y1){
        final double dx = (x1 - x0);
        final double dy = Math.abs(y1 - y0);
        final double yi = ((y1 - y0) < 0) ? -1.0 : 1.0;

        double d = 2.0 * dy - dx;
        for(double x = x0, y = y0; x <= x1; ++x){
            GL11.glVertex2d(x, y);
            if(d > 0.0){
                y += yi;
                d -= (2.0 * dx);
            }
            d += (2.0 * dy);
        }
    }


    private void plotLineByY(final double x0, final double y0, final double x1, final double y1){
        final double dy = (y1 - y0);
        final double dx = Math.abs(x1 - x0);
        final double xi = ((x1 - x0) < 0) ? -1.0 : 1.0;

        double d = 2.0 * dx - dy;
        for(double y = y0, x = x0; y <= y1; ++y){
            GL11.glVertex2d(x, y);
            if(d > 0.0){
                x += xi;
                d -= (2.0 * dy);
            }
            d += (2.0 * dx);
        }
    }

    /**
     * Overloaded {@link Object#toString()} method.
     *
     * @return Returns a string representation of the line
     */
    @Override
    public String toString(){
        return "Line:\n" +
                "\tStart: [" + start.getKey() + "," + start.getValue() + "]\n" +
                "\tEnd: [" + end.getKey() + "," + end.getValue() + "]\n";


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
