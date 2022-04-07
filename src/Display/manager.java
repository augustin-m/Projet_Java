package Display;

import management.*;

import java.io.*;
import java.util.Vector;
import java.util.Locale;
import java.util.Scanner;

public class manager {
    File file = new File("D:\\lione\\Documents\\projet_java\\src\\employes.txt");
    BufferedReader br = new BufferedReader(new FileReader(file));
    public int page;
    private Vector<Employe> employes = new Vector<Employe>();
    private Vector<Employe> equipe = new Vector<Employe>();
    private int nbBarman = 0;
    private int nbServeur = 0;
    private int nbCuisinier = 0;
    private int nbManager = 0;

    public manager() throws FileNotFoundException {
    }

    private void composerEquipe(){
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

    private void supprimeEmploye(){
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

    private String[] analyseText(String ligne){
        String[] stringSepare = ligne.split(" ");
        return stringSepare;
    }

    public void print() throws IOException {
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
        System.out.println("2- Faire les stocks");
        System.out.println("3- Performances du service");
        System.out.println("4- Ajouter un employé");
        System.out.println("5- Supprimer un employé");
        System.out.println("6- Quitter le menu");
        Scanner scanner = new Scanner(System.in);
        int choixEcran = Integer.parseInt(scanner.next());
        this.page = choixEcran;
        switch (this.page){
            case 1:
                composerEquipe();
                print();
                break;
            case 2:
                System.out.println("Faire les stocks");
                break;
            case 3:
                System.out.println("Performances du service");
                break;
            case 4:
                ajoutEmploye();
                print();
                break;
            case 5:
                supprimeEmploye();
                print();
                break;
            case 6:
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
