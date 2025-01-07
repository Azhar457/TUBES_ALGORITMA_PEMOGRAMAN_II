package TUBES_ALGORITMA_PEMOGRAMAN_II;

public class Barang implements java.io.Serializable {

    String nama_barang;
    int harga;
    int stok;

    public Barang() {
        this.nama_barang = nama_barang;
        this.harga = harga;
        this.stok = stok;
    }
    public void tambahBarang(String nama_barang, int harga, int stok) {
        this.nama_barang = nama_barang;
        this.harga = harga;
        this.stok = stok;
    }

    public void hapusBarang() {
        this.nama_barang = "";
        this.harga = 0;
        this.stok = 0;
    }

    

    public void tampil() {
        System.out.println("Nama Barang: " + nama_barang);
        System.out.println("Harga: " + harga);
        System.out.println("Stok: " + stok);
    }


}
