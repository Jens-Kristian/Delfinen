package Delfine;
import java.util.ArrayList;
import java.util.Date;

public class Competition {
    private String nameCompetition;
    private Date date;
    private ArrayList<Result> results;

    public Competition(String nameCompetition, Date date) {
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

    public Date getDate() {
        return date;
    }

    public ArrayList<Result> getResults() {
        return results;
    }
}
