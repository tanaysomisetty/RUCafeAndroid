/**
 *This class implements Customizable and includes specific data
 * and operations pertaining to all store orders
 * @author Sailokesh Mondi, Tanay Somisetty
 */

package com.example.rucafe;

import java.util.ArrayList;
import java.util.List;

public class StoreOrders implements Customizable {
    private List<Order> orderList = new ArrayList();
    private int numOrders = 0;
    private List<Integer> removedOrderIds = new ArrayList<>();

    /**
     * This method adds an order object to the list of store orders
     * @param obj Object
     * @return true if the order is added, false otherwise
     */
    public boolean add(Object obj) {
        if (obj instanceof Order) {
            orderList.add((Order) obj);
            this.numOrders++;
            return true;
        }
        return false;
    }

    /**
     * This method removes an order object from the list of store orders
     * @param obj Object
     * @return true if the order is removed, false otherwise
     */
    public boolean remove(Object obj) {
        if (obj instanceof Order) {
            Order order = (Order) obj;
            for (int i = 0; i <= numOrders; i++) {
                Order currOrder = (Order) orderList.get(i);
                if (order.equals(currOrder)) {
                    orderList.remove(i);
                    this.numOrders--;
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    /**
     * Method to remove orders from all store orders
     * @param 'none'
     */
    public void removeOrdersFromStore() {
        List<Order> tempOrders = new ArrayList<>();
        tempOrders.addAll(orderList);

        for (int orderIds:removedOrderIds) {
                for (Order order: tempOrders) {
                    if (order.getOrderID() == orderIds) {
                        remove(order);
                    }
            }
        }
    }

    /**
     * Method to update the removed list of orders according to their IDs
     * @param orderId of the removed Orders
     * @param remove boolean that corresponds to list of IDs
     */
    public void updateRemovedOrders(final int orderId, final boolean remove) {

        if (remove) {
            removedOrderIds.add(orderId);
        } else {
            removedOrderIds.remove(orderId);
        }



    }

    /**
     * This method consists of the String representation of the full order list
     * @param 'none'
     * @return a String that corresponds to the order list
     */
    @Override
    public String toString() {
        String output = "";
        for (Object obj : orderList) {
            if (obj instanceof Order) {
                Order currOrder = (Order) obj;
                output = output + currOrder.toString();
                output = output + "====================" + "\n";
            }
        }
        return output;
    }

    /**
     * Accessory method to get the full array list of orders
     * @param 'none'
     * @return the array list of orders
     */
    public List<Order> getOrderList() {
        return orderList;
    }
}