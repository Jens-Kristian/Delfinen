package Delfine;

import java.util.ArrayList;

public class FileHandling {
    private static FileHandling instance = new FileHandling();
    public ArrayList<Swimmer> swimmers = new ArrayList<>();
    public ArrayList<Competition> competitions = new ArrayList<>();

    private FileHandling() {}

    public static FileHandling getInstance() {
        return instance;
    }
}
