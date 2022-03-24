package management;

public class Employe {
    public String name;//prénom
    public String surname;//nom
    public int salary;//salaire
    private int workingDayRow = 0;
    public void addWorkDay(){
        workingDayRow++;
    }
    public void resetWorkDay(){
        workingDayRow = 0;
    }
}

