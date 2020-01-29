/***************************************************************
 * file: Circle.java
 * author: Bryan Ayala
 * class: CS 4450 - Computer Graphics
 *
 * assignment: Program 1
 * date last modified: 01/29/2020
 *
 * purpose: Model class for a Circle
 *
 ****************************************************************/

package com.cpp.cs.cs4450.models.shapes;


import com.cpp.cs.cs4450.graphics.Renderable;
import javafx.util.Pair;
import org.lwjgl.opengl.GL11;


import java.awt.Color;
import java.util.Objects;
import java.util.function.DoubleFunction;

/**
 * This class is a model for a circle. It extends the {@link com.cpp.cs.cs4450.models.shapes.RoundDisplayShape} abstract class
 * and implements the {@link com.cpp.cs.cs4450.graphics.Renderable} interface.
 */
public class Circle extends RoundDisplayShape implements Renderable {

    /**
     * The number of segments to divide by when rendering.
     */
    private static final int AMOUNT_OF_SEGMENTS = 200;

    /**
     * The multiplier used when rendering the circle.
     */
    private static final double RENDER_MULTIPLIER = (2.0 * Math.PI);


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
    public Circle(final Color color, final Pair<Double, Double> center, final double radius){
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
        this(color, new Pair<>(x, y), radius);
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
        GL11.glBegin(GL11.GL_LINE_LOOP);
        GL11.glColor3f(color.getRed(), color.getGreen(), color.getBlue());
        for(int i = 0; i <= AMOUNT_OF_SEGMENTS; ++i){
            GL11.glVertex2d(calculateRenderX(i), calculateRenderY(i));
        }
        GL11.glEnd();
    }

    /**
     * Overloaded {@link Object#toString()} method.
     *
     * @return Returns a string representation of the circle
     */
    @Override
    public String toString(){
        return "Circle:\n" +
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

        return Objects.equals(center, other.center) && Objects.equals(radius, other.radius) && Objects.equals(color, other.color);
    }

    /**
     * Calculates the x point to render.
     *
     * @param i current iteration
     *
     * @return the calculated render x point
     */
    private double calculateRenderX(final int i){
        return calculateRenderPoint(center.getKey(), i, Math::cos);
    }

    /**
     * Calculates the y point to render.
     *
     * @param i current iteration
     *
     * @return the calculated render y point
     */
    private double calculateRenderY(final int i){
        return calculateRenderPoint(center.getValue(), i, Math::sin);
    }

    /**
     * Calculates the render point
     *
     * @param data data to used when calculating
     * @param i current iteration
     * @param fn function to apply in calculation
     *
     * @return render point
     */
    private double calculateRenderPoint(final double data, final int i, final DoubleFunction<Double> fn){
        return (data + (radius * (fn.apply(i * RENDER_MULTIPLIER / AMOUNT_OF_SEGMENTS))));
    }

}
