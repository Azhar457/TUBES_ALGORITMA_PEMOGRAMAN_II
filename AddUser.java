package TUBES_ALGORITMA_PEMOGRAMAN_II;

import java.io.*;
import java.util.Scanner;

public class AddUser {
    public static void main(String[] args) {
        String filePath = "C:\\Data\\user.dat";
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan jumlah user yang ingin ditambahkan: ");
        int jumlah = sc.nextInt();
        sc.nextLine(); // Clear newline character

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath, true))) {
            for (int i = 0; i < jumlah; i++) {
                System.out.println("\n========== Tambah User ==========");
                System.out.print("Masukkan USERNAME: ");
                String id = sc.nextLine();
                System.out.print("Masukkan PASSWORD: ");
                String pass = sc.nextLine();
                System.out.print("Masukkan ROLE (Kasir/Customer): ");
                String role = sc.nextLine();

                User user = new User(id, pass, role);
                out.writeObject(user);
                System.out.println("User berhasil ditambahkan!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class User implements Serializable {
    String id;
    String pass;
    String role; // Kasir atau Customer

    User(String id, String pass, String role) {
        this.id = id;
        this.pass = pass;
        this.role = role;
    }
}
