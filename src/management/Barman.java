package management;

public class Barman extends Employe {   // Classe (fille) "Barman" dépendant de la classe "Employe" (mère)
    public Barman(String prenom, String nom, int salaire) {
        this.prenom = prenom;   // prénom du barman
        this.nom = nom;         // nom du barman
        this.salaire = salaire; // salaire du barman
    }
}
