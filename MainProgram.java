// MainProgram.java
package TUBES_ALGORITMA_PEMOGRAMAN_II;

import java.util.*;

public class MainProgram {

    private static final Scanner sc = new Scanner(System.in);
    private static List<Customer> customers = new ArrayList<>();
    private static List<Kasir> kasirs = new ArrayList<>();
    private static List<Barang> barangs = new ArrayList<>();

    public static void main(String[] args) {
        initializeData();
        int choice;
        while (true) {
            System.out.println("========== MENU UTAMA ==========");
            System.out.println("1. Login Customer");
            System.out.println("2. Login Kasir");
            System.out.println("3. Exit");
            System.out.print("Pilih menu: ");
            choice = sc.nextInt();
            sc.nextLine(); // Clear newline character

            switch (choice) {
                case 1:
                    loginCustomer();
                    break;
                case 2:
                    loginKasir();
                    break;
                case 3:
                    System.out.println("Terima kasih telah menggunakan program ini.");
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void initializeData() {
        customers.add(new Customer("C001", "customer1", "pass1", 50000));
        kasirs.add(new Kasir("K001", "kasir1", "pass1"));
        barangs.add(new Barang("B001", "Shampoo", 15000, 10));
        barangs.add(new Barang("B002", "Soap", 5000, 20));
    }

    private static void loginCustomer() {
        System.out.print("Masukkan Username: ");
        String username = sc.nextLine();
        System.out.print("Masukkan Password: ");
        String password = sc.nextLine();

        for (Customer customer : customers) {
            if (customer.getUsername().equals(username) && customer.getPassword().equals(password)) {
                customerMenu(customer);
                return;
            }
        }
        System.out.println("Login gagal. Username atau password salah.");
    }

    private static void loginKasir() {
        System.out.print("Masukkan Username: ");
        String username = sc.nextLine();
        System.out.print("Masukkan Password: ");
        String password = sc.nextLine();

        for (Kasir kasir : kasirs) {
            if (kasir.getUsername().equals(username) && kasir.getPassword().equals(password)) {
                kasirMenu();
                return;
            }
        }
        System.out.println("Login gagal. Username atau password salah.");
    }

    private static void customerMenu(Customer customer) {
        int choice;
        while (true) {
            System.out.println("\n========== MENU CUSTOMER ==========");
            System.out.println("1. Cek Saldo");
            System.out.println("2. Lihat Barang");
            System.out.println("3. Beli Barang");
            System.out.println("4. Tambah Saldo");
            System.out.println("5. Exit");
            System.out.print("Pilih menu: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Saldo Anda: " + customer.getSaldo());
                    break;
                case 2:
                    viewBarang();
                    break;
                case 3:
                    buyBarang(customer);
                    break;
                case 4:
                    System.out.print("Masukkan jumlah saldo yang ingin ditambahkan: ");
                    double amount = sc.nextDouble();
                    customer.addSaldo(amount);
                    System.out.println("Saldo berhasil ditambahkan. Saldo baru: " + customer.getSaldo());
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void kasirMenu() {
        int choice;
        while (true) {
            System.out.println("\n========== MENU KASIR ==========");
            System.out.println("1. Lihat Barang");
            System.out.println("2. Tambah Barang");
            System.out.println("3. Hapus Barang");
            System.out.println("4. Exit");
            System.out.print("Pilih menu: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    viewBarang();
                    break;
                case 2:
                    addBarang();
                    break;
                case 3:
                    removeBarang();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void viewBarang() {
        System.out.println("\n========== Daftar Barang ==========");
        for (Barang barang : barangs) {
            System.out.println(barang);
        }
    }

    private static void buyBarang(Customer customer) {
        System.out.print("Masukkan ID Barang: ");
        String id = sc.nextLine();
        System.out.print("Masukkan jumlah yang ingin dibeli: ");
        int quantity = sc.nextInt();
        sc.nextLine();

        for (Barang barang : barangs) {
            if (barang.getId().equals(id)) {
                double totalHarga = barang.getHarga() * quantity;
                if (customer.getSaldo() < totalHarga) {
                    System.out.println("Saldo tidak mencukupi. Pembelian dibatalkan.");
                } else if (barang.getStok() < quantity) {
                    System.out.println("Stok barang tidak mencukupi. Pembelian dibatalkan.");
                } else {
                    customer.reduceSaldo(totalHarga);
                    barang.reduceStok(quantity);
                    System.out.println("Pembelian berhasil. Saldo Anda sekarang: " + customer.getSaldo());
                }
                return;
            }
        }
        System.out.println("Barang dengan ID tersebut tidak ditemukan.");
    }

    private static void addBarang() {
        System.out.print("Masukkan ID Barang: ");
        String id = sc.nextLine();
        System.out.print("Masukkan Nama Barang: ");
        String nama = sc.nextLine();
        System.out.print("Masukkan Harga Barang: ");
        double harga = sc.nextDouble();
        System.out.print("Masukkan Stok Barang: ");
        int stok = sc.nextInt();
        sc.nextLine();

        barangs.add(new Barang(id, nama, harga, stok));
        System.out.println("Barang berhasil ditambahkan.");
    }

    private static void removeBarang() {
        System.out.print("Masukkan ID Barang yang ingin dihapus: ");
        String id = sc.nextLine();

        Iterator<Barang> iterator = barangs.iterator();
        while (iterator.hasNext()) {
            Barang barang = iterator.next();
            if (barang.getId().equals(id)) {
                iterator.remove();
                System.out.println("Barang berhasil dihapus.");
                return;
            }
        }
        System.out.println("Barang dengan ID tersebut tidak ditemukan.");
    }
}
