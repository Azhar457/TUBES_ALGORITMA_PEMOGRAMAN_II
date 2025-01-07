package TUBES_ALGORITMA_PEMOGRAMAN_II;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileOfBarang implements java.io.Serializable {

    private final String filePath = "C:\\Data\\barang.dat";

    void safeToFile(List<Barang> barangList) {
        System.out.println("========== SaveToFile ======");
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
            for (Barang barang : barangList) {
                out.writeObject(barang);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Barang> ViewFile() {
        List<Barang> barangList = new ArrayList<>();
        System.out.println("========== ViewFile ======");
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
            while (true) {
                Barang barang = (Barang) in.readObject();
                barangList.add(barang);
            }
        } catch (EOFException e) {
            // End of file reached
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();


}
        return barangList;
    }

    public void tampil() {
        List<Barang> barangList = ViewFile();
        for (Barang barang : barangList) {
            barang.tampil();
        }
    }

}