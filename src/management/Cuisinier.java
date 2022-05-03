package management;

public class Cuisinier extends Employe {    // Classe (fille) "Cuisinier" dépendant de la classe "Employe" (mère)
    public Cuisinier(String prenom, String nom, int salaire) {
        this.prenom = prenom;   // prénom du cuisinier
        this.nom = nom;         // nom du cuisinier
        this.salaire = salaire; // salaire du cuisinier
    }
}
