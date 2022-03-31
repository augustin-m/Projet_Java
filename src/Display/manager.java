package Display;

import management.*;

import java.util.Vector;
import java.util.Locale;
import java.util.Scanner;

public class manager {
    public int page;
    private Vector<Employe> employes = new Vector<Employe>();
    private void ajoutEmploye(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pour commencer renseignez le nom de l'employé");
        String nom = scanner.next();
        System.out.println("Puis le prénom de l'employé");
        String prenom = scanner.next();
        System.out.println("Puis le salaire de l'employé");
        int salaire = Integer.parseInt(scanner.next());
        System.out.println("Puis le métier de l'employé");
        String metier = scanner.next().toUpperCase(Locale.ROOT);
        if(metier.equals("BARMAN")){
            Barman nouveauBarman = new Barman(nom, prenom, salaire);
            employes.add(nouveauBarman);
        }else if(metier.equals("CUISINIER")){
            Cuisinier nouveauCuisinier = new Cuisinier(nom, prenom, salaire);
            employes.add(nouveauCuisinier);
        }else if(metier.equals("SERVEUR")){
            Serveur nouveauServeur = new Serveur(nom, prenom, salaire);
            employes.add(nouveauServeur);
        }else if(metier.equals("MANAGER")){
            Manager nouveauManager = new Manager(nom, prenom, salaire);
            employes.add(nouveauManager);
        }
    }
    public void print(){
        System.out.println("Que désirez vous faire ?");
        System.out.println("1- Composer une équipe");
        System.out.println("2- Faire les stocks");
        System.out.println("3- Performances du service");
        System.out.println("4- Ajouter un employé");
        System.out.println("5- Quitter le menu");
        Scanner scanner = new Scanner(System.in);
        int choixEcran = Integer.parseInt(scanner.next());
        this.page = choixEcran;
        switch (this.page){
            case 1:
                System.out.println("Composer une équipe :");
            case 2:
                System.out.println("Faire les stocks");
            case 3:
                System.out.println("Performances du service");
            case 4:
                ajoutEmploye();
            case 5:
                break;
            default:
                print();
        }
    }
}
