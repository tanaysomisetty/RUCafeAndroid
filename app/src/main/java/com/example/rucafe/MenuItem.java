package com.example.rucafe;


/**
 *This class defines all the attributes of the menu item such as the ID, the item details, and the price
 * @author Sailokesh Mondi, Tanay Somisetty
 */
public class MenuItem {
    private double price;
    private int menuItemID;
    private String itemDetails;
    private static int nextMenuItemID = 1;
    private boolean removed;

    /**
     * Default constructor that gets the menuItem ID and increments it
     */
    public MenuItem() {
        this.menuItemID = nextMenuItemID;
        nextMenuItemID++;
        this.price = 0;
    }

    /**
     * Constructor that gets the menuID
     *
     * @param menuItemID that corresponds to the menu item
     */
    public MenuItem(int menuItemID) {
        this.menuItemID = menuItemID;
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
     * Accessory method that gets the details of an item
     *
     * @return a string that corresponds to the details of the item
     */
    public String getItemDetails() {
        return this.itemDetails;
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

    /**
     * Method to check to see if a menu item has been removed or not
     *
     * @return removed instance variable
     */
    public boolean isRemoved() {
        return removed;
    }

    /**
     * Accessor method to set the removed variable that can be used in the current order controller
     *
     * @param removed instance variable
     */
    public void setRemoved(boolean removed) {
        this.removed = removed;
    }
}