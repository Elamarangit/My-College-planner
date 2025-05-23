public class College{
    private String college;
    private String isPrivate;
    private String application;
    private String acceptance;
    private String enroll;
    private String top10percent;
    private String top25percent;
    private String Fundergrads;
    private String Pundergrads;
    private String outState;
    private String roomBoard;
    private String books;
    private String personel; 
    private String Phds;
    private String terminal;
    private String sfratio;
    private String percentage_alumni;
    private String expemditure;
    private String gradution;


    // "","Private","Apps","Accept","Enroll","Top10perc","Top25perc","F.Undergrad","P.Undergrad","Outstate","Room.Board","Books","Personal","PhD","Terminal","S.F.Ratio","perc.alumni","Expend","Grad.Rate"
    public College(){}

    public College(String Fundergrads, String Phds, String Pundergrads, String acceptance, String application, String books, String college, String enroll, String expemditure, String gradution, String isPrivate, String outState, String percentage_alumni, String personel, String roomBoard, String sfratio, String terminal, String top10percent, String top25percent) {
        this.Fundergrads = Fundergrads;
        this.Phds = Phds;
        this.Pundergrads = Pundergrads;
        this.acceptance = acceptance;
        this.application = application;
        this.books = books;
        this.college = college;
        this.enroll = enroll;
        this.expemditure = expemditure;
        this.gradution = gradution;
        this.isPrivate = isPrivate;
        this.outState = outState;
        this.percentage_alumni = percentage_alumni;
        this.personel = personel;
        this.roomBoard = roomBoard;
        this.sfratio = sfratio;
        this.terminal = terminal;
        this.top10percent = top10percent;
        this.top25percent = top25percent;
    }

    



}