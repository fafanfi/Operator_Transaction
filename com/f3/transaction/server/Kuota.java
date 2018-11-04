/**
 * Author: Faisal Fandi
 */
package com.f3.transaction.server;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Kuota {
    private Map<String, Paket[]> packages = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);
    private final Customer customer;

    public Kuota(Customer customer){
        this.customer = customer;

        // Data Paket Kuota (asumsi saja)
        packages.put("harian", new Paket[]{
                new Paket(100, 1, 11000),
                new Paket(200, 1, 12000),
                new Paket(300, 1, 13000),
                new Paket(400, 1, 14000),
                new Paket(500, 1, 15000),
        });

        packages.put("mingguan", new Paket[]{
                new Paket(600, 7, 16000),
                new Paket(700, 7, 17000),
                new Paket(800, 7, 18000),
                new Paket(900, 7, 19000),
                new Paket(1000, 7, 20000),
        });

        packages.put("bulanan", new Paket[]{
                new Paket(500, 30, 16000),
                new Paket(1000, 30, 20000),
                new Paket(1800, 30, 25000),
                new Paket(2000, 30, 30000),
                new Paket(5000, 30, 50000),
        });

        menu();
    }

    private void menu(){
        System.out.println("---------------------");
        System.out.println("1. Paket Harian");
        System.out.println("2. Paket Mingguan");
        System.out.println("3. Paket Bulanan");
        System.out.println("---------------------");

        int choose = scanner.nextInt();

        switch(choose){
            case 1: harian(); break;
//            case 2: mingguan(); break;
//            case 3: bulanan(); break;
        }
    }

    private void harian(){
        Paket[] paketHarian = packages.get("harian");

        System.out.println("---------------------");
        for(int i = 0; i < 5; i++)
            System.out.printf("%d. %dMB/%dhr mulai %drb%n", i+1, paketHarian[i].getLocalData(), paketHarian[i].getExpired(), paketHarian[i].getPrice());
        System.out.println("---------------------");

        int choise = scanner.nextInt();

        pay(paketHarian[choise - 1]);
    }

    private void pay(Paket paket){
        int localData = paket.getLocalData();
        int expired = paket.getExpired();
        int price = paket.getPrice();

        System.out.printf("Anda akan membeli paket %dMB/%dhr harga Rp%d%n", localData, expired, price);
        System.out.println("1. Ya");
        System.out.println("2. Tidak");

        int choise = scanner.nextInt();
        System.out.println();

        if(choise == 1){
            if(customer.getPulsa() < price)
                System.out.println("Pulsa anda tidak mencukupi untuk melakukan pembelian.");
            else {
                customer.subtractPulsa(price);
                customer.addKuota(localData);
                System.out.println("Selamat anda berhasil melakukan pembelian kuota.");
            }
        }
    }
}
