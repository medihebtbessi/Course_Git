public class Day {
    private String date;
    private Appointement app[]=new Appointement[10];
    public Day(String date){
        this.date=date;

        app[0]=new Appointement(1,"8:00 -9:00 ");
        app[1]=new Appointement(2,"9:00 -10:00 ");
        app[2]=new Appointement(3,"10:00 -11:00 ");
        app[3]=new Appointement(4,"11:00 -12:00 ");
        app[4]=new Appointement(5,"12:00 -1:00 ");
        app[5]=new Appointement(6,"1:00 -2:00 ");
        app[6]=new Appointement(7,"2:00 -3:00 ");
        app[7]=new Appointement(8,"3:00 -4:00 ");
        app[8]=new Appointement(9,"4:00 -5:00 ");
        app[9]=new Appointement(10,"5:00 -6:00 ");
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Appointement[] getApp() {
        return app;
    }

    public void setApp(Appointement[] app) {
        this.app = app;
    }
}
