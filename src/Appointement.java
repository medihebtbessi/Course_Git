public class Appointement {
    private int srn;
    private boolean isAvailable;
    private Lecturer lec;
    private String status;
    private String time;

    public Appointement(){}

    public Appointement(int srn, String time) {
        this.srn = srn;
        this.time = time;
        isAvailable=true;
        status="Pending";
        lec=new Lecturer(0,"----");
    }

    public Appointement(int srn, boolean isAvailable, Lecturer lec, String status, String time) {
        this.srn = srn;
        this.isAvailable = isAvailable;
        this.lec = lec;
        this.status = status;
        this.time = time;
    }

    public int getSrn() {
        return srn;
    }

    public void setSrn(int srn) {
        this.srn = srn;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Lecturer getLec() {
        return lec;
    }

    public void setLec(Lecturer lec) {
        this.lec = lec;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
