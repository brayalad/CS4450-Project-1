/***************************************************************
 * file: DisplayShapeFactory.java
 * author: Bryan Ayala
 * class: CS 4450 - Computer Graphics
 *
 * assignment: Program 1
 * date last modified: 01/29/2020
 *
 * purpose: Factory class to create displayable shapes
 *
 ****************************************************************/

package com.cpp.cs.cs4450.util;

import static com.cpp.cs.cs4450.config.Configuration.DEFAULT_DISPLAY_SHAPE_COLORS;

import com.cpp.cs.cs4450.models.shapes.Circle;
import com.cpp.cs.cs4450.models.shapes.DisplayShape;
import com.cpp.cs.cs4450.models.shapes.Ellipse;
import com.cpp.cs.cs4450.models.shapes.Line;

import java.awt.Color;
import java.util.AbstractMap.SimpleEntry;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Factory class that creates {@link com.cpp.cs.cs4450.models.shapes.DisplayShape} instances.
 */
public class DisplayShapeFactory {

    /**
     * Delimiter used to split properties
     */
    private static final String PROPERTY_DELIMITER = " ";

    /**
     * Delimiter used to split pairs
     */
    private static final String PAIR_DELIMITER = ",";

    /**
     * Invalid type error message
     */
    private static final String INVALID_SHAPE_TYPE_ERROR_MESSAGE_FORMAT = "[%s] is an invalid shape type.";

    /**
     * Map of String characters to their class.
     */
    private static final Map<String, Class<? extends DisplayShape>> DISPLAYABLE_SHAPES = Collections.unmodifiableMap(
            Stream.of(
                    new SimpleEntry<>("l", Line.class),
                    new SimpleEntry<>("c", Circle.class),
                    new SimpleEntry<>("e", Ellipse.class)
            ).collect(Collectors.toMap(Entry::getKey, Entry::getValue))
    );

    /**
     * Private Default Constructor to not allow instantiation.
     */
    private DisplayShapeFactory(){}

    /**
     * Creates Display Shapes
     *
     * @param properties List of display shape properties
     *
     * @return List of display Shapes
     */
    public static List<DisplayShape> createShapes(final Collection<Entry<String, String>> properties){
        return properties.stream().map(DisplayShapeFactory::createShape).collect(Collectors.toList());
    }

    /**
     * Creates a display shape.
     *
     * @param properties properties of the display shape
     *
     * @return A display shape
     */
    public static DisplayShape createShape(final Entry<String, String> properties){
        return createShape(properties.getKey(), properties.getValue());
    }

    /**
     * Creates a display shape.
     *
     * @param type the type of display shape
     * @param properties the shapes properties
     *
     * @return a display shape
     */
    public static DisplayShape createShape(final String type, final String properties){
        if(!DISPLAYABLE_SHAPES.containsKey(type)){
            throw new IllegalArgumentException(String.format(INVALID_SHAPE_TYPE_ERROR_MESSAGE_FORMAT, type));
        }

        return createShape(DISPLAYABLE_SHAPES.get(type), properties);
    }

    /**
     * Creates a display shape.
     *
     * @param type the type of display shape
     * @param properties the shapes properties
     *
     * @return a display shape
     */
    public static DisplayShape createShape(final Class<? extends DisplayShape> type, final String properties){
        if (type.equals(Line.class)){
            return createLine(properties);
        } else if (type.equals(Circle.class)){
            return createCircle(properties);
        } else if (type.equals(Ellipse.class)){
            return createEllipse(properties);
        } else {
            throw new IllegalArgumentException(String.format(INVALID_SHAPE_TYPE_ERROR_MESSAGE_FORMAT, type.toString()));
        }
    }

    /**
     * Creates a line
     *
     * @param properties properties of the line
     *
     * @return a new line
     */
    public static Line createLine(final String properties){
        final String[] props = properties.split(PROPERTY_DELIMITER);

        final Entry<Double, Double> x = parsePair(props[0]);
        final Entry<Double, Double> y = parsePair(props[1]);

        return createLine(x.getKey(), x.getValue(), y.getKey(), y.getValue());
    }

    /**
     * Creates a line
     *
     * @param x0 start x of the line
     * @param y0 start y of the line
     * @param x1 end x of the line
     * @param y1 end  of the line
     *
     * @return a new line
     */
    public static Line createLine(final double x0, final double y0, final double x1, final double y1){
        return createLine(DEFAULT_DISPLAY_SHAPE_COLORS.get(Line.class), x0, y0, x1, y1);
    }

    /**
     * Creates a line
     *
     * @param color color of the line
     * @param x0 start x of the line
     * @param y0 start y of the line
     * @param x1 end x of the line
     * @param y1 end  of the line
     *
     * @return a new line
     */
    public static Line createLine(final Color color, final double x0, final double y0, final double x1, final double y1){
        return new Line(color, x0, y0, x1, y1);
    }

    /**
     * Creates a circle
     *
     * @param properties properties of the circle
     *
     * @return a new circe
     */
    public static Circle createCircle(final String properties){
        final String[] props = properties.split(PROPERTY_DELIMITER);

        final Entry<Double, Double> center = parsePair(props[0]);
        final double radius = Double.parseDouble(props[1]);

        return createCircle(center.getKey(), center.getValue(), radius);
    }

    /**
     * Creates a circle
     *
     * @param x x value for center
     * @param y y value for center
     * @param radius the radius of circle
     *
     * @return a new circle
     */
    public static Circle createCircle(final double x, final double y, final double radius){
        return createCircle(DEFAULT_DISPLAY_SHAPE_COLORS.get(Circle.class), x, y, radius);
    }

    /**
     * Creates a circle
     *
     * @param color Color of the circle
     * @param x x value for center
     * @param y y value for center
     * @param radius the radius of circle
     *
     * @return a new circle
     */
    public static Circle createCircle(final Color color, final double x, final double y, final double radius){
        return new Circle(color, x, y, radius);
    }

    /**
     * Creates an Ellipse
     *
     * @param properties properties of the ellipse
     *
     * @return a new ellipse
     */
    public static Ellipse createEllipse(final String properties){
        final String[] props = properties.split(PROPERTY_DELIMITER);

        final Entry<Double, Double> x = parsePair(props[0]);
        final Entry<Double, Double> y = parsePair(props[1]);

        return createEllipse(x.getKey(), x.getValue(), y.getKey(), y.getValue());
    }

    /**
     * Creates an ellipse.
     *
     * @param cx x value for center
     * @param cy y value for center
     * @param rx x value for radius
     * @param ry y value for radius
     *
     * @return a new ellipse
     */
    public static Ellipse createEllipse(final double cx, final double cy, final double rx, final double ry){
        return createEllipse(DEFAULT_DISPLAY_SHAPE_COLORS.get(Ellipse.class), cx, cy, rx, ry);
    }

    /**
     * Creates an ellipse.
     *
     * @param color color of the ellipse
     * @param cx x value for center
     * @param cy y value for center
     * @param rx x value for radius
     * @param ry y value for radius
     *
     * @return a new ellipse
     */
    public static Ellipse createEllipse(final Color color, final double cx, final double cy, final double rx, final double ry){
        return new Ellipse(color, cx, cy, rx, ry);
    }

    /**
     * Parses a string into a pair
     *
     * @param s a string
     *
     * @return a new pair
     */
    private static Entry<Double, Double> parsePair(final String s){
        final String[] pair = s.split(PAIR_DELIMITER);
        return new SimpleEntry<>(Double.parseDouble(pair[0]), Double.parseDouble(pair[1]));
    }

}
