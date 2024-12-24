package TUBES_ALGORITMA_PEMOGRAMAN_II;

import java.util.Scanner;

public class User implements java.io.Serializable {

    String id, pass;

    public User() {
        id = "$";
        pass = "$";
    }

    void Baca() {
        Scanner sc = new Scanner(System.in);
        System.out.print("USERNAME : ");
        id = sc.nextLine();
        System.out.print("PASSWORD : ");
        pass = sc.nextLine();
    }

    void Tampil() {
        System.out.println("USERNAME : " + id);
        System.out.println("PASSWORD : " + pass);
    }

    void TampilPass() {
        System.out.print("PASSWORD : ");
        System.out.print(pass.charAt(0));
        int n = pass.length();
        for (int i = 1; i < n - 1; i++) {
            System.out.print("*");
        }
        System.out.println(pass.charAt(n - 1));
    }

    public static void main(String[] args) {
        User T = new User();
        T.Baca();
        T.Tampil();
        T.TampilPass();
    }
}
// Ini test
// ini test dari rianda
