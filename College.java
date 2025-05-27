public class College {
    private String name;
    private String state;
    private double acceptanceRate;
    private int satScore;
    private int actScore;
    private double gpa;

    public College(String name, String state, double acceptanceRate, int satScore, int actScore, double gpa) {
        this.name = name;
        this.state = state;
        this.acceptanceRate = acceptanceRate;
        this.satScore = satScore;
        this.actScore = actScore;
        this.gpa = gpa;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getAcceptanceRate() {
        return acceptanceRate;
    }

    public void setAcceptanceRate(double acceptanceRate) {
        this.acceptanceRate = acceptanceRate;
    }

    public int getSatScore() {
        return satScore;
    }

    public void setSatScore(int satScore) {
        this.satScore = satScore;
    }

    public int getActScore() {
        return actScore;
    }

    public void setActScore(int actScore) {
        this.actScore = actScore;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "College{" +
                "name='" + name + '\'' +
                ", state='" + state + '\'' +
                ", acceptanceRate=" + acceptanceRate +
                ", satScore=" + satScore +
                ", actScore=" + actScore +
                ", gpa=" + gpa +
                '}';
    }
}