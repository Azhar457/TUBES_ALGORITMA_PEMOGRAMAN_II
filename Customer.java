package TUBES_ALGORITMA_PEMOGRAMAN_II;

import java.io.*;
import java.util.*;

public class Customer implements Serializable {

    private static final String filePath = "C:\\Data\\customer.dat";
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

    public static List<Customer> loadAll() {
        List<Customer> customers = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
            while (true) {
                customers.add((Customer) in.readObject());
            }
        } catch (EOFException e) {
            // End of file reached
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public static void saveAll(List<Customer> customers) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
            for (Customer c : customers) {
                out.writeObject(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateSaldo(double amount) {
        this.saldo += amount;
    }

    public boolean deductSaldo(double amount) {
        if (this.saldo >= amount) {
            this.saldo -= amount;
            return true;
        }
        return false;
    }

    public boolean authenticate(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public String getId() {
        return id;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Username: " + username + ", Saldo: " + saldo;
    }
}
