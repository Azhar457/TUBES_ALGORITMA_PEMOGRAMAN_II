package TUBES_ALGORITMA_PEMOGRAMAN_II;

import java.io.*;
import java.util.*;

public class MainProgram {

    private static final String filePath = "C:\\Data\\user.dat";
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        while (true) {
            System.out.println("========== MENU UTAMA ==========");
            System.out.println("1. Login");
            System.out.println("2. Exit");
            System.out.print("Pilih menu: ");
            choice = sc.nextInt();
            sc.nextLine(); // Clear newline character

            switch (choice) {
                case 1:
                    loginMenu();
                    break;
                case 2:
                    System.out.println("Terima kasih telah menggunakan program ini.");
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void loginMenu() {
        System.out.print("Masukkan USERNAME: ");
        String inputId = sc.nextLine();
        System.out.print("Masukkan PASSWORD: ");
        String inputPass = sc.nextLine();

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
            while (true) {
                User user = (User) in.readObject();
                if (user.id.equals(inputId) && user.pass.equals(inputPass)) {
                    System.out.println("Login Berhasil sebagai " + user.role);
                    if (user.role.equalsIgnoreCase("Kasir")) {
                        kasirMenu();
                    } else if (user.role.equalsIgnoreCase("Customer")) {
                        customerMenu();
                    }
                    return;
                }
            }
        } catch (EOFException e) {
            System.out.println("Login Gagal: USERNAME atau PASSWORD salah.");
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void kasirMenu() {
        int choice;
        while (true) {
            System.out.println("\n========== MENU KASIR ==========");
            System.out.println("1. Tambah Barang");
            System.out.println("2. Lihat Barang");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu: ");
            choice = sc.nextInt();
            sc.nextLine(); // Clear newline character

            switch (choice) {
                case 1:
                    addBarang();
                    break;
                case 2:
                    viewBarang();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void customerMenu() {
        int choice;
        while (true) {
            System.out.println("\n========== MENU CUSTOMER ==========");
            System.out.println("1. Lihat Barang");
            System.out.println("2. Keluar");
            System.out.print("Pilih menu: ");
            choice = sc.nextInt();
            sc.nextLine(); // Clear newline character

            switch (choice) {
                case 1:
                    viewBarang();
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void addBarang() {
        System.out.println("========== Tambah Barang ==========");
        System.out.print("Masukkan Nama Barang: ");
        String nama = sc.nextLine();
        System.out.print("Masukkan Harga Barang: ");
        double harga = sc.nextDouble();
        System.out.print("Masukkan Stok Barang: ");
        int stok = sc.nextInt();
        sc.nextLine(); // Clear newline character

        Barang barang = new Barang(nama, harga, stok);
        barang.saveToFile();
        System.out.println("Barang berhasil ditambahkan.");
    }

    private static void viewBarang() {
        System.out.println("========== Daftar Barang ==========");
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("C:\\Data\\barang.dat"))) {
            while (true) {
                Barang barang = (Barang) in.readObject();
                barang.display();
            }
        } catch (EOFException e) {
            System.out.println("-- Akhir dari daftar --");
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
}

class User implements Serializable {

    String id;
    String pass;
    String role; // Kasir atau Customer

    User(String id, String pass, String role) {
        this.id = id;
        this.pass = pass;
        this.role = role;
    }

    void read() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan USERNAME: ");
        this.id = sc.nextLine();
        System.out.print("Masukkan PASSWORD: ");
        this.pass = sc.nextLine();
        System.out.print("Masukkan ROLE (Kasir/Customer): ");
        this.role = sc.nextLine();
    }
}

class Barang implements Serializable {

    String nama;
    double harga;
    int stok;

    Barang(String nama, double harga, int stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    void saveToFile() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("C:\\Data\\barang.dat", true))) {
            out.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void display() {
        System.out.println("Nama: " + this.nama);
        System.out.println("Harga: " + this.harga);
        System.out.println("Stok: " + this.stok);
        System.out.println("------------------------");
    }
}
