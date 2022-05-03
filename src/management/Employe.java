package management;

public class Employe {  // Classe permettant de représenter un employé (prenom, nom, salaire, jours de travail)
    public String prenom;   //prénom de l'employé
    public String nom;      //nom de l'employé
    public int salaire;     //salaire de l'employé
    private int workingDayRow = 0;  //nombre de jours de travail consécutifs
    public void addWorkDay(){
        workingDayRow++;
    }   // fonction permettant d'incrément de 1 le nombre de jours travail consécutifs
    public void resetWorkDay(){
        workingDayRow = 0;
    }   // fonction permettant de réinitialiser le nombre de jours travail consécutifs
    public int getWorkday(){
        return workingDayRow;
    }   // fonction permettant de retourner le nombre de jours travail consécutifs
}

