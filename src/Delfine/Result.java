package Delfine;

public class Result {
    private String swimmerName;
    private int placement;
    private double time;
    private String discipline;
    private Competition competition;

    public Result(String swimmerName, int placement, double time, String discipline, Competition competition) {
        this.swimmerName = swimmerName;
        this.placement = placement;
        this.time = time;
        this.discipline = discipline;
        this.competition = competition;
    }

    public String getSwimmerName() {
        return swimmerName;
    }

    public int getPlacement() {
        return placement;
    }

    public double getTime() {
        return time;
    }

    public String getDiscipline() {
        return discipline;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setSwimmerName(String swimmerName) {
        this.swimmerName = swimmerName;
    }

    public void setPlacement(int placement) {
        this.placement = placement;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }


}
