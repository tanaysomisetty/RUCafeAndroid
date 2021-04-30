/**
 *This class defines all the attributes of the menu item such as the ID, the item details, and the price
 * @author Sailokesh Mondi, Tanay Somisetty
 */

package com.example.rucafe;

public class MenuItem {
    private double price;
    private int menuItemID;
    private String itemDetails;
    private static int nextMenuItemID = 1;

    /**
     * Default constructor that gets the menuItem ID and increments it
     */
    public MenuItem() {
        this.menuItemID = nextMenuItemID;
        nextMenuItemID++;
        this.price = 0;
    }

    /**
     * Method to check if two menu items are equal based on their menu item IDs
     *
     * @param obj Object
     * @return true if the two menu items are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MenuItem) {
            MenuItem item = (MenuItem) obj;
            if (this.menuItemID == item.menuItemID) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

    /**
     * Accessory method to get the price
     *
     * @return double value price
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * Accessory method to set the price
     *
     * @param price of a double value
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * Accessory method to get the menu item ID
     *
     * @return integer value that corresponds to the menu ID
     */
    public int getMenuItemID() {
        return this.menuItemID;
    }

    /**
     * Accessory method that sets the details of a menu item to be used in the current controller GUI
     */
    public void setItemDetails() {

    }

    /**
     * Method to set the item details to be used in the current controller GUI
     *
     * @param itemDetails of type String
     */
    public void setDetails(String itemDetails) {
        this.itemDetails = itemDetails;
    }

    /**
     * Accessory method that gets the price of the menu item
     *
     * @return a double value that corresponds to the price
     */
    public double itemPrice() {
        return price;
    }
}