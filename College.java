public class College {
    private String name;
    private String state;
    private String control;
    private String inStateTuition;
    private String outStateTuition;
    private String satVR25, satVR75, satMT25, satMT75;
    private String actCM25, actCM75;
    private String acceptanceRate;
    private String studentBodySize;

    public College(String name, String state, String control,
                   String inStateTuition, String outStateTuition,
                   String satVR25, String satVR75,
                   String satMT25, String satMT75,
                   String actCM25, String actCM75,
                   String acceptanceRate, String studentBodySize) {
        this.name = name;
        this.state = state;
        this.control = control;
        this.inStateTuition = inStateTuition;
        this.outStateTuition = outStateTuition;
        this.satVR25 = satVR25;
        this.satVR75 = satVR75;
        this.satMT25 = satMT25;
        this.satMT75 = satMT75;
        this.actCM25 = actCM25;
        this.actCM75 = actCM75;
        this.acceptanceRate = acceptanceRate;
        this.studentBodySize = studentBodySize;
    }

    // Add getters or toString() if needed
}
