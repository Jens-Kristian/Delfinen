package Delfine;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class CompertitionOperation{

    Scanner scanner = new Scanner(System.in);
    public ArrayList<Swimmer> swimmers;
    public ArrayList<Competition> competitions;
    public ArrayList<Result> results;
    private Menu menu;

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
    FileHandling fileHandling = new FileHandling();
    public CompertitionOperation() {
        this.results = fileHandling.results;
        this.swimmers = fileHandling.swimmers;
        this.competitions = fileHandling.competitions;
    }
    public void competitionOptions() {
        fileHandling.readSwimmersFromTxtFile();
        fileHandling.readCompetitionsFromTxtFile();
        fileHandling.readResultsFromTxtFile();
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
                case 9 -> {
                    menu.run();
                }
                default -> {
                    System.out.println("Invalid choice, please try again.");
                    competitionOptions();
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
        fileHandling.competitions.add(newCompetition);
        fileHandling.saveCompetitionsToTxtFile();
        System.out.println("New competition "+name+" is created, date:"+localDate);
        competitionOptions();
    }
    public void viewAllCompetitions(){
        for (Competition competition : fileHandling.competitions){
            if (!competition.getNameCompetition().equalsIgnoreCase("Training")){
                System.out.println(competition);
            }
        }
        competitionOptions();
    }
    public void addResultsToCompetition() {
        System.out.println("Enter the name of the competition:");
        String competitionName = scanner.nextLine();

        boolean competitionFound = false;
        Competition selectedCompetition = null;
        for (Competition competition : fileHandling.competitions) {
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
            for (Swimmer swimmer : fileHandling.swimmers) {
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
                fileHandling.results.add(newResult);
                fileHandling.saveResultsToTxtFile();
                System.out.println("Result added successfully.");
            }
        }
        competitionOptions();
    }

    public void viewCompetitionDetails() {
        System.out.println("Enter the name of the competition you want to view:");
        String competitionName = scanner.nextLine();

        boolean competitionFound = false;
        for (Competition competition : fileHandling.competitions) {
            if (competition.getNameCompetition().equalsIgnoreCase(competitionName)) {
                competitionFound = true;
                System.out.println("_______________");
                System.out.println("Competition Name: " + competition.getNameCompetition());
                System.out.println("Competition Date: " + competition.getDate());


                if (competition.getResults().isEmpty()) {
                    System.out.println("No results recorded for this competition.");
                } else {
                    System.out.println("Results:");
                    System.out.println("_______________");

                    for (Result result : competition.getResults()) {
                        System.out.println("Swimmer: " + result.getSwimmerName());
                        System.out.println("Discipline: " + result.getDiscipline());
                        System.out.println("Time: " + result.getTime());
                        System.out.println("Placement: " + result.getPlacement());
                        System.out.println("_______________");
                    }
                }
            }
        }
        if (!competitionFound) {
            System.out.println("Competition not found.");
        }
        competitionOptions();
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
        }
        // lav et nyt array filteredResults.,. Alle resultater bliver lagt her ind
        ArrayList<Result> filteredResults = new ArrayList<>();
        for (Competition competition : fileHandling.competitions) {
            for (Result result : competition.getResults()) {
                if (result.getDiscipline().equalsIgnoreCase(selectedDiscipline)) {
                    filteredResults.add(result);
                }
            }
        }
        // sotering af alle resultater så de kommer i rækkefølge efter hurtigst tid
        filteredResults.sort(Comparator.comparingDouble(Result::getTime));
        // printer de bedste 5 resultater
        int count = 0;
        System.out.println("_________");
        for (Result result : filteredResults) {
            if (count < 5) {
                System.out.println("Name: " + result.getSwimmerName() +
                        ", Time: " + result.getTime() +
                        " minutes, Date: " + result.getCompetition().getDate() +
                        ", Competition: " + result.getCompetition().getNameCompetition()+
                        "\n_________");
                count++;
            }
        }

        if (count == 0) {
            System.out.println("No results found for this discipline.");
        }
        competitionOptions();
    }

}
