public class College{
    private String college;
    private boolean isPrivate;
    private int application;
    private int acceptance;
    private int enroll;
    private double inStatetuition;
    private double outStatetuition;



    public College(String col, double intuit){
        college = col;
        inStatetuition = intuit;
    }

    public String getCollege()
    { return college; }

    public double getTuition()
    { return inStatetuition; }

    public String toString()
    { return college+" tuition is $"+ inStatetuition; }          
}