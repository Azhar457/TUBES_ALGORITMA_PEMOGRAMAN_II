package TUBES_ALGORITMA_PEMOGRAMAN_II;

import java.io.*;
import java.util.*;

public class Kasir implements Serializable {

    private static final String FILE_PATH = "C:\\Data\\kasir.dat";
    private static final long serialVersionUID = 1L;

    private String id;
    private String username;
    private String password;

    public Kasir(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    // Getter methods
    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // Method untuk autentikasi
    public boolean authenticate(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    // Method untuk load data dari file
    public static List<Kasir> loadAll() {
        List<Kasir> kasirs = new ArrayList<>();
        File file = new File(FILE_PATH);

        // Buat direktori jika belum ada
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }

        // Jika file belum ada, return list kosong
        if (!file.exists()) {
            return kasirs;
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                try {
                    Kasir kasir = (Kasir) in.readObject();
                    kasirs.add(kasir);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading kasir data: " + e.getMessage());
        }

        return kasirs;
    }

    // Method untuk save data ke file
    public static void saveAll(List<Kasir> kasirs) {
        File file = new File(FILE_PATH);

        // Buat direktori jika belum ada
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            for (Kasir kasir : kasirs) {
                out.writeObject(kasir);
            }
        } catch (IOException e) {
            System.out.println("Error saving kasir data: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return String.format("Kasir[ID: %s, Username: %s]",
                id, username);
    }
}
