package Delfine;
import java.time.LocalDate;
import java.util.ArrayList;

public class Swimmer {
    public  String name;
    public int age;
    public Boolean membershipActive;
    public boolean isCompetitiveSwimmer;
    public ArrayList<Result> competitionHistory;
    public String discipline;
    public LocalDate localDate;


    public Swimmer(String name, int age, Boolean membershipActive, boolean isCompetitiveSwimmer, String discipline, LocalDate localDate) {
        this.name = name;
        this.age = age;
        this.membershipActive = membershipActive;
        this.isCompetitiveSwimmer = isCompetitiveSwimmer;
        this.discipline = discipline;
        this.localDate = localDate;
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

    public boolean isCompetitiveSwimmer() {
        return isCompetitiveSwimmer;
    }

    public ArrayList<Result> getCompetitionHistory(){return competitionHistory;}

    public String toString(){
        return name+","+age+","+membershipActive+","+isCompetitiveSwimmer+","+discipline+","+localDate;
    }

}
