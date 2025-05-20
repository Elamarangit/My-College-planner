public class College{
    private String college;
    private boolean isPrivate;
    private int application;
    private int acceptance;
    private int enroll;
    private double inStatetuition;
    private double outStatetuition;



    public College(String col, boolean priv, int apps, int accs, int enrolled, double intuit){
        college = col;
        isPrivate = priv;
        application = apps;
        acceptance = accs;
        enroll = enrolled;
        inStatetuition = intuit;
        outStatetuition = inStatetuition*1.65;
    }

    public String getCollege()
    { return college; }

    public boolean getPrivateStatus()
    { return isPrivate; }

    public int getApplications()
    { return application; }

    public int getAcceptance()
    { return acceptance; }  

    public int getEnroll()
    { return enroll; }

    public double getInTuition()
    { return inStatetuition; }

    public double getOutTuition()
    { return outStatetuition; }  
}