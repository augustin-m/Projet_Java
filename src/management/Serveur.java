package management;
import java.util.Vector;
public class Serveur extends Employe {
    private final Vector table = new Vector();
    public Serveur(String prenom, String nom, int salaire) {
        this.prenom = prenom;
        this.nom = nom;
        this.salaire = salaire;
    }
    public void ajoutTable(int numDeTable){
        table.add(numDeTable);
    }
    public void supprTable(int numDeTable){
        table.removeElement(numDeTable);
    }
}