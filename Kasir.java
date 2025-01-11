package TUBES_ALGORITMA_PEMOGRAMAN_II;

import java.io.*;
import java.util.*;

public class Kasir implements Serializable {

    private static final String filePath = "C:\\Data\\kasir.dat";
    private static final long serialVersionUID = 1L;

    private String id;
    private String username;
    private String password;

    public Kasir(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public static List<Kasir> loadAll() {
        List<Kasir> kasirs = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
            while (true) {
                kasirs.add((Kasir) in.readObject());
            }
        } catch (EOFException e) {
            // End of file reached
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return kasirs;
    }

    public static void saveAll(List<Kasir> kasirs) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
            for (Kasir k : kasirs) {
                out.writeObject(k);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean authenticate(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Username: " + username;
    }
}
