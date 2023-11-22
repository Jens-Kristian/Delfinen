package Delfine;
import java.util.ArrayList;

public class Swimmer {
    private String name;
    private int age;
    private Boolean membershipActive;
    private boolean isCompetitiveSwimmer;
    private ArrayList<Result> competitionHistory;

    public Swimmer(String name, int age, Boolean membershipActive, boolean isCompetitiveSwimmer) {
        this.name = name;
        this.age = age;
        this.membershipActive = membershipActive;
        this.isCompetitiveSwimmer = isCompetitiveSwimmer;
        this.competitionHistory = new ArrayList<>();
    }

    public void addResult(Result result) {
        competitionHistory.add(result);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Boolean getMembershipActive() {
        return membershipActive;
    }

    public boolean isCompetitiveSwimmer() {
        return isCompetitiveSwimmer;
    }

    public ArrayList<Result> getCompetitionHistory() {
        return competitionHistory;
    }
    public String toString(){
        return "Name-"+name+" Age- "+age+" Active member- "+membershipActive+" Is a competitive swimmer-"+isCompetitiveSwimmer;
    }

}
