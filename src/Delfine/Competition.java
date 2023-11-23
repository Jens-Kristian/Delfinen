package Delfine;
import java.time.LocalDate;
import java.util.ArrayList;


public class Competition {
    private String nameCompetition;
    private LocalDate date;
    private ArrayList<Result> results;

    public Competition(String nameCompetition, LocalDate date) {
        this.nameCompetition = nameCompetition;
        this.date = date;
        this.results = new ArrayList<>();
    }

    public void addResult(Result result) {
        results.add(result);
    }

    public String getNameCompetition() {
        return nameCompetition;
    }

    public LocalDate getDate() {
        return date;
    }

    public ArrayList<Result> getResults() {
        return results;
    }

    public String toString(){
        return nameCompetition + date + results;
    }
}
