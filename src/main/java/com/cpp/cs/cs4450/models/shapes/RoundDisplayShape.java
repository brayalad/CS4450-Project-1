/***************************************************************
 * file: RoundDisplayShape.java
 * author: Bryan Ayala
 * class: CS 4450 - Computer Graphics
 *
 * assignment: Program 1
 * date last modified: 02/09/2020
 *
 * purpose: Model class for a Round displayable shape
 *
 ****************************************************************/

package com.cpp.cs.cs4450.models.shapes;

import com.cpp.cs.cs4450.graphics.Renderable;
import com.cpp.cs.cs4450.models.grid.Pixel;

import java.awt.Color;
import java.util.Map.Entry;

/**
 * This class is an abstraction of a round display shape. It extends the {@link DisplayShape} class.
 */
public abstract class RoundDisplayShape extends DisplayShape implements Renderable {

    /**
     * The coordinates for the shapes center.
     */
    protected Pixel<Double> center;

    /**
     * Abstract Constructor
     *
     * @param color The shapes color
     * @param center The shapes center coordinates
     */
    public RoundDisplayShape(final Color color, final Pixel<Double> center) {
        super(color);
        this.center = center;
    }

    /**
     * Abstract Constructor
     *
     * @param color The shapes color
     * @param center The shapes center coordinates
     */
    public RoundDisplayShape(final Color color, final Entry<Double, Double> center) {
        this(color, Pixel.of(center));
    }

    /**
     * Gets the shapes center coordinates.
     *
     * @return {@link #center}
     */
    public Pixel<Double> getCenter() {
        return center;
    }

    /**
     * Sets the shapes center coordinates
     *
     * @param center The center coordinates
     */
    public void setCenter(final Pixel<Double> center) {
        this.center = center;
    }

}
