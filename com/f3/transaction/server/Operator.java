/**
 * Author: Faisal Fandi
 */
package com.f3.transaction.server;

public class Operator {
    private final Customer customer = new Customer();

    /*
    public void buyPulsa(int amount){
        customer.addPulsa(amount);
    }
    */

    public void buyKuota(){
        new Kuota(customer);
    }


    public int checkKuota(){
        return customer.getKuota();
    }

    public int checkPulsa(){
        return customer.getPulsa();
    }
}
