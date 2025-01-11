package TUBES_ALGORITMA_PEMOGRAMAN_II;

import java.util.*;

public class InitialDataSetup {
    public static void main(String[] args) {
        // Setup Customer awal
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("C001", "customer1", "pass1", 50000));
        Customer.saveAll(customers);
        System.out.println("Data customer awal berhasil disimpan");
        
        // Setup Kasir awal
        List<Kasir> kasirs = new ArrayList<>();
        kasirs.add(new Kasir("K001", "kasir1", "pass1"));
        Kasir.saveAll(kasirs);
        System.out.println("Data kasir awal berhasil disimpan");
        
        // Setup Barang awal
        List<Barang> barangs = new ArrayList<>();
        barangs.add(new Barang("B001", "Shampoo", 15000, 10));
        barangs.add(new Barang("B002", "Soap", 5000, 20));
        Barang.saveAll(barangs);
        System.out.println("Data barang awal berhasil disimpan");
    }
}