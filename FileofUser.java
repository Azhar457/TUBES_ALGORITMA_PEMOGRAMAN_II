package TUBES_ALGORITMA_PEMOGRAMAN_II;

import java.io.*;
import java.util.Scanner;

public class FileOfUser {

    private final String filePath = "C:\\Data\\user.dat";
    Scanner sc = new Scanner(System.in);

    void safeToFile() {
        User x = new User();
        System.out.println("========== SaveToFile ======");
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
            for (int i = 0; i < 3; i++) {
                System.out.println("User : " + i);
                x.Baca();
                out.writeObject(x);
                x = new User();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ViewFile() {
        int total = 0;
        System.out.println("========== ViewFile ======");
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
            while (true) {
                User x = (User) in.readObject();
                System.out.println("Record ke-" + (total + 1) + " : ");
                x.Tampil();
                total++;
            }
        } catch (EOFException e) {
            // End of file reached
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        System.out.println("\nTotal record : " + total);
    }

    public void ViewPass() {
        int total = 0;
        System.out.println("========== ViewPass ======");
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
            while (true) {
                User x = (User) in.readObject();
                System.out.println("Record ke-" + (total + 1) + " : ");
                x.TampilPass();
                total++;
            }
        } catch (EOFException e) {
            // End of file reached
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        System.out.println("\nTotal record : " + total);
    }

    public static void main(String[] args) {
        FileOfUser M = new FileOfUser();
        M.safeToFile();
        M.ViewFile();
        M.ViewPass();
    }
}
