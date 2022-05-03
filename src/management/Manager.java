package management;

public class Manager extends Employe {  // classe permettant de représenter le manager (nom, prénom, salaire)
    public Manager(String prenom, String nom, int salaire) {
        this.prenom = prenom;   // prenom du manager
        this.nom = nom;         // nom du manager
        this.salaire = salaire; // salaire du manager
    }
}
