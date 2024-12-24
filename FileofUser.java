package TUBES_ALGORITMA_PEMOGRAMAN_II;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class FileofUser {

    Scanner sc = new Scanner(System.in);

    void safeToFile() {
        User x = new User();
        System.out.println("========== SaveToFile ======");
        ObjectOutputStream out = null;

        try {
            // 1. buka file untuk ditulis
            out = new ObjectOutputStream(new FileOutputStream("D:\\BAckup\\Desktop\\user.dat" + ""));// nama direktori+file
            BufferedReader brInput = new BufferedReader(new InputStreamReader(System.in));
            for (int i = 0; i < 3; i++) {
                System.out.println("User : " + i);
                x.Baca();
                out.writeObject(x);// tulis record ke file
                x = new User();
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ViewFile() {
        int total = 0;
        User x = new User();
        System.out.println("========== ViewFile ======");
        ObjectInputStream in = null;
        try {
            // 1. buka file untuk dibaca
            in = new ObjectInputStream(new FileInputStream("D:\\BAckup\\Desktop\\user.dat"));
            Object curR = in.readObject(); //fread
            try {
                // 2. Baca dan proses setiap record yang dibaca
                while (true) {
                    x = (User) curR;
                    System.out.println("Record ke-" + (total + 1) + " : ");
                    x.Tampil();
                    total++;
                    curR = in.readObject();
                }
            } catch (EOFException e) {
            }
            System.out.println("\nTotal record : " + total);
        } catch (ClassNotFoundException e) {
            System.out.println("Class tidak ditemukan");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void ViewPass() {
        int total = 0;
        User x = new User();
        System.out.println("========== ViewPass ======");
        ObjectInputStream in = null;
        try {
            // 1. buka file untuk dibaca
            in = new ObjectInputStream(new FileInputStream("D:\\BAckup\\Desktop\\user.dat"));
            Object curR = in.readObject(); //fread
            try {
                // 2. Baca dan proses setiap record yang dibaca
                while (true) {
                    x = (User) curR;
                    System.out.println("Record ke-" + (total + 1) + " : ");
                    x.TampilPass();
                    total++;
                    curR = in.readObject();
                }
            } catch (EOFException e) {
            }
            System.out.println("\nTotal record : " + total);
        } catch (ClassNotFoundException e) {
            System.out.println("Class tidak ditemukan");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FileofUser M = new FileofUser();
//        M.safeToFile();
        M.ViewFile();
        M.ViewPass();
    }
}
