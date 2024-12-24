package TUBES_ALGORITMA_PEMOGRAMAN_II;

public class Barang implements java.io.Serializable {

    String nama;
    int harga;
    int stok;

    public Barang(String nama, int harga, int stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    public void tampil() {
        System.out.println("Nama Barang: " + nama);
        System.out.println("Harga: " + harga);
        System.out.println("Stok: " + stok);
    }
}
