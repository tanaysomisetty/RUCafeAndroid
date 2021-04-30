/**
 *This class defines attributes for the add in coffee items such as the type of add in
 * @author Sailokesh Mondi, Tanay Somisetty
 */

package com.example.rucafe;

public class AddIn {
    private String type;

        /**
         *Constructor that gets the type of add-in
         * @param type String which corresponds to the type of add-in
         */
        public AddIn(String type) {
            this.type = type;
        }

        /**
         *Getter method to get the type of add in
         * @return the type of add in
         */
        public String getType() {
            return type;
        }

        /**
         * Method that compares an object to see whether it is an instance of add-in
         * @param obj Object
         * @return true if the object is equal, false otherwise
         */
        @Override
        public boolean equals(Object obj) {
            if (obj instanceof AddIn) {
                AddIn addIn = (AddIn) obj;
                if (addIn.getType().equals(this.type)) {
                    return true;
                }
                else {
                    return false;
                }
            }
            else {
                return false;
            }
        }

        /**
         * Method that is overwritten that gets the String representation of
         * @return
         */
        @Override
        public String toString() {
            return this.type;
        }

    }

