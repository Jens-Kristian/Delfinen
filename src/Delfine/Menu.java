package Delfine;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Swimmer> swimmers;

    public Menu() {
        swimmers = new ArrayList<>();
    }

    public void createSwimmer() {
        System.out.println("Whats the name of the swimmer? (Full name)");
        String name = scanner.nextLine();
        System.out.println("Whats the age of the swimmer? (In years)");
        int age = Integer.parseInt(scanner.nextLine()); // Scanner bug >:(

        System.out.println("Is the swimmer a competitive swimmer? (yes/no)");
        boolean isCompetitiveSwimmer = scanner.nextLine().equalsIgnoreCase("yes");


        for (Swimmer swimmer : swimmers) {
            if (name.equalsIgnoreCase(swimmer.getName())) {
                System.out.println("Name already taken. Please start over.");
                return;
            }
        }
        //Går ud fra alle nye svømmere ikke starter med at være passive
        Swimmer newSwimmer = new Swimmer(name, age, true, isCompetitiveSwimmer);
        swimmers.add(newSwimmer);
        System.out.println("Swimmer added successfully.");
    }

    public void fullMemberList(){
        for (Swimmer swimmer : swimmers){
            System.out.println(swimmer);
        }
    }

    public void printMenu(){
        System.out.println("What do you wish to do?" +
                "\n 1. Add new member" +
                "\n 2. Full member list" +
                "\n 9. Exit");
    }
    public void run() {
        boolean running = true;
        while (running) {
            printMenu();
            int choose = scanner.nextInt();
            scanner.nextLine();

            switch (choose) {
                case 1 -> createSwimmer();
                case 2 -> fullMemberList();
                case 9 -> running = false;
            }
        }
    }
}
