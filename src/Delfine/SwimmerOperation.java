package Delfine;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class SwimmerOperation {
    Scanner scanner = new Scanner(System.in);
    public ArrayList<Swimmer> swimmers;
    public ArrayList<Competition> competitions;
    private Menu menu;

    public SwimmerOperation(Menu menu) {
        this.menu = menu;
    }
    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public SwimmerOperation() {
        swimmers = new ArrayList<>();
        competitions = new ArrayList<>();
    }
    public void swimmerOptions(){
            System.out.println("What do you wish to do?" +
                    "\n 1. Add new member" +
                    "\n 2. Delete member" +
                    "\n 3. View list off all swimmers" +
                    "\n 4. Search options" +
                    "\n 5. Change specifics of certain member" +
                    "\n 6. Add best traning time" +
                    "\n 9. Main Menu");
        int choose = scanner.nextInt();
        scanner.nextLine();
        switch (choose) {
            case 1 -> createSwimmer();
            case 2 -> deleteSwimmer();
            case 3 -> fullMemberList();
            case 4 -> search();
            case 5 -> changeSwimmerAtribute();
            case 6 -> newBestTrainingTime();
            case 9 -> menu.run();
        }
    }

    public void createSwimmer() {
        String discipline = "Null";
        String name;
        System.out.println("Whats the name of the swimmer? (Full name)");
        name = scanner.nextLine();

        for (Swimmer swimmer : swimmers) {
            if (name.equalsIgnoreCase(swimmer.getName())) {
                System.out.println("Name already taken. Please start over.");
                menu.run();
            }
        }
        System.out.println("Whats the age of the swimmer? (In years)");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Is the swimmer a competitive swimmer? (yes/no)");
        boolean isCompetitiveSwimmer = scanner.nextLine().equalsIgnoreCase("yes");

        System.out.println("What is the swimmers main discipline?" +
                "\n 1. Crawl" +
                "\n 2. Breaststroke" +
                "\n 3. Butterfly" +
                "\n 4. Backcrawl" +
                "\n 5. Megley");
        int choose = scanner.nextInt();
        switch (choose){
            case 1 -> discipline = "Crawl";
            case 2 -> discipline = "Breaststroke";
            case 3 -> discipline = "Butterfly";
            case 4 -> discipline = "Backcrawl";
            case 5 -> discipline = "Megley";
        }

        //Går ud fra alle nye svømmere ikke starter med at være passive
        Swimmer newSwimmer = new Swimmer(name, age, true, isCompetitiveSwimmer, discipline, LocalDate.now());
        swimmers.add(newSwimmer);
        System.out.println("Swimmer added successfully.");
    }

    public void deleteSwimmer(){
        System.out.println("Whats the name off the swimmer ('9' to exit)");
        String name = scanner.nextLine();
        if (name.equals("9")) swimmerOptions();
        for (Swimmer swimmer : swimmers){
            if (name.equalsIgnoreCase(swimmer.getName())){
                System.out.println(swimmer);
            }else{
                System.out.println("Swimmer not found, try again");
                deleteSwimmer();
            }
        }swimmerOptions();
    }

    public void fullMemberList() {
        System.out.println("_______________");
        for (Swimmer swimmer : swimmers) {
            System.out.println("Name: " + swimmer.getName());
            System.out.println("Age: " + swimmer.getAge());
            System.out.println("Active Member: " + swimmer.getMembershipActive());
            System.out.println("Competitive Swimmer: " + swimmer.isCompetitiveSwimmer());
            System.out.println("Main Discipline: " + swimmer.getDiscipline());

            Result bestTrainingResult = findBestTrainingTime(swimmer);
            if (bestTrainingResult != null) {
                System.out.println("Best Training Time: " + bestTrainingResult.getTime() + " minutes in " + bestTrainingResult.getDiscipline());
            } else {
                System.out.println("No training time recorded");
            }
            System.out.println("_______________");
        }
    }

    public Result findBestTrainingTime(Swimmer swimmer) {
        Result bestTrainingResult = null;
        for (Result result : swimmer.getCompetitionHistory()) {
            if (result.getCompetition().getNameCompetition().equalsIgnoreCase("Training") &&
                    (bestTrainingResult == null || result.getTime() < bestTrainingResult.getTime())) {
                bestTrainingResult = result;
            }
        }
        return bestTrainingResult;
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
        scanner.nextLine(); //scanner bug
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
                }swimmerOptions();
            }
            case 2->{
                System.out.println("Whats the age you want to search?");
                boolean swimmerFound = false;
                int age = scanner.nextInt();
                for (Swimmer swimmer : swimmers){
                    if (age==swimmer.getAge()){
                        System.out.println(swimmer);
                        swimmerFound = true;
                    }
                }
                if (!swimmerFound) System.out.println("Swimmer by that name not found in system");
                swimmerOptions();
            }
            case 3->{
                for (Swimmer swimmer : swimmers){
                    if (swimmer.isCompetitiveSwimmer()){
                        System.out.println(swimmer);
                    }else{
                        System.out.println("No competitive swimmers found, try again");
                        search();
                    }
                }swimmerOptions();
            }
            case 4->{
                for (Swimmer swimmer : swimmers){
                    if (swimmer.getMembershipActive()){
                        System.out.println(swimmer);
                    }else {
                        System.out.println("No active member found, try again");
                        search();
                    }
                }swimmerOptions();
            }
            case 5->{
                for (Swimmer swimmer : swimmers){
                    if (!swimmer.getMembershipActive()){
                        System.out.println(swimmer);
                    }else {
                        System.out.println("No inactive member found, try again");
                        search();
                    }
                }swimmerOptions();
            }
        }
    }

    public void changeSwimmerAtribute(){
        String pasivActive = "null";
        String competitiveMotion = "null";
        String discipline = "null";
        System.out.println("Whats the name of the member you what to change? (9 for exit)");
        String name = scanner.nextLine();
        if (name.equals("9")) swimmerOptions();
        for (Swimmer swimmer : swimmers){
            if (name.equalsIgnoreCase(swimmer.getName())){
                System.out.println(swimmer);
                System.out.println("What attribute do you what to change?" +
                        "\n 1. age" +
                        "\n 2. membership Active/passiv" +
                        "\n 3. Competitive Swimmer / Motion Swimmer" +
                        "\n 4. Main discipline");
                int choose = scanner.nextInt();
                switch (choose){
                    case 1 -> {
                        System.out.println("What is the new age?");
                        int age = scanner.nextInt();
                        swimmer.setAge(age);
                        System.out.println(swimmer.getName()+" updated age to "+age);
                    }
                    case 2 -> {
                        boolean activePasiv = swimmer.getMembershipActive();
                        if (activePasiv){
                            activePasiv = false;
                            pasivActive = "pasiv";
                        } else{
                            activePasiv = true;
                            pasivActive = "active";
                        }
                        System.out.println(swimmer.getName()+" is now "+pasivActive);
                    }
                    case 3 -> {
                        boolean competitive = swimmer.isCompetitiveSwimmer();
                        if (competitive){
                            competitive = false;
                            competitiveMotion = "Motion";
                        }else {
                            competitive = true;
                            competitiveMotion = "competitive";
                        }
                        System.out.println(swimmer.getName()+" is now "+competitiveMotion+" swimmer");
                    }
                    case 4 -> {
                        System.out.println("What is the swimmers main discipline?" +
                                "\n 1. Crawl" +
                                "\n 2. Breaststroke" +
                                "\n 3. Butterfly" +
                                "\n 4. Backcrawl" +
                                "\n 5. Megley");
                        int choose2 = scanner.nextInt();
                        switch (choose2){
                            case 1 -> discipline = "Crawl";
                            case 2 -> discipline = "Breaststroke";
                            case 3 -> discipline = "Butterfly";
                            case 4 -> discipline = "Backcrawl";
                            case 5 -> discipline = "Megley";
                        }
                        swimmer.setDiscipline(discipline);
                        System.out.println(swimmer.getName()+" new main discipline is "+discipline);
                    }

                }
            }else{
                System.out.println("Swimmer not found, try again");
                changeSwimmerAtribute();
            }
        }
    }

    public void newBestTrainingTime() {
        System.out.println("What is the name of the swimmer? (9 for exit)");
        String name = scanner.nextLine();
        if (name.equals("9")) swimmerOptions();

        Swimmer selectedSwimmer = null;
        for (Swimmer swimmer : swimmers) {
            if (name.equalsIgnoreCase(swimmer.getName())) {
                selectedSwimmer = swimmer;
            }
        }

        if (selectedSwimmer == null) {
            System.out.println("Swimmer not found, try again.");
            newBestTrainingTime();
        }

        System.out.println("What discipline was the best time recorded in?" +
                "\n 1. Crawl" +
                "\n 2. Breaststroke" +
                "\n 3. Butterfly" +
                "\n 4. Backcrawl" +
                "\n 5. Megley");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Scanner bug
        String discipline = null;
        switch (choice) {
            case 1 -> discipline = "Crawl";
            case 2 -> discipline = "Breaststroke";
            case 3 -> discipline = "Butterfly";
            case 4 -> discipline = "Backcrawl";
            case 5 -> discipline = "Megley";
        };

        System.out.println("What was the time? (in minutes)");
        double time = scanner.nextDouble();
        scanner.nextLine(); // Scanner bug

        System.out.println("Enter the date for the best time:");
        System.out.println("Day of the month:");
        int day = scanner.nextInt();
        System.out.println("Month (1-12):");
        int month = scanner.nextInt();
        System.out.println("Year:");
        int year = scanner.nextInt();
        scanner.nextLine(); // Scanner bug

        LocalDate localDate = LocalDate.of(year, month, day);
        Competition newCompetition = new Competition("Training", localDate);
        competitions.add(newCompetition);
        Result newResult = new Result(selectedSwimmer.getName(), 0, time, discipline, newCompetition);
        selectedSwimmer.addResult(newResult);

        System.out.println("New best training time recorded for " + selectedSwimmer.getName());
    }

}
