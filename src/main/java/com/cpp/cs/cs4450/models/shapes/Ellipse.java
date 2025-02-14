/***************************************************************
 * file: Ellipse.java
 * author: Bryan Ayala
 * class: CS 4450 - Computer Graphics
 *
 * assignment: Program 1
 * date last modified: 02/09/2020
 *
 * purpose: Model class for a Ellipse
 *
 ****************************************************************/

package com.cpp.cs.cs4450.models.shapes;

import com.cpp.cs.cs4450.graphics.Renderable;
import org.lwjgl.opengl.GL11;

import java.awt.Color;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Map.Entry;
import java.util.Objects;

/**
 * This class is a model for a ellipse. It extends the {@link com.cpp.cs.cs4450.models.shapes.RoundDisplayShape} abstract class
 * and implements the {@link com.cpp.cs.cs4450.graphics.Renderable} interface.
 */
public class Ellipse extends RoundDisplayShape implements Renderable {

    /**
     * Number of segments to divide by when rendering.
     */
    private static final int AMOUNT_OF_POINTS = 720;

    /**
     * Double PI constant
     */
    private static final double DOUBLE_PI = 2.0 * Math.PI;

    /**
     * The radius of the ellipse
     */
    private Entry<Double, Double> radius;

    /**
     * Constructor
     *
     * @param color The color of the ellipse
     * @param cx The x coordinate for the center
     * @param cy The y coordinate for the center
     * @param rx The x amount for the radius
     * @param ry The y amount for the radius
     */
    public Ellipse(final Color color, final double cx, final double cy, final double rx, final double ry) {
        this(color, new SimpleImmutableEntry<>(cx, cy), new SimpleImmutableEntry<>(rx, ry));
    }

    /**
     * Constructor
     *
     * @param color The color of the ellipse
     * @param center The center coordinates of the ellipse
     * @param radius The radius of the ellipse
     */
    public Ellipse(final Color color, final Entry<Double, Double> center, final Entry<Double, Double> radius){
        super(color, center);
        this.radius = radius;
    }

    /**
     * Gets the radius of the circle.
     *
     * @return {@link #radius}
     */
    public Entry<Double, Double> getRadius() {
        return radius;
    }

    /**
     * Sets the radius of the circle
     *
     * @param radius value of the radius
     */
    public void setRadius(final Entry<Double, Double> radius) {
        this.radius = radius;
    }

    /**
     * Renders the ellipse onto the display.
     */
    @Override
    public void render() {
        draw();
    }

    /**
     * Draws the shape onto the screen
     */
    @Override
    public void draw(){
        GL11.glBegin(GL11.GL_POINTS);
        GL11.glColor3f(color.getRed(), color.getGreen(), color.getBlue());
        drawEllipse();
        GL11.glEnd();
    }

    /**
     * Draws the ellipse onto the screen
     */
    private void drawEllipse(){
        final double steps = DOUBLE_PI / AMOUNT_OF_POINTS;
        for(double theta = 0.0; theta <= DOUBLE_PI; theta += steps){
            final double x = center.getKey() + (radius.getKey() * Math.cos(theta));
            final double y = center.getValue() + (radius.getValue() * Math.sin(theta));
            GL11.glVertex2d(x, y);
        }
    }

    /**
     * Overloaded {@link Object#toString()} method.
     *
     * @return Returns a string representation of the ellipse
     */
    @Override
    public String toString(){
        return getClass().getName() + ":\n" +
                "\tCenter: [" + center.getKey() + "," + center.getValue() + "]\n" +
                "\trx: " + radius.getKey() + "\n" +
                "\try: " + radius.getValue() + "\n";
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

        final Ellipse other = (Ellipse) obj;

        return Objects.equals(center, other.center)
                && Objects.equals(radius, other.radius)
                && Objects.equals(color, other.color);
    }

}
