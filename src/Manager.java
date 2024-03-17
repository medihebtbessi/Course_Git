import javax.swing.*;
import java.util.ArrayList;

public class Manager {
    static Lecturer[] lec =new Lecturer[10];
    static int sizeLec=0;
    static Day[] day=new Day[20];
    static int sizeDay=0;
    static ArrayList<Appointement> listApp=new ArrayList<>();
    public static void main(String[] args) {
        while (true){
            MainMenu();

        }

    }

    public static void MainMenu(){
        String s="***The Main Menu***\n"
                +"1. Lecturer menu\n"
                +"2. Appointment menu\n"
                +"3. Report menu\n"
                +"4. Exit the system";
        String val= JOptionPane.showInputDialog(s);
        int ch=Integer.parseInt(val);
        switch (ch){
            case 1:LecturerMenu();
                break;
            case 2:AppointmentMenu();
                break;
            case 3:ReportMenu();
                break;
            case 4:System.exit(0);
                break;
            default:JOptionPane.showMessageDialog(null,"invalid Input");

        }

    }

    public static void LecturerMenu(){

        boolean IsReturn=false;
        while (!IsReturn){
            String s="***Lecturer Menu***\n"
                    +"1. Add new Lecturer\n"
                    +"2. Delete Lecturer\n"
                    +"3. Show Lecturer\n"
                    +"4. return to main menu";
            String val= JOptionPane.showInputDialog(s);
            int ch=Integer.parseInt(val);
            switch (ch){
                case 1:AddLecturer();break;
                case 2:DeleteLecturer();break;
                case 3:ShowLecturer();
                    break;
                case 4:IsReturn=true;
                    break;
                default:JOptionPane.showMessageDialog(null,"invalid Input");
            }
        }


    }

    public static void AddLecturer(){
        int ch=0;

       do {
           String s=JOptionPane.showInputDialog("Entrer id lecture");
           int id=Integer.parseInt(s);
           if (SearchLec(id)==-1){
               String name =JOptionPane.showInputDialog("Entrer name lecturer");

               lec[sizeLec]=new Lecturer(id,name);
               sizeLec++;
           }else {
               JOptionPane.showMessageDialog(null,"Id is Exist");
           }

          ch= JOptionPane.showConfirmDialog(null, "Do you want to try again add","Confirm" ,JOptionPane.YES_NO_OPTION);

       }while (ch==0);

    }

    public static void DeleteLecturer(){
        int ch=0;

        do {
            String s=JOptionPane.showInputDialog("Entrer id lecture");
            int id=Integer.parseInt(s);
            int i=SearchLec(id);
            if (i!=-1){
                lec[i]=lec[sizeLec-1];
                sizeLec--;
                JOptionPane.showMessageDialog(null,"Delete is Done");
            }else {
                JOptionPane.showMessageDialog(null,"Id is not found");
            }

            ch= JOptionPane.showConfirmDialog(null, "Do you want to try again Delete","Confirm" ,JOptionPane.YES_NO_OPTION);

        }while (ch==0);

    }

    public static void ShowLecturer(){
        int ch=0;

        do {
            String s=JOptionPane.showInputDialog("Entrer id lecture");
            int id=Integer.parseInt(s);
            int i=SearchLec(id);
            if (i!=-1){
                s="ID lecturer: "+lec[i].getId()+"\nName Lecturer: "+lec[i].getName();
                JOptionPane.showMessageDialog(null,s);
            }else {
                JOptionPane.showMessageDialog(null,"Id is not found");
            }

            ch= JOptionPane.showConfirmDialog(null, "Do you want to try again show","Confirm" ,JOptionPane.YES_NO_OPTION);

        }while (ch==0);


    }

    public static int SearchLec(int id){
        for (int i=0;i<sizeLec;i++){
            if (lec[i].getId()==id)
                return i;
        }
        return -1;
    }



