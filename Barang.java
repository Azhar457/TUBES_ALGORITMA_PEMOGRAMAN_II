package TUBES_ALGORITMA_PEMOGRAMAN_II;

import java.io.*;
import java.util.*;

public class Barang implements Serializable {

    private static final String FILE_PATH = "C:\\Data\\barang.dat";
    private static final long serialVersionUID = 1L;

    private String id;
    private String nama;
    private double harga;
    private int stok;

    public Barang(String id, String nama, double harga, int stok) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    // Getter methods
    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }

    public int getStok() {
        return stok;
    }

    // Method untuk mengurangi stok
    public void reduceStock(int quantity) {
        if (this.stok >= quantity) {
            this.stok -= quantity;
        }
    }

    // Method untuk mengecek ketersediaan stok
    public boolean hasStock(int quantity) {
        return this.stok >= quantity;
    }

    // Method untuk menambah stok
    public void addStock(int quantity) {
        if (quantity > 0) {
            this.stok += quantity;
        }
    }

    // Method untuk load data dari file
    public static List<Barang> loadAll() {
        List<Barang> barangs = new ArrayList<>();
        File file = new File(FILE_PATH);

        // Buat direktori jika belum ada
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }

        // Jika file belum ada, return list kosong
        if (!file.exists()) {
            return barangs;
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                try {
                    Barang barang = (Barang) in.readObject();
                    barangs.add(barang);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading barang data: " + e.getMessage());
        }

        return barangs;
    }

    // Method untuk save data ke file
    public static void saveAll(List<Barang> barangs) {
        File file = new File(FILE_PATH);

        // Buat direktori jika belum ada
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            for (Barang barang : barangs) {
                out.writeObject(barang);
            }
        } catch (IOException e) {
            System.out.println("Error saving barang data: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return String.format("Barang[ID: %s, Nama: %s, Harga: %.2f, Stok: %d]",
                id, nama, harga, stok);
    }
}
