/***************************************************************
 * file: Pixel.java
 * author: Bryan Ayala
 * class: CS 4450 - Computer Graphics
 *
 * assignment: Program 1
 * date last modified: 02/09/2020
 *
 * purpose: Wrapper class for pixel position
 *
 ****************************************************************/

package com.cpp.cs.cs4450.models.grid;

import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Map.Entry;

public final class Pixel<T extends Number> extends SimpleImmutableEntry<T, T> implements Entry<T, T> {


    /**
     * Creates an entry representing a mapping from the specified
     * key to the specified value.
     *
     * @param key   the key represented by this entry
     * @param value the value represented by this entry
     */
    public Pixel(final T key, final T value) {
        super(key, value);
    }

    /**
     * Creates an entry representing the same mapping as the
     * specified entry.
     *
     * @param entry the entry to copy
     */
    public Pixel(final Entry<? extends T, ? extends T> entry) {
        super(entry);
    }

    /**
     * Gets pixel x coordinate
     *
     * @return pixel's x coordinate
     */
    public T getX(){ return getKey(); }

    /**
     * Gets pixel y coordinate
     *
     * @return pixel's y coordinate
     */
    public T getY(){ return getValue(); }

    public static <T extends Number> Pixel<T> of(final T key, final T value){
        return new Pixel<>(key, value);
    }

    public static <T extends Number> Pixel<T> of(final Entry<? extends T, ? extends T> entry){
        return new Pixel<>(entry);
    }

}
