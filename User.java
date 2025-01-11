package TUBES_ALGORITMA_PEMOGRAMAN_II;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User implements Serializable {

    String id;
    String pass;
    String role; // Kasir atau Customer

    public User(String id, String pass, String role) {
        this.id = id;
        this.pass = pass;
        this.role = role;
    }

    public void read() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan USERNAME: ");
        this.id = sc.nextLine();
        System.out.print("Masukkan PASSWORD: ");
        this.pass = sc.nextLine();
        System.out.print("Masukkan ROLE (Kasir/Customer): ");
        this.role = sc.nextLine();
    }

    public void display() {
        System.out.println("ID: " + this.id);
        System.out.println("Role: " + this.role);
        System.out.println("------------------------");
    }

    public static List<User> readAllFromFile() {
        List<User> userList = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("C:\\Data\\user.dat"))) {
            while (true) {
                User user = (User) in.readObject();
                userList.add(user);
            }
        } catch (EOFException e) {
            // EOFException menandakan akhir dari file
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public static void writeAllToFile(List<User> userList) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("C:\\Data\\user.dat"))) {
            for (User user : userList) {
                out.writeObject(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveToFile() {
        List<User> userList = User.readAllFromFile(); // Baca data lama
        userList.add(this); // Tambahkan user baru
        User.writeAllToFile(userList); // Tulis ulang ke file
    }
}
