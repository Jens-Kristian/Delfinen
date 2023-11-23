package Delfine;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Swimmer> swimmers;
    private ArrayList<Competition> competitions;


    public Menu() {
        swimmers = new ArrayList<>();
        competitions = new ArrayList<>();
    }

    public void createSwimmer() {
        String discipline = "Null";
        System.out.println("Whats the name of the swimmer? (Full name)");
        String name = scanner.nextLine();
        System.out.println("Whats the age of the swimmer? (In years)");
        int age = Integer.parseInt(scanner.nextLine()); // Scanner bug

        System.out.println("Is the swimmer a competitive swimmer? (yes/no)");
        boolean isCompetitiveSwimmer = scanner.nextLine().equalsIgnoreCase("yes");


        for (Swimmer swimmer : swimmers) {
            if (name.equalsIgnoreCase(swimmer.getName())) {
                System.out.println("Name already taken. Please start over.");
                return;
            }
        }

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

    public void changeSwimmerAtribute(){
        String pasivActive = "null";
        String competitiveMotion = "null";
        String discipline = "null";
        System.out.println("Whats the name of the member you what to change? (9 for exit)");
        String name = scanner.nextLine();
        if (name.equals("9")) run();
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
        if (name.equals("9")) run();

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
    public void competitionOptions() {
        boolean keepRunning = true;
        while (keepRunning) {
            System.out.println("Competition Options:" +
                    "\n 1. Create Competition" +
                    "\n 2. View all competitions" +
                    "\n 3. Add Results to Competition" +
                    "\n 4. View Competition Details" +
                    "\n 5. View top 5 times for spesific disciplie" +
                    "\n 9. Return to Main Menu");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Scanner bug

            switch (choice) {
                case 1 -> createCompetition();
                case 2 -> viewAllCompetitions();
                case 3 -> addResultsToCompetition();
                case 4 -> viewCompetitionDetails();
                case 5 -> viewBestTimes();
                case 9 -> run();
                default -> {
                    System.out.println("Invalid choice, please try again.");
                    competitionOptions();
                }
            }
        }
    }
    public void createCompetition(){
        System.out.println("Whats the name off the Competition?");
        String name = scanner.nextLine();
        System.out.println("What day of the month?");
        int day = scanner.nextInt();
        System.out.println("What month (1-12)?");
        int month = scanner.nextInt();
        System.out.println("What year?");
        int year = scanner.nextInt();
        LocalDate localDate = LocalDate.of(year, month, day);
        Competition newCompetition = new Competition(name, localDate);
        competitions.add(newCompetition);
        System.out.println("New competition "+name+" is created, date:"+localDate);
    }
    public void viewAllCompetitions(){
        for (Competition competition : competitions){
            if (!competition.getNameCompetition().equalsIgnoreCase("Training")){
                System.out.println(competition);
            }
        }
    }
    public void addResultsToCompetition() {
        System.out.println("Enter the name of the competition:");
        String competitionName = scanner.nextLine();

        boolean competitionFound = false;
        Competition selectedCompetition = null;
        for (Competition competition : competitions) {
            if (competition.getNameCompetition().equalsIgnoreCase(competitionName)) {
                selectedCompetition = competition;
                competitionFound = true;
            }
        }

        if (!competitionFound) {
            System.out.println("Competition not found.");
        } else {
            System.out.println("Enter the name of the swimmer:");
            String swimmerName = scanner.nextLine();

            boolean swimmerFound = false;
            Swimmer selectedSwimmer = null;
            for (Swimmer swimmer : swimmers) {
                if (swimmer.getName().equalsIgnoreCase(swimmerName)) {
                    selectedSwimmer = swimmer;
                    swimmerFound = true;
                }
            }

            if (!swimmerFound) {
                System.out.println("Swimmer not found.");
            } else {
                System.out.println("Enter the placement of the swimmer:");
                int placement = scanner.nextInt();

                System.out.println("Enter the time of the swimmer (in minutes):");
                double time = scanner.nextDouble();
                scanner.nextLine(); // Scanner bug

                // Går ud fra disciline er svømmers main disciline
                String discipline = selectedSwimmer.getDiscipline();

                Result newResult = new Result(swimmerName, placement, time, discipline, selectedCompetition);
                selectedCompetition.addResult(newResult);
                selectedSwimmer.addResult(newResult);

                System.out.println("Result added successfully.");
            }
        }
    }

    public void viewCompetitionDetails() {
        System.out.println("Enter the name of the competition you want to view:");
        String competitionName = scanner.nextLine();

        boolean competitionFound = false;
        for (Competition competition : competitions) {
            if (competition.getNameCompetition().equalsIgnoreCase(competitionName)) {
                competitionFound = true;
                System.out.println("Competition Name: " + competition.getNameCompetition());
                System.out.println("Competition Date: " + competition.getDate());

                if (competition.getResults().isEmpty()) {
                    System.out.println("No results recorded for this competition.");
                } else {
                    System.out.println("Results:");
                    for (Result result : competition.getResults()) {
                        System.out.println("Swimmer: " + result.getSwimmerName());
                        System.out.println("Discipline: " + result.getDiscipline());
                        System.out.println("Time: " + result.getTime());
                        System.out.println("Placement: " + result.getPlacement());
                        System.out.println();
                    }
                }
            }
        }
        if (!competitionFound) {
            System.out.println("Competition not found.");
        }
    }
    public void viewBestTimes() {
        System.out.println("Select the discipline for which you want to view the best times:" +
                "\n 1. Crawl" +
                "\n 2. Breaststroke" +
                "\n 3. Butterfly" +
                "\n 4. Backcrawl" +
                "\n 5. Megley");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Scanner bug
        String selectedDiscipline = null;
        switch (choice) {
            case 1 -> selectedDiscipline="Crawl";
            case 2 -> selectedDiscipline="Breaststroke";
            case 3 -> selectedDiscipline="Butterfly";
            case 4 -> selectedDiscipline="Backcrawl";
            case 5 -> selectedDiscipline="Megley";
            default -> {
                System.out.println("Invalid choice. Returning to competition options.");
                competitionOptions();
            }
        };
        // lav et nyt array filteredResults.,. Alle resultater bliver lagt her ind
        ArrayList<Result> filteredResults = new ArrayList<>();
        for (Competition competition : competitions) {
            for (Result result : competition.getResults()) {
                if (result.getDiscipline().equalsIgnoreCase(selectedDiscipline)) {
                    filteredResults.add(result);
                }
            }
        }
        for (Swimmer swimmer : swimmers) {
            for (Result result : swimmer.getCompetitionHistory()) {
                if (result.getCompetition().getNameCompetition().equalsIgnoreCase("Training") &&
                        result.getDiscipline().equalsIgnoreCase(selectedDiscipline)) {
                    filteredResults.add(result);
                }
            }
        }
        // sotering af alle resultater så de kommer i rækkefølge efter best tid
        Collections.sort(filteredResults, Comparator.comparingDouble(Result::getTime));
        // printer de bedste 5 resultater
        int count = 0;
        for (Result result : filteredResults) {
            if (count < 5) {
                System.out.println("Name: " + result.getSwimmerName() +
                        ", Time: " + result.getTime() +
                        " minutes, Date: " + result.getCompetition().getDate() +
                        ", Competition: " + result.getCompetition().getNameCompetition());
                count++;
            }
        }

        if (count == 0) {
            System.out.println("No results found for this discipline.");
        }
    }

    public void printMenu(){
        System.out.println("What do you wish to do?" +
                "\n 1. Add new member" +
                "\n 2. Delete member" +
                "\n 3. View list off all swimmers" +
                "\n 4. Search options" +
                "\n 5. Change specifics of certain member" +
                "\n 6. Add best traning time" +
                "\n 7. Competition options"+
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
                case 5 -> changeSwimmerAtribute();
                case 6 -> newBestTrainingTime();
                case 7 -> competitionOptions();

                case 9 -> running = false;
            }
        }
    }
}
