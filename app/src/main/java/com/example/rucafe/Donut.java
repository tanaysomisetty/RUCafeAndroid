package com.example.rucafe;
/**
 *This class extends the MenuItem class and includes specific data and operations for a donut object,
 * such as the donut type, flavor and the quantity
 * @author Sailokesh Mondi, Tanay Somisetty
 */

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Donut extends MenuItem implements Customizable{
    private String type;
    private String flavor;
    private int quantity;
    private final static double YEAST_PRICE = 1.39;
    private final static double CAKE_PRICE = 1.59;
    private final static double HOLE_PRICE = 0.33;
    private static String[] donutFlavors = new String[]{"Glazed", "Chocolate", "Strawberry"};

    /**
     * Default constructor that initializes the donut object to default
     * attributes of type, flavor, and quantity
     */
    public Donut() {
        this.type = "";
        this.flavor = "";
        this.quantity = 0;
    }

    /**
     *Accessory method to set the type of the the donut
     * @param type of the donut object of type String
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Accessory method to set the flavor of the donut
     * @param flavor of the donut object of type String
     */
    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    /**
     *Method to add quantity of donut instances in the donut controller GUI
     * @param obj Object
     * @return true if the donut is added, false otherwise
     */
    public boolean add(Object obj) {
        if (obj instanceof Donut) {
            this.quantity++;
            return true;
        }
        else {
            return false;
        }
    }

    /**
     *Method to remove quantity of donut instances in the donut controller GUI
     * @param obj Object
     * @return true if the donut is able to be removed, false otherwise
     */
    public boolean remove(Object obj) {
        if(obj instanceof Donut) {
            this.quantity--;
            return true;
        }
        else {
            return false;
        }

    }

    /**
     * Calculates the total price of a donut depending on Donut Type
     * @return double value pertaining to the price of the donut
     */
    @Override
    public double itemPrice() {
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.UP);

        if (this.type.equals("yeast")) {
            super.setPrice(YEAST_PRICE * this.quantity);
            return Double.parseDouble(df.format(super.getPrice()));
        }
        else if (this.type.equals("cake")) {
            super.setPrice(CAKE_PRICE * this.quantity);
            return Double.parseDouble(df.format(super.getPrice()));
        }
        else if(this.type.equals("hole")) {
            super.setPrice(HOLE_PRICE * this.quantity);
            return Double.parseDouble(df.format(super.getPrice()));
        }
        else {
            return 0.00;
        }
    }

    /**
     * Gives a string representation of a Donut object
     * @return a string in the format "Donut Type,Flavor,Quantity"
     */
    @Override
    public String toString() {
        String donutType = this.type.substring(0, 1).toUpperCase() + this.type.substring(1);
        String donutFlavor = this.flavor.substring(0, 1).toUpperCase() + this.flavor.substring(1);

        return donutType + " Donut," + donutFlavor + ",Quantity: " + this.quantity;
    }

    /**
     * Accessory method to set item details to be used in the current order GUI
     */
    @Override
    public void setItemDetails(){
        super.setDetails(toString());
    }
}