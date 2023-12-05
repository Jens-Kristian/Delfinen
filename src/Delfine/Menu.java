package Delfine;

import java.util.Scanner;

public class Menu {

    public Scanner scanner = new Scanner(System.in);
    public CompetitionOperation competitionOperation;
    public SwimmerOperation swimmerOperation;
    public Econ econ;

    public Menu(CompetitionOperation competitionOperation, SwimmerOperation swimmerOperation, Econ econ) {
        this.competitionOperation = competitionOperation;
        this.swimmerOperation = swimmerOperation;
        this.econ = econ;
    }

    public void printMenu(){
        System.out.println("What do you wish to do?" +
                "\n 1. Swimmer options" +
                "\n 2. Competition options"+
                "\n 3. Econ"+
                "\n 9. Exit");
    }

    public void run() {

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

