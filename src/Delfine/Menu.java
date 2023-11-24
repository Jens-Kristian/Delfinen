package Delfine;

import java.util.Scanner;

public class Menu {

    public Scanner scanner = new Scanner(System.in);
    private CompertitionOperation compertitionOperation;
    private SwimmerOperation swimmerOperation;

    public Menu(CompertitionOperation compertitionOperation, SwimmerOperation swimmerOperation) {
        this.compertitionOperation = compertitionOperation;
        this.swimmerOperation = swimmerOperation;
    }
    public void setSwimmerOperation(SwimmerOperation swimmerOperation) {
        this.swimmerOperation = swimmerOperation;
    }
    public void setCompertitionOperation(CompertitionOperation compertitionOperation) {
        this.compertitionOperation = compertitionOperation;
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
                case 2 -> compertitionOperation.competitionOptions();
                case 9 -> System.exit(0);
            }
        }
    }

