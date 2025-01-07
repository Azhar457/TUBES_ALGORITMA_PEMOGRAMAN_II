package TUBES_ALGORITMA_PEMOGRAMAN_II;

import java.io.*;
import java.util.Scanner;

public class FileOfLogin implements java.io.Serializable {

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

    void updateToFile() {
        User x = new User();
        System.out.println("========== UpdateToFile ======");
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

    void deleteToFile() {
        User x = new User();
        System.out.println("========== DeleteToFile ======");
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

    public void Login() {
        boolean isLoginSuccessful = false;
        System.out.print("Masukkan USERNAME: ");
        String inputId = sc.nextLine();
        System.out.print("Masukkan PASSWORD: ");
        String inputPass = sc.nextLine();

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
            while (true) {
                User user = (User) in.readObject();
                if (user.id.equals(inputId) && user.pass.equals(inputPass)) {
                    isLoginSuccessful = true;
                }
            }
        } catch (EOFException e) {
            // End of file reached
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        if (isLoginSuccessful) {
            System.out.println("Login Berhasil");
        } else {
            System.out.println("Login Gagal");
        }
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
        FileOfLogin M = new FileOfLogin();
//        M.safeToFile();
        M.ViewFile();
        M.ViewPass();
        M.Login();
    }
}
