package Delfine;
import java.time.LocalDate;
import java.util.ArrayList;

public class Swimmer {
    private String name;
    private int age;
    private Boolean membershipActive;
    private boolean isCompetitiveSwimmer;
    private ArrayList<Result> competitionHistory;

    private String discipline;

    public Swimmer(String name, int age, Boolean membershipActive, boolean isCompetitiveSwimmer, String discipline, LocalDate localDate) {
        this.name = name;
        this.age = age;
        this.membershipActive = membershipActive;
        this.isCompetitiveSwimmer = isCompetitiveSwimmer;
        this.discipline = discipline;
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

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMembershipActive(Boolean membershipActive) {
        this.membershipActive = membershipActive;
    }

    public void setCompetitiveSwimmer(boolean competitiveSwimmer) {
        isCompetitiveSwimmer = competitiveSwimmer;
    }

    public boolean isCompetitiveSwimmer() {
        return isCompetitiveSwimmer;
    }

    public ArrayList<Result> getCompetitionHistory() {
        return competitionHistory;
    }
    public String toString(){
        return "Name-'"+name+"' Age-'"+age+"' Active member-'"+membershipActive+"' Is a competitive swimmer-'"+isCompetitiveSwimmer+"' Main disipline-'"+discipline+"'"+"\n";
    }

}
