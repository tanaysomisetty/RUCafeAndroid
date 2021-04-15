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

