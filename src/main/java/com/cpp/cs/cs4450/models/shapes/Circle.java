/***************************************************************
 * file: Circle.java
 * author: Bryan Ayala
 * class: CS 4450 - Computer Graphics
 *
 * assignment: Program 1
 * date last modified: 02/09/2020
 *
 * purpose: Model class for a Circle
 *
 ****************************************************************/

package com.cpp.cs.cs4450.models.shapes;


import com.cpp.cs.cs4450.graphics.Renderable;
import org.lwjgl.opengl.GL11;


import java.awt.Color;
import java.util.Objects;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleImmutableEntry;

/**
 * This class is a model for a circle. It extends the {@link com.cpp.cs.cs4450.models.shapes.RoundDisplayShape} abstract class
 * and implements the {@link com.cpp.cs.cs4450.graphics.Renderable} interface.
 */
public class Circle extends RoundDisplayShape implements Renderable {

    /**
     * The number of segments to divide by when rendering.
     */
    private static final int AMOUNT_OF_POINTS = 360;

    /**
     * The multiplier used when rendering the circle.
     */
    private static final double DOUBLE_PI = (2.0 * Math.PI);

    /**
     * The radius of the circle
     */
    private double radius;

    /**
     * Constructor
     *
     * @param color The color of the circle
     * @param center The center coordinates of the circle
     * @param radius The radius of the circle
     */
    public Circle(final Color color, final Entry<Double, Double> center, final double radius){
        super(color, center);
        this.radius = radius;
    }

    /**
     * Constructor
     *
     * @param color The color of the circle
     * @param x The x coordinate of the center of the circle
     * @param y The y coordinate of the center of the circle
     * @param radius The radius of the circle
     */
    public Circle(final Color color, final double x, final double y, final double radius) {
        this(color, new SimpleImmutableEntry<>(x, y), radius);
    }

    /**
     * Gets the radius of the circle.
     *
     * @return {@link #radius}
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Sets the radius of the circle
     *
     * @param radius value of the radius
     */
    public void setRadius(final double radius) {
        this.radius = radius;
    }

    /**
     * Renders the circle onto the display.
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
        GL11.glBegin(GL11.GL_LINE_LOOP);
        GL11.glColor3f(color.getRed(), color.getGreen(), color.getBlue());
        drawCircle();
        GL11.glEnd();
    }

    /**
     * Draws the circle onto the screen
     */
    private void drawCircle(){
        final double steps = DOUBLE_PI / AMOUNT_OF_POINTS;
        for(double theta = 0.0; theta <= DOUBLE_PI; theta += steps){
            final double x = center.getKey() + (radius * Math.cos(theta));
            final double y = center.getValue() + (radius * Math.sin(theta));
            GL11.glVertex2d(x,y);
        }
    }

    /**
     * Overloaded {@link Object#toString()} method.
     *
     * @return Returns a string representation of the circle
     */
    @Override
    public String toString(){
        return getClass().getName() + ":\n" +
                "\tCenter: [" + center.getKey() + "," + center.getValue() + "]\n" +
                "\tRadius: " + radius + "\n";
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

        final Circle other = (Circle) obj;

        return Objects.equals(center, other.center)
                && Objects.equals(radius, other.radius)
                && Objects.equals(color, other.color);
    }

}
