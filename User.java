package TUBES_ALGORITMA_PEMOGRAMAN_II;

import java.util.Scanner;

public class User implements java.io.Serializable {

    // String id, pass, nama;
    // Integer Saldo;

    char[] id = new char[6];
    char[] pass = new char[20]; // assuming max length of 20 for password
    char[] nama = new char[50]; // assuming max length of 50 for name
    Integer Saldo;

    public User() {
        Saldo = 0;
    }

    void Baca() {
         Scanner sc = new Scanner(System.in);
        System.out.print("USERNAME (max 6 chars): ");
        String tempId = sc.nextLine();
        while (tempId.length() > 6) {
            System.out.print("USERNAME too long, please enter again (max 6 chars): ");
            tempId = sc.nextLine();
        }
        id = tempId.toCharArray();

        System.out.print("PASSWORD (min 6 chars): ");
        String tempPass = sc.nextLine();
        while (tempPass.length() < 6) {
            System.out.print("PASSWORD too short, please enter again (min 6 chars): ");
            tempPass = sc.nextLine();
        }
        pass = tempPass.toCharArray();

        System.out.print("NAMA: ");
        String tempNama = sc.nextLine();
        nama = tempNama.toCharArray();
    }

    void Tampil() {
        System.out.println("USERNAME : " + new String(id));
        System.out.println("PASSWORD : " + new String(pass));
        System.out.println("NAMA : " + new String(nama));
    }

    void TampilPass() {
       System.out.print("PASSWORD : ");
        System.out.print(pass[0]);
        int n = pass.length;
        for (int i = 1; i < n - 1; i++) {
            System.out.print("*");
        }
        System.out.println(pass[n - 1]);
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
        T.Tampil();
        T.TampilPass();
        T.tambahSaldo(1000);
        T.tampilSaldo();
        T.kurangiSaldo(500);
        T.tampilSaldo();
    }
}