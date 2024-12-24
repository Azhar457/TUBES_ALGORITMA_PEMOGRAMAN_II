package TUBES_ALGORITMA_PEMOGRAMAN_II;

import java.util.List;
import java.util.Scanner;

public class FileOfToko {

    Scanner sc = new Scanner(System.in);
    FileofUser fileOfUser = new FileofUser();
    FileofLogin fileOfLogin = new FileofLogin();
    FileofBarang fileOfBarang = new FileofBarang();

    public void menuUtama() {
        while (true) {
            System.out.println("========== Menu Utama ==========");
            System.out.println("1. Login sebagai User");
            System.out.println("2. Login sebagai Kasir");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (pilihan) {
                case 1:
                    loginUser();
                    break;
                case 2:
                    loginKasir();
                    break;
                case 3:
                    System.out.println("Terima kasih telah menggunakan aplikasi ini.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    private void loginUser() {
        System.out.println("========== Login User ==========");
        fileOfLogin.Login();
        // Jika login berhasil, tampilkan menu user
        menuUser();
    }

    private void loginKasir() {
        System.out.println("========== Login Kasir ==========");
        // Implementasikan login kasir
        // Jika login berhasil, tampilkan menu kasir
        menuKasir();
    }

    private void menuUser() {
        while (true) {
            System.out.println("========== Menu User ==========");
            System.out.println("1. Lihat Saldo");
            System.out.println("2. Tambah Saldo");
            System.out.println("3. Kurangi Saldo");
            System.out.println("4. Lihat Barang");
            System.out.println("5. Beli Barang");
            System.out.println("6. Logout");
            System.out.print("Pilih menu: ");
            int pilihan = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (pilihan) {
                case 1:
                    // Implementasikan lihat saldo
                    break;
                case 2:
                    // Implementasikan tambah saldo
                    break;
                case 3:
                    // Implementasikan kurangi saldo
                    break;
                case 4:
                    fileOfBarang.tampilBarang();
                    break;
                case 5:
                    beliBarang();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    private void beliBarang() {
        System.out.println("========== Beli Barang ==========");
        fileOfBarang.tampilBarang();
        System.out.print("Masukkan nama barang yang ingin dibeli: ");
        String namaBarang = sc.nextLine();
        List<Barang> barangList = fileOfBarang.bacaBarang();
        for (Barang barang : barangList) {
            if (barang.nama.equals(namaBarang)) {
                System.out.print("Masukkan jumlah yang ingin dibeli: ");
                int jumlah = sc.nextInt();
                sc.nextLine(); // consume newline
                if (jumlah <= barang.stok) {
                    // Implementasikan pengurangan saldo user dan pengurangan stok barang
                    System.out.println("Pembelian berhasil.");
                } else {
                    System.out.println("Stok tidak mencukupi.");
                }
                return;
            }
        }
        System.out.println("Barang tidak ditemukan.");
    }

    private void menuKasir() {
        while (true) {
            System.out.println("========== Menu Kasir ==========");
            System.out.println("1. Tambah Barang");
            System.out.println("2. Hapus Barang");
            System.out.println("3. Lihat Barang");
            System.out.println("4. Logout");
            System.out.print("Pilih menu: ");
            int pilihan = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (pilihan) {
                case 1:
                    tambahBarang();
                    break;
                case 2:
                    hapusBarang();
                    break;
                case 3:
                    fileOfBarang.tampilBarang();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    private void tambahBarang() {
        System.out.println("========== Tambah Barang ==========");
        System.out.print("Masukkan nama barang: ");
        String nama = sc.nextLine();
        System.out.print("Masukkan harga barang: ");
        int harga = sc.nextInt();
        System.out.print("Masukkan stok barang: ");
        int stok = sc.nextInt();
        sc.nextLine(); // consume newline
        Barang barang = new Barang(nama, harga, stok);
        fileOfBarang.tambahBarang(barang);
        System.out.println("Barang berhasil ditambahkan.");
    }

    private void hapusBarang() {
        System.out.println("========== Hapus Barang ==========");
        System.out.print("Masukkan nama barang yang ingin dihapus: ");
        String namaBarang = sc.nextLine();
        fileOfBarang.hapusBarang(namaBarang);
        System.out.println("Barang berhasil dihapus.");
    }

    public static void main(String[] args) {
        FileOfToko toko = new FileOfToko();
        toko.menuUtama();
    }
}
