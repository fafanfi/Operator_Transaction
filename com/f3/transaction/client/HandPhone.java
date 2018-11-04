/**
 * Author: Faisal Fandi
 */
package com.f3.transaction.client;

import com.f3.transaction.server.Operator;

public class HandPhone {
    private final String number = "08123456789";
    private final Operator operator = new Operator();

    public String getNumber(){
        return number;
    }

    public int checkKuota(){
        return operator.checkKuota();
    }

    public int checkPulsa(){
        return operator.checkPulsa();
    }

    public void buyKuota(){
        operator.buyKuota();
    }

    /*
    public void buyPulsa(int amount){
        operator.buyPulsa(amount);
    }
    */

    public static void main(String[] args){
        HandPhone android = new HandPhone();

        while(true){
            System.out.println("No Hp: " + android.getNumber());
            System.out.printf("Pulsa: %d %20s %d%n", android.checkPulsa(), "Kuota(MB):", android.checkKuota());
            android.buyKuota();
        }
    }
}
