package TUBES_ALGORITMA_PEMOGRAMAN_II;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class Barang implements Serializable {
	
    String nama;
    double harga;
    int stok;

    public Barang(String nama, double harga, int stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }


    public void display() {
        System.out.println("Nama: " + this.nama);
        System.out.println("Harga: " + this.harga);
        System.out.println("Stok: " + this.stok);
        System.out.println("------------------------");
    }


    public static List<Barang> readAllFromFile() {
        List<Barang> barangList = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("C:\\Data\\Barang.dat"))) {
            while (true) {
                Barang barang = (Barang) in.readObject();
                barangList.add(barang);
            }
        } catch (EOFException e) {
            // EOFException menandakan akhir dari file
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return barangList;
    }

    public static void writeAllToFile(List<Barang> barangList) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("C:\\Data\\Barang.dat"))) {
            for (Barang barang : barangList) {
                out.writeObject(barang);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	public void saveToFile() {
        List<Barang> barangList = Barang.readAllFromFile(); // Baca data lama
        barangList.add(this); // Tambahkan barang baru
        Barang.writeAllToFile(barangList); // Tulis ulang ke file
    }
}

