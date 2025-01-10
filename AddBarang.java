package TUBES_ALGORITMA_PEMOGRAMAN_II;

import java.io.*;
import java.util.Scanner;

public class AddBarang {
    public static void main(String[] args) {
        String filePath = "C:\\Data\\barang.dat";
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan jumlah barang yang ingin ditambahkan: ");
        int jumlah = sc.nextInt();
        sc.nextLine(); // Clear newline character

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath, true))) {
            for (int i = 0; i < jumlah; i++) {
                System.out.println("\n========== Tambah Barang ==========");
                System.out.print("Masukkan Nama Barang: ");
                String nama = sc.nextLine();
                System.out.print("Masukkan Harga Barang: ");
                double harga = sc.nextDouble();
                System.out.print("Masukkan Stok Barang: ");
                int stok = sc.nextInt();
                sc.nextLine(); // Clear newline character

                Barang barang = new Barang(nama, harga, stok);
                out.writeObject(barang);
                System.out.println("Barang berhasil ditambahkan!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
}
