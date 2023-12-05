package Delfine;

import java.util.ArrayList;
import java.util.Scanner;

public class Econ {
    Scanner scanner = new Scanner(System.in);
    public ArrayList<Swimmer> swimmers;
    public ArrayList<Competition> competitions;
    public ArrayList<Result> results;
    private Menu menu;

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
    FileHandling fileHandling = new FileHandling();
    public Econ() {
        this.results = fileHandling.results;
        this.swimmers = fileHandling.swimmers;
        this.competitions = fileHandling.competitions;
    }
    public void econOptions() {
        fileHandling.readSwimmersFromTxtFile();
        fileHandling.readCompetitionsFromTxtFile();
        fileHandling.readResultsFromTxtFile();
        System.out.println("What do you wish to do?" +
                "\n 1. View total estimated earnings" +
                "\n 9. Main Menu");
        int choose = scanner.nextInt();
        scanner.nextLine();
        switch (choose) {
            case 1 -> totalEarnings();

            case 9 -> {
                menu.run();
            }
        }
    }

    public void totalEarnings() {
        int activeMembers = 0;
        int passivMembers = 0;
        int juniorMembers = 0;
        int seniorMembers = 0;
        int superSeniorMembers = 0;

        for (Swimmer swimmer : swimmers) {

            if (swimmer.getMembershipActive()) {
                activeMembers++;
                if (swimmer.getAge() < 18) {
                    juniorMembers++;
                } else if (swimmer.getAge() >= 18 && swimmer.getAge() < 60) {
                    seniorMembers++;
                } else if (swimmer.getAge() >= 60) {
                    superSeniorMembers++;
                }
            } else {
                passivMembers++;
            }
        }

        int juniorMembersPrice = juniorMembers * 1000;
        int seniorMembersPrice = seniorMembers * 1600;
        int superSeniorMembersPrice = superSeniorMembers * 1200;
        int passiveMembersPrice = passivMembers * 500;
        int totalEarnings = juniorMembersPrice + seniorMembersPrice + superSeniorMembersPrice + passiveMembersPrice;

        System.out.println("The yearly Earnings for member ships are:" +
                "\n With a total off " + swimmers.size() + " members" +
                "\n Under 18 swimmers count=[" + juniorMembers + "] : " + juniorMembersPrice + "kr" +
                "\n Over 18 under 60 swimmers count=[" + seniorMembers + "] : " + seniorMembersPrice + "kr" +
                "\n Over 60 swimmers count=[" + superSeniorMembers + "] : " + superSeniorMembersPrice + "kr" +
                "\n Passive Members =[" + passivMembers + "] : " + passiveMembersPrice + "kr" +
                "\n Total = " + totalEarnings + "kr");
        econOptions();
    }
}