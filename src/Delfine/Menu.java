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

    public void deleteSwimmer(){
        System.out.println("Whats the name off the swimmer ('9' to exit)");
        String name = scanner.nextLine();
        if (name.equals("9")) run();
        for (Swimmer swimmer : swimmers){
            if (name.equalsIgnoreCase(swimmer.getName())){
                System.out.println(swimmer);
            }else{
                System.out.println("Swimmer not found, try again");
                deleteSwimmer();
            }
        }run();
    }
    public void search(){
        int chosenNumber;
        System.out.println("What do you want to search by?" +
                "\n 1. Name" +
                "\n 2. Age" +
                "\n 3. See all Competitive swimmers" +
                "\n 4. See all Active members" +
                "\n 5. See all Passive members" +
                "\n 9. Exit");
        chosenNumber = scanner.nextInt();
        switch (chosenNumber){
            case 1->{
                System.out.println("Whats the name you want to search?");
                String name = scanner.nextLine();
                for (Swimmer swimmer : swimmers){
                    if (name.equalsIgnoreCase(swimmer.getName())){
                        System.out.println(swimmer);
                    }else{
                        System.out.println("Name not found in system, try again");
                        search();
                    }
                }run();
            }
            case 2->{
                System.out.println("Whats the age you want to search?");
                int age = scanner.nextInt();
                for (Swimmer swimmer : swimmers){
                    if (age==swimmer.getAge()){
                        System.out.println(swimmer);
                    }else{
                        System.out.println("Nothing found, try again");
                        search();
                    }
                }run();
            }
            case 3->{
                for (Swimmer swimmer : swimmers){
                    if (swimmer.isCompetitiveSwimmer()){
                        System.out.println(swimmer);
                    }else{
                        System.out.println("No competitive swimmers found, try again");
                        search();
                    }
                }run();
            }
            case 4->{
                for (Swimmer swimmer : swimmers){
                    if (swimmer.getMembershipActive()){
                        System.out.println(swimmer);
                    }else {
                        System.out.println("No active member found, try again");
                        search();
                    }
                }run();
            }
            case 5->{
                for (Swimmer swimmer : swimmers){
                    if (!swimmer.getMembershipActive()){
                        System.out.println(swimmer);
                    }else {
                        System.out.println("No inactive member found, try again");
                        search();
                    }
                }run();
            }
        }
    }

    public void fullMemberList(){
        for (Swimmer swimmer : swimmers){
            System.out.println(swimmer);
        }
    }

    public void printMenu(){
        System.out.println("What do you wish to do?" +
                "\n 1. Add new member" +
                "\n 2. Delete member" +
                "\n 3. View list off all swimmers" +
                "\n 4. Search options" +
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
                case 2 -> deleteSwimmer();
                case 3 -> fullMemberList();
                case 4 -> search();

                case 9 -> running = false;
            }
        }
    }
}
