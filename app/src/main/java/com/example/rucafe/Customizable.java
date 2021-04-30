/**
 *The Customizable interface that abstracts add and remove methods for child classes
 * @author Sailokesh Mondi, Tanay Somisetty
 */


package com.example.rucafe;

public interface Customizable {

    /**
     *This method defines attributes related to adding in other classes
     * @param obj Object
     * @return true if an object is added, false otherwise
     */
    boolean add(Object obj);

    /**
     *This method defines attributes related to removing in other classes
     * @param obj Object
     * @return true if an object is removed, false otherwise
     */
    boolean remove(Object obj);
}

