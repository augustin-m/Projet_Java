package Display;

import management.*;

import java.io.*;
import java.util.Map;
import java.util.Vector;
import java.util.Locale;
import java.util.Scanner;

public class manager {  // classe qui permet de gérer les différentes actions possibles du manager
    File directory = new File("");
    File file = new File(directory.getAbsolutePath()+"\\src\\management\\employes.txt");    // lien du fichier txt contenant la liste des employés
    BufferedReader br = new BufferedReader(new FileReader(file));
    public int page;
    private Vector<Employe> employes = new Vector<Employe>();   // vecteur contenant l'ensemble des employés
    private Vector<Employe> equipe = new Vector<Employe>(); // vecteur contenant l'équipe de la journée
    private int nbBarman = 0;   // nombre de barmans
    private int nbServeur = 0;  // nombre de serveurs
    private int nbCuisinier = 0;// nombre de cuisiniers
    private int nbManager = 0;  // nombre de managers

    public manager() throws FileNotFoundException {
    }

    private void composerEquipe(){  // fonction permetant de composer une équipe
        System.out.println("Quel employe voulez vous ajouter ?");
        for(int i = 0; i< employes.size();i++){
            System.out.println(i + " " + employes.get(i).nom + " " + employes.get(i).prenom + " " + (employes.get(i).getClass()).toString().substring(17,(employes.get(i).getClass()).toString().length()));
        }
        System.out.println("Pour quitter cet affichage entrez : " + employes.size());
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        if(id >= employes.size()){
            if (nbBarman >= 1 && nbCuisinier >= 4 && nbServeur >= 2 && nbBarman >= 1){

            }else{
                System.out.println("Êtes vous sûr de vouloir quitter ? L'équipe n'est pas compléte.");
                if(nbBarman < 1){
                    System.out.println("Il vous manque " + (1-nbBarman) + " Barman");
                }
                if(nbCuisinier < 4){
                    System.out.println("Il vous manque " + (4-nbCuisinier) + " Cuisinier");
                }
                if(nbServeur < 2){
                    System.out.println("Il vous manque " + (2-nbServeur) + " Serveur");
                }
                if(nbManager < 1){
                    System.out.println("Il vous manque " + (1-nbManager) + " Manager");
                }
                System.out.println("Pour quitter quand même, tapez 1. Sinon 0");
                if(scanner.nextInt() == 0){
                    composerEquipe();
                }
            }

        }else if(equipe.indexOf(employes.get(id)) >= 0){
            System.out.println(employes.get(id).prenom + " est déjà dans l'équipe.");
            composerEquipe();
        }else if(employes.get(id).getWorkday() < 3){
            String travailEmploye = (employes.get(id).getClass()).toString().substring(17,(employes.get(id).getClass()).toString().length());
            equipe.add(employes.get(id));
            employes.get(id).addWorkDay();
            switch (travailEmploye) {
                case "Barman":
                    nbBarman++;
                case "Cuisinier":
                    nbCuisinier++;
                case "Serveur":
                    nbServeur++;
                case "Manager":
                    nbManager++;
            }
            composerEquipe();
        }else{
            System.out.println(employes.get(id).prenom + " a déjà travaillé(e) trois soirs d'affilé, merci de choisir quelqu'un d'autre pour votre équipe");
            composerEquipe();
        }

    }
    private void ajoutEmploye(){    // fonction permetant d'ajouter un employé et ses informations personnelles
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

    private void supprimeEmploye(){     // fonction permetant de supprimer un employé
        System.out.println("Quel employe voulez vous exclure ?");
        for(int i = 0; i< employes.size();i++){
            System.out.println(i + " " + employes.get(i).nom + " " + employes.get(i).prenom + " " + (employes.get(i).getClass()).toString().substring(17,(employes.get(i).getClass()).toString().length()));
        }
        System.out.println("Pour quitter cet affichage entrez : " + employes.size());
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        if(id < employes.size() && id > 0){
            employes.remove(id);
        }
    }

    private String[] analyseText(String ligne){     // fonction permetant de renvoyer un tableau de String avec tous les mots de la ligne souhaitée
        String[] stringSepare = ligne.split(" ");
        return stringSepare;
    }

    private void imprimmerCourses() throws IOException {    // fonction permetant d'imprimer la liste de courses (si article < 20)
        Vector <String> nomProduits = new Vector();
        Vector <Integer> nombreRequis =  new Vector();
        Stocks stockActuel = new Stocks();
        Vector<Vector> stock = stockActuel.lireStock();
        for(int i = 0; i < stock.get(1).size(); i++){
            if( (Integer)stock.get(1).get(i) <= 20){
                nomProduits.add((String)stock.get(0).get(i));
                nombreRequis.add(50-(Integer)stock.get(1).get(i));
            }
        }
        if(nombreRequis.size() == 0) {
            System.out.println("Il n'y a pas besoin de faire les courses pour l'instant");
        }else {
            System.out.println("Voici votre liste de course :");
        }
        for (int i =0; i<nombreRequis.size(); i++){
            System.out.println(nomProduits.get(i) + " " + nombreRequis.get(i));
        }
    }

    public void remplirLesStocks() throws IOException {     // fonction permetant d'ajouter du stock une fois les courses effectuées
        System.out.println("Qu'avez vous acheté ?");
        Stocks stockActuel = new Stocks();
        Vector<Vector> stock = stockActuel.lireStock();
        for(int i = 0; i< stock.get(1).size();i++){
            System.out.println(i + " " + stock.get(0).get(i));
        }
        System.out.println("Pour quitter, tapez " + stock.get(0).size());
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        if (id >= 0 && id < stock.get(0).size()){
            System.out.println("Quelle quantité ?");
            int quantite = scanner.nextInt();
            stockActuel.ajouterStock((String)stock.get(0).get(id),quantite);
            remplirLesStocks();
        }
    }

    public void performances() throws IOException {     // fonction permetant d'afficher les performances quotidiennes
        File performances = new File(directory.getAbsolutePath()+"\\src\\stockage\\performance.txt");
        FileReader fr = new FileReader(performances);
        BufferedReader brPerf = new BufferedReader(fr);
        System.out.println("Les performances du services sont de " + brPerf.readLine() + " €");
        fr.close();
    }

    public void reinitialiserPerf() throws IOException {    // fonction permetant de remettre à 0 les performances à chaque fin de service
        File performances = new File(directory.getAbsolutePath()+"\\src\\stockage\\performance.txt");
        FileWriter fileWriterPerf = new FileWriter(performances);
        PrintWriter printWriter = new PrintWriter(fileWriterPerf);
        printWriter.print(0);
        printWriter.close();
    }
    public void print() throws IOException {    // fonction permetant d'afficher l'écran manager
        String ligneFichier;
        while((ligneFichier = br.readLine()) != null){
            String[] infoEmploye = analyseText(ligneFichier);
            switch (infoEmploye[3]){
                case "Barman":
                    Barman ancienBarman = new Barman(infoEmploye[0], infoEmploye[1], Integer.parseInt(infoEmploye[2]));
                    employes.add(ancienBarman);
                    break;
                case "Cuisinier":
                    Cuisinier ancienCuisinier = new Cuisinier(infoEmploye[0], infoEmploye[1], Integer.parseInt(infoEmploye[2]));
                    employes.add(ancienCuisinier);
                    break;
                case "Serveur":
                    Serveur ancienServeur = new Serveur(infoEmploye[0], infoEmploye[1], Integer.parseInt(infoEmploye[2]));
                    employes.add(ancienServeur);
                    break;
                case "Manager":
                    Manager ancienManager = new Manager(infoEmploye[0], infoEmploye[1], Integer.parseInt(infoEmploye[2]));
                    employes.add(ancienManager);
                    break;
                default:
                    break;
            }

        }
        System.out.println("Que désirez vous faire ?");
        System.out.println("1- Composer une équipe");
        System.out.println("2- Imprimmer le ticket de course");
        System.out.println("3- Remplir les stocks");
        System.out.println("4- Performances du service");
        System.out.println("5- Ajouter un employé");
        System.out.println("6- Supprimer un employé");
        System.out.println("7- Réinitialiser les performances");
        System.out.println("8- Quitter le menu");
        Scanner scanner = new Scanner(System.in);
        int choixEcran = Integer.parseInt(scanner.next());
        this.page = choixEcran;
        switch (this.page){
            case 1:
                composerEquipe();
                print();
                break;
            case 2:
                imprimmerCourses();
                print();
                break;
            case 3:
                remplirLesStocks();
                print();
                break;
            case 4:
                performances();
                print();
                break;
            case 5:
                ajoutEmploye();
                print();
                break;
            case 6:
                supprimeEmploye();
                print();
                break;
            case 7:
                reinitialiserPerf();
                print();
                break;
            case 8:
                break;
            default:
                print();
        }
        FileWriter fileWriter = new FileWriter(file);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        for (int i = 0; i < employes.size(); i++) {
            printWriter.print(employes.get(i).prenom + " " + employes.get(i).nom + " " + employes.get(i).salaire + " " + (employes.get(i).getClass()).toString().substring(17,(employes.get(i).getClass()).toString().length()));
            if (i<employes.size()-1) {
                printWriter.println();
            }
        }
        printWriter.close();
    }
}
