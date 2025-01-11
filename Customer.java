package TUBES_ALGORITMA_PEMOGRAMAN_II;

import java.io.*;
import java.util.*;

public class Customer implements Serializable {

    private static final String FILE_PATH = "C:\\Data\\customer.dat";
    private static final long serialVersionUID = 1L;

    private String id;
    private String username;
    private String password;
    private double saldo;

    public Customer(String id, String username, String password, double saldo) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.saldo = saldo;
    }

    // Getter methods
    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public double getSaldo() {
        return saldo;
    }

    // Method untuk autentikasi
    public boolean authenticate(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    // Method untuk menambah saldo
    public void updateSaldo(double amount) {
        if (amount > 0) {
            this.saldo += amount;
        }
    }

    // Method untuk mengurangi saldo
    public boolean deductSaldo(double amount) {
        if (this.saldo >= amount) {
            this.saldo -= amount;
            return true;
        }
        return false;
    }

    // Method untuk load data dari file
    public static List<Customer> loadAll() {
        List<Customer> customers = new ArrayList<>();
        File file = new File(FILE_PATH);

        // Buat direktori jika belum ada
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }

        // Jika file belum ada, return list kosong
        if (!file.exists()) {
            return customers;
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                try {
                    Customer customer = (Customer) in.readObject();
                    customers.add(customer);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading customer data: " + e.getMessage());
        }

        return customers;
    }

    // Method untuk save data ke file
    public static void saveAll(List<Customer> customers) {
        File file = new File(FILE_PATH);

        // Buat direktori jika belum ada
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            for (Customer customer : customers) {
                out.writeObject(customer);
            }
        } catch (IOException e) {
            System.out.println("Error saving customer data: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return String.format("Customer[ID: %s, Username: %s, Saldo: %.2f]",
                id, username, saldo);
    }
}