    public static void AppointmentMenu(){
        int ch=0;
        int index=-1;
        do {
            String slog=JOptionPane.showInputDialog("Entrer idLecturer to log into Appointment Menu");
            int id=Integer.parseInt(slog);
            index=SearchLec(id);
            if (index==-1){
                JOptionPane.showMessageDialog(null,"The Lecturer is not exits");
                ch= JOptionPane.showConfirmDialog(null, "Do you want to try again To Log","Confirm" ,JOptionPane.YES_NO_OPTION);
            }else {
                JOptionPane.showMessageDialog(null,"The Lecturer no :"+lec[index].getId()+"The Lecturer name :"+lec[index].getName());
                JOptionPane.showMessageDialog(null,DisplayAppLecturer(id));
                break;
            }
        }while (ch==0);


        boolean IsReturn=false;
     while (!IsReturn){
         String s="***Modification Menu***\n"
                 +"What you whant to modify ?\n"
                 +"1. Add new Appointment\n"
                 +"2. Delete Appointment\n"
                 +"3. Postpone Appointment\n"
                 +"4. Change Appointment status\n"
                 +"5. Return to main menu";
         String val= JOptionPane.showInputDialog(s);
            ch=Integer.parseInt(val);
         switch (ch){
             case 1:AddNewAppointment(lec[index]);
             break;
             case 2:DeleteAppointement(lec[index]);
                 break;
             case 3:break;
             case 4:break;
             case 5: IsReturn=true;break;
             default:JOptionPane.showMessageDialog(null,"invalid Input");
         }
     }
    }

    public static void AddNewAppointment(Lecturer lec){
        int ch=0;

        do {
            String date=JOptionPane.showInputDialog("Entrer Day Data [Use this format (dd-mm-yyyy)]");
            int index=SearchDate(date);
            Day d=null;
            if (index==-1){
                d=new Day(date);


            }else {
                d=day[index];

            }


            ////////////
            String s="The time slots for that day:\n";
            for (int i=0;i<10;i++){
                s+=d.getApp()[i].getSrn()+"   "+d.getApp()[i].getTime()+"   "+(d.getApp()[i].getIsAvailable()? "available" : "Not Available")+"   "+d.getApp()[i].getLec().getId()+"-"+d.getApp()[i].getLec().getName();
                s+="\n";
            }
            s+="Entrer the time slot No : ";
            String sCh =JOptionPane.showInputDialog(null,s);
            int cho=Integer.parseInt(sCh);

            if (cho>=1 && cho<=10){
                if (lec.getId()==d.getApp()[cho-1].getLec().getId()||d.getApp()[cho-1].getLec().getId()>=1){
                    JOptionPane.showMessageDialog(null,"this appointement is not available");
                }else {
                    d.getApp()[cho-1].setLec(lec);
                    d.getApp()[cho-1].setAvailable(false);
                    if (index==-1){
                        day[sizeDay]=d;
                        sizeDay++;
                    }
                    JOptionPane.showMessageDialog(null,"Appointement Add doen");
                }
            }

            ch= JOptionPane.showConfirmDialog(null, "Do you want to try again to Add New Appointment","Confirm" ,JOptionPane.YES_NO_OPTION);

        }while (ch==0);
    }



    public static void DeleteAppointement(Lecturer lec){
        int ch=0;
        do {
            String s=JOptionPane.showInputDialog(DisplayAppLecturer(lec.getId())+"Entrer appointement SRN ");
            int och=Integer.parseInt(s);
            if (!listApp.isEmpty()){
                listApp.get(och-1).setAvailable(true);
                listApp.get(och-1).setLec(new Lecturer(0,"----"));
                listApp.get(och-1).setStatus("Pending");
                JOptionPane.showMessageDialog(null,"Delete done");
            }
            ch=JOptionPane.showConfirmDialog(null,"Do you want to Delete Appointement ","Confirm ",JOptionPane.YES_NO_OPTION);

        }while (ch==0);
    }




















    public static int SearchDate(String date){
        for (int i=0;i<sizeDay;i++){
            if (date.equals(day[i].getDate())){
                return i;
            }
        }

        return -1;
    }

    public static String DisplayAppLecturer(int id){
        String s="SRN\t\t  Day/Time \t\t Status"+"\n";
        int count=1;
        for (int i=0;i<sizeDay;i++){
            for (int j=0;j<10;j++){
                if (id==day[i].getApp()[j].getLec().getId()){
                    listApp.add(day[i].getApp()[j]);
                    s+=count+"\t\t  "+day[i].getDate()+"/"+day[i].getApp()[j].getTime()+"\t\t"+day[i].getApp()[j].getStatus()+"\n";
                    count++;
                }
            }

        }
        return s;
    }

    public static void ReportMenu(){
        boolean IsReturn=false;
        while (!IsReturn){
            String s="***Report Menu***\n"
                    +"1. Display all appointments for a specified day\n"
                    +"2. Display appointment for a specified lecturer\n"
                    +"3. return to main menu";

            String val= JOptionPane.showInputDialog(s);
            int ch=Integer.parseInt(val);
            switch (ch){
                case 1:break;
                case 2:break;
                case 3: IsReturn=true;
                    break;
                default:JOptionPane.showMessageDialog(null,"invalid Input");
            }
        }
    }
}
