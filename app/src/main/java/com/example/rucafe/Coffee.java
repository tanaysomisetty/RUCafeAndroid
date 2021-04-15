package com.example.rucafe;

import java.util.ArrayList;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 *This class extends the MenuItem class and implements customizable.
 * It includes specific data and operations pertaining to a coffee object
 * @author Sailokesh Mondi, Tanay Somisetty
 */
public class Coffee extends MenuItem implements Customizable {
    private String size = "";
    private ArrayList addInsList = new ArrayList();
    private int numAddIns = 0;
    final static double SHORT_PRICE = 1.99;
    final static double TALL_PRICE = 2.49;
    final static double GRANDE_PRICE = 2.99;
    final static double VENTI_PRICE = 3.49;
    final double PRICE_OF_ADDIN = 0.20;

    /**
     * Method to add instances of coffee in the coffee controller GUI
     *
     * @param obj Object
     * @return true if the coffee is added, false otherwise
     */
    public boolean add(Object obj) {
        if (obj instanceof AddIn) {
            addInsList.add(obj);
            numAddIns++;
            return true;
        }
        return false;
    }

    /**
     * Method to remove instances of coffee in the coffee controller GUI
     *
     * @param obj Object
     * @return true if the coffee is removed from the list, false otherwise
     */
    public boolean remove(Object obj) {
        if (obj instanceof AddIn) {
            AddIn addin = (AddIn) obj;
            for (int i = 0; i < numAddIns; i++) {
                AddIn currAddIn = (AddIn) addInsList.get(i);
                if (addin.equals(currAddIn)) {
                    addInsList.remove(i);
                    this.numAddIns--;
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    /**
     * Setter method to set the size of the coffee
     *
     * @param size of coffee
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * Getter method to get the size
     *
     * @return String that gets the size of the coffee
     */
    public String getSize() {
        return this.size;
    }

    /**
     * Method to calculate the price for different  coffee sizes
     *
     * @return double value that gets the price of the coffee
     */
    @Override
    public double itemPrice() {


        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.UP);

        if (this.size == null) {
            return 0;
        } else if (this.size.equals("Short")) {
            super.setPrice(SHORT_PRICE + addInsList.size() * PRICE_OF_ADDIN);
            return Double.parseDouble(df.format(super.getPrice()));
        } else if (this.size.equals("Tall")) {
            super.setPrice(TALL_PRICE + addInsList.size() * PRICE_OF_ADDIN);
            return Double.parseDouble(df.format(super.getPrice()));
        } else if (this.size.equals("Grande")) {
            super.setPrice(GRANDE_PRICE + addInsList.size() * PRICE_OF_ADDIN);
            return Double.parseDouble(df.format(super.getPrice()));
        } else if (this.size.equals("Venti")) {
            super.setPrice(VENTI_PRICE + addInsList.size() * PRICE_OF_ADDIN);
            return Double.parseDouble(df.format(super.getPrice()));
        } else {
            return 0.00;
        }
    }

    /**
     * Method to give a string representation of a Coffee object
     *
     * @return a string in the format "Coffee,Size,Addin #1,Addin #2,etc"
     */
    @Override
    public String toString() {
        String addins = "";

        for (int i = 0; i < numAddIns; i++) {
            String currAddIn = addInsList.get(i).toString();
            addins = addins + "," + currAddIn;
        }

        return "Coffee," + this.size + addins;
    }

    /**
     * Accessory method to set the item details. Calls the method in the parent class.
     */
    @Override
    public void setItemDetails() {
        super.setDetails(toString());
    }
}