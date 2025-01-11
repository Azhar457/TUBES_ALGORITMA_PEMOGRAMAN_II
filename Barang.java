package TUBES_ALGORITMA_PEMOGRAMAN_II;

import java.io.*;
import java.util.*;

public class Barang implements Serializable {

    private static final String filePath = "C:\\Data\\barang.dat";
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

    public static List<Barang> loadAll() {
        List<Barang> barangs = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
            while (true) {
                barangs.add((Barang) in.readObject());
            }
        } catch (EOFException e) {
            // End of file reached
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return barangs;
    }

    public static void saveAll(List<Barang> barangs) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
            for (Barang b : barangs) {
                out.writeObject(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void reduceStock(int quantity) {
        if (stok >= quantity) {
            stok -= quantity;
        }
    }

    public boolean hasStock(int quantity) {
        return stok >= quantity;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nama: " + nama + ", Harga: " + harga + ", Stok: " + stok;
    }
}
