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

    public String getControl() {
        return control;
    }

    public void setControl(String control) {
        this.control = control;
    }

    public String getInStateTuition() {
        return inStateTuition;
    }

    public void setInStateTuition(String inStateTuition) {
        this.inStateTuition = inStateTuition;
    }

    public String getOutStateTuition() {
        return outStateTuition;
    }

    public void setOutStateTuition(String outStateTuition) {
        this.outStateTuition = outStateTuition;
    }

    public String getSatVR25() {
        return satVR25;
    }

    public String getSatVR75() {
        return satVR75;
    }

    public String getSatMT25() {
        return satMT25;
    }

    public String getSatMT75() {
        return satMT75;
    }

    public void setSatVR25(String satVR25) {
        this.satVR25 = satVR25;
    }

    public void setSatVR75(String satVR75) {
        this.satVR75 = satVR75;
    }

    public void setSatMT25(String satMT25) {
        this.satMT25 = satMT25;
    }

    public void setSatMT75(String satMT75) {
        this.satMT75 = satMT75;
    }

    public String getActCM25() {
        return actCM25;
    }

    public String getActCM75() {
        return actCM75;
    }

    public String getAcceptanceRate() {
        return acceptanceRate;
    }

    public void setAcceptanceRate(String acceptanceRate) {
        this.acceptanceRate = acceptanceRate;
    }

    public void setActCM25(String actCM25) {
        this.actCM25 = actCM25;
    }

    public void setActCM75(String actCM75) {
        this.actCM75 = actCM75;
    }

    public String getStudentBodySize() {
        return studentBodySize;
    }

    public void setStudentBodySize(String studentBodySize) {
        this.studentBodySize = studentBodySize;
    }
}
