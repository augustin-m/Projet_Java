package management;

public class Employe {
    public String prenom;//prénom
    public String nom;//nom
    public int salaire;//salaire
    private int workingDayRow = 0;
    public void addWorkDay(){
        workingDayRow++;
    }
    public void resetWorkDay(){
        workingDayRow = 0;
    }
    public int getWorkday(){
        return workingDayRow;
    }
}

