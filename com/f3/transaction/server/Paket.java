/**
 * Author: Faisal Fandi
 */
package com.f3.transaction.server;

public class Paket {
    private int localData;
    private int expired;
    private int price;

    public Paket(int localData, int expired, int price){
        this.localData = localData;
        this.expired = expired;
        this.price = price;
    }

    public int getLocalData() {
        return localData;
    }

    public int getPrice() {
        return price;
    }

    public int getExpired() {
        return expired;
    }
}
