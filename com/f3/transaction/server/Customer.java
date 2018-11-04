/**
 * Author: Faisal Fandi
 */
package com.f3.transaction.server;

public class Customer {
    private int pulsa = 20000; // misalkan pulsa awal yang dimiliki handphone customer
    private int kuota = 0;

    public void addKuota(int kuota){
        this.kuota += kuota;
    }

    public void addPulsa(int amount){
        pulsa += amount;
    }

    public void subtractPulsa(int price){
        pulsa -= price;
    }

    public int getPulsa() {
        return pulsa;
    }

    public int getKuota() {
        return kuota;
    }
}
