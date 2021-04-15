package com.example.rucafe;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * This class implements Customizable and specific data and operations pertaining to an order
 *
 * @author Sailokesh Mondi, Tanay Somisetty
 */
public class Order implements Customizable {
    final static double SALES_TAX = .06625;
    private static int nextOrderID = 1;
    private final List<MenuItem> menuItemList = new ArrayList<>();
    private int numItems = 0;
    private final int orderID;
    private double subtotal = 0;
    private double total = 0.0;
    private final String details = "Click To View";
    private boolean removed;

    /**
     * Default constructor that increments the order ID
     */
    public Order() {
        this.orderID = nextOrderID;
        nextOrderID++;
    }

    /**
     * Clone constructor that creates a new order ID
     *
     * @param orderID of value int
     */
    public Order(int orderID) {
        this.orderID = orderID;
    }

    /**
     * Method to check if two order items are equal based on their order IDS
     *
     * @param obj Object
     * @return true if the two order items are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Order) {
            Order order = (Order) obj;
            return this.orderID == order.orderID;
        } else {
            return false;
        }
    }

    /**
     * Method to add instances of order in the currentOrder controller
     *
     * @param obj Object
     * @return true if the order is added, false otherwise
     */
    public boolean add(Object obj) {
        if (obj instanceof MenuItem) {
            MenuItem item = (MenuItem) obj;
            item.setItemDetails();
            menuItemList.add(item);
            this.numItems++;
            subtotal = subtotal + item.getPrice();
            total = calculateTotalAmt();
            return true;
        }
        return false;
    }

    /**
     * Method to remove instances of order in the currentOrder controller
     *
     * @param obj Object
     * @return true if the order is removed, false otherwise
     */
    public boolean remove(Object obj) {
        if (obj instanceof MenuItem) {
            MenuItem item = (MenuItem) obj;
            for (int i = 0; i <= numItems; i++) {
                MenuItem currItem = menuItemList.get(i);
                if (item.equals(currItem)) {
                    menuItemList.remove(i);
                    this.numItems--;
                    reCalculateSubTotal();
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    /**
     * Method to calculate the total price of all items in the order, including the sales tax
     *
     * @return double value that corresponds to the total price of an instance of order
     */
    public double calculateTotalAmt() {
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.UP);
        return Double.parseDouble(df.format(this.subtotal + (this.subtotal * SALES_TAX)));
    }


    /**
     * Accessory method to get the subtotal
     *
     * @return a double value that corresponds to the subtotal
     */
    public double getSubtotal() {
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.UP);
        return Double.parseDouble(df.format(this.subtotal));
    }

    /**
     * Accessory method to get the list of menu items
     *
     * @return a List object
     */
    public List getMenuItemList() {
        return this.menuItemList;
    }

    /**
     * Method to recalculate the subtotal every time an item is removed/added from the order
     */
    private void reCalculateSubTotal() {
        subtotal = 0.0;
        for (MenuItem item : menuItemList) {
            subtotal = subtotal + item.getPrice();
        }

        total = calculateTotalAmt();
    }

    /**
     * Method to remove all the items from the current order list and reset the subtotal
     * This method is called in the currentOrderController when the order is placed
     */
    public void removeAllItems() {
        menuItemList.clear();
        reCalculateSubTotal();
    }

    /**
     * Method to get the string representation of the details of every order in the store order GUI
     *
     * @return a String that shows the details of ef every order
     */
    @Override
    public String toString() {
        String output = "";
        for (Object obj : menuItemList) {
            if (obj instanceof Donut) {
                Donut currDonut = (Donut) obj;
                output = output + currDonut.toString() + "\n";
            } else if (obj instanceof Coffee) {
                Coffee currCoffee = (Coffee) obj;
                output = output + currCoffee.toString() + "\n";
            }
        }
        return output + "Total Amount: $" + this.calculateTotalAmt() + "\n";
    }

    /**
     * Accessor method to get the order ID for an order to be used in the store orders controller
     *
     * @return int value that represents the order ID
     */
    public int getOrderID() {
        return orderID;
    }

    /**
     * Accessor method to get the total for all orders to be used in the store orders controller
     *
     * @return double value that represents the total amount of all orders
     */
    public double getTotal() {
        return total;
    }

    /**
     * Accessor method to get the details of all orders to be used in the store orders controller
     *
     * @return String that represent the details of all the orders
     */
    public String getDetails() {
        return details;
    }

    /**
     * Method to see whether the removed variable is removed or not removed
     *
     * @return the removed instance variable
     */
    public boolean isRemoved() {
        return removed;
    }

    /**
     * Accessor method to set the removed variable that can be used in the store orders controller
     *
     * @param removed instance variable
     */
    public void setRemoved(boolean removed) {
        this.removed = removed;
    }
}