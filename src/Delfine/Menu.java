package Delfine;

import java.util.Scanner;

public class Menu {

Scanner scanner = new Scanner(System.in);


    public void printMenu(){
        System.out.println("What do you wish to do?" +
                "\n 1. Swimmer options" +
                "\n 2. Competition options"+
                "\n 3. Econ"+
                "\n 9. Exit");
    }

    public void run() {
        CompetitionOperation competitionOperation = new CompetitionOperation();
        SwimmerOperation swimmerOperation = new SwimmerOperation();
        Econ econ = new Econ();
            printMenu();
            int choose = scanner.nextInt();
            scanner.nextLine();

            switch (choose) {
                case 1 -> swimmerOperation.swimmerOptions();
                case 2 -> competitionOperation.competitionOptions();
                case 3 -> econ.econOptions();
                case 9 -> System.exit(0);
            }
        }
    }

