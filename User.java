package TUBES_ALGORITMA_PEMOGRAMAN_II;

import java.util.Scanner;

public class User implements java.io.Serializable {

    String id, pass, nama;
    Integer Saldo;

    public User() {
        id = "$";
        pass = "$";
        nama = "$";
        Saldo = 0;
    }

    void Baca() {
        Scanner sc = new Scanner(System.in);
        System.out.print("USERNAME : ");
        id = sc.nextLine();
        System.out.print("PASSWORD : ");
        pass = sc.nextLine();
        System.out.print("NAMA : ");
        nama = sc.nextLine();
    }

    void Tampil() {
        System.out.println("USERNAME : " + id);
        System.out.println("PASSWORD : " + pass);
        System.out.println("NAMA : " + nama);
    }

    void TampilPass() {
    	System.out.println("USERNAME : " + nama);
        System.out.print("PASSWORD : ");
        System.out.print(pass.charAt(0));
        int n = pass.length();
        for (int i = 1; i < n - 1; i++) {
            System.out.print("*");
        }
        System.out.println(pass.charAt(n - 1));
    }

    void tambahSaldo(int jumlah) {
        Saldo += jumlah;
    }

    void kurangiSaldo(int jumlah) {
        if (Saldo >= jumlah) {
            Saldo -= jumlah;
        } else {
            System.out.println("Saldo tidak mencukupi.");
        }
    }

    void tampilSaldo() {
        System.out.println("Saldo: " + Saldo);
    }

    public static void main(String[] args) {
        User T = new User();
        T.Baca();
        T.TampilPass();
    }
}
