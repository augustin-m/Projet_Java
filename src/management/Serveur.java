package management;
import java.util.Vector;
public class Serveur extends Employe {  // Classe (fille) "Serveur" dépendant de la classe "Employe" (mère)
    private final Vector table = new Vector();  // Vecteur pour enregistrer les tables
    public Serveur(String prenom, String nom, int salaire) {
        this.prenom = prenom;   // prenom du serveur
        this.nom = nom;         // nom du serveur
        this.salaire = salaire; // salaire du serveur
    }
    public void ajoutTable(int numDeTable){
        table.add(numDeTable);
    }   // fonction permetant d'ajouter une table via son numéro
    public void supprTable(int numDeTable){
        table.removeElement(numDeTable);
    }   // fonction permetant de supprimer une table via son numéro
}