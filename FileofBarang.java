package TUBES_ALGORITMA_PEMOGRAMAN_II;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileofBarang {

    private final String filePath = "C:\\data\\barang.dat";

    public void tambahBarang(Barang barang) {
        List<Barang> barangList = bacaBarang();
        barangList.add(barang);
        simpanBarang(barangList);
    }

    public void hapusBarang(String namaBarang) {
        List<Barang> barangList = bacaBarang();
        barangList.removeIf(barang -> barang.nama.equals(namaBarang));
        simpanBarang(barangList);
    }

    public List<Barang> bacaBarang() {
        List<Barang> barangList = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
            barangList = (List<Barang>) in.readObject();
        } catch (EOFException e) {
            // End of file reached
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return barangList;
    }

    private void simpanBarang(List<Barang> barangList) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
            out.writeObject(barangList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void tampilBarang() {
        List<Barang> barangList = bacaBarang();
        for (Barang barang : barangList) {
            barang.tampil();
        }
    }
}
