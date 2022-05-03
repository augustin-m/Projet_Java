package Display;
import management.Stocks;
import management.TicketDeCaisse;

import java.io.IOException;
import java.util.*;

public class serveur {  // classe permetant de gérer l'affichage de l'écran du serveur
    public static List<String> menu = new ArrayList<>(Arrays.asList(
            "Limonade", "Cidre Doux", "Bière sans alcool", "Jus de fruit", "Verre d'eau",
            "Salade", "Salade avec tomates",
            "Potage aux oignons", "Potage à la tomate", "Potage aux champignons",
            "Burger avec salade et tomates", "Burger avec salade", "Burger",
            "Pizza", "Pizza avec champignons", "Pizza avec du chorizo", "Fajitas au poulet", "Fajitas au boeuf"
    )); // liste contenant le menu
    public static List<String> commandePlats = new ArrayList<>();   // liste contenant les plats commandés
    public static List<String> commandeBoissons = new ArrayList<>();// liste contenant les boissons commandées
    public static List<String> platsFaits = new ArrayList<>();      // liste contenant les plats faits
    public static List<String> boissonsFaites = new ArrayList<>();  // liste contenant les boissons faites
    public static Map<Integer, Vector<String>> enregistrementTables  = new HashMap<>(); // map listant les tables enregistrées
    public static void verifierRupture(String nomDuPlat) throws IOException {   // fonction qui afficher les produits en rupture de stock dans le menu
        Stocks stocksActuel = new Stocks();
        switch (nomDuPlat){
            case "Limonade":
                if (stocksActuel.lireUnStock("Limonade") < 1){
                    System.out.print("PRODUIT EN RUPTURE ");
                }
                break;
            case "Cidre Doux":
                if (stocksActuel.lireUnStock("Cidre Doux") < 1){
                    System.out.print("PRODUIT EN RUPTURE ");
                }
                break;
            case "Bière sans alcool":
                if (stocksActuel.lireUnStock("Bière sans alcool") < 1){
                    System.out.print("PRODUIT EN RUPTURE ");
                }
                break;
            case "Jus de fruit":
                if (stocksActuel.lireUnStock("Jus de fruit") < 1){
                    System.out.print("PRODUIT EN RUPTURE ");
                }
                break;
            case "Verre d'eau":
                break;
            case "Salade":
                if (stocksActuel.lireUnStock("Salade") < 1){
                    System.out.print("PRODUIT EN RUPTURE ");
                }
                break;
            case "Salade avec tomates":
                if (stocksActuel.lireUnStock("Salade") < 1 || stocksActuel.lireUnStock("Tomate") < 1){
                    System.out.print("PRODUIT EN RUPTURE ");
                }
                break;
            case "Potage aux oignons":
                if (stocksActuel.lireUnStock("Oignon") < 2){
                    System.out.print("PRODUIT EN RUPTURE ");
                }
                break;
            case "Potage à la tomate":
                if (stocksActuel.lireUnStock("Tomate") < 2){
                    System.out.print("PRODUIT EN RUPTURE ");
                }
                break;
            case "potage aux champignons":
                if (stocksActuel.lireUnStock("Champignon") < 2){
                    System.out.print("PRODUIT EN RUPTURE ");
                }
                break;
            case "Burger":
                if (stocksActuel.lireUnStock("Steack") < 1 || stocksActuel.lireUnStock("Pain à Burger") < 1 || stocksActuel.lireUnStock("Fromage") < 1){
                    System.out.print("PRODUIT EN RUPTURE ");
                }
                break;
            case "Burger avec salade":
                if (stocksActuel.lireUnStock("Steack") < 1 || stocksActuel.lireUnStock("Pain à Burger") < 1 || stocksActuel.lireUnStock("Fromage") < 1|| stocksActuel.lireUnStock("Salade") < 1){
                    System.out.print("PRODUIT EN RUPTURE ");
                }
                break;
            case "Burger avec salade et tomates":
                if (stocksActuel.lireUnStock("Steack") < 1 || stocksActuel.lireUnStock("Pain à Burger") < 1 || stocksActuel.lireUnStock("Fromage") < 1|| stocksActuel.lireUnStock("Salade") < 1|| stocksActuel.lireUnStock("Tomate") < 1){
                    System.out.print("PRODUIT EN RUPTURE ");
                }
                break;
            case "Pizza":
                if (stocksActuel.lireUnStock("Tomate") < 1 || stocksActuel.lireUnStock("Pâte à Pizza") < 1 || stocksActuel.lireUnStock("Fromage") < 1){
                    System.out.print("PRODUIT EN RUPTURE ");
                }
                break;
            case "Pizza avec champignons":
                if (stocksActuel.lireUnStock("Tomate") < 1 || stocksActuel.lireUnStock("Pâte à Pizza") < 1 || stocksActuel.lireUnStock("Fromage") < 1 || stocksActuel.lireUnStock("Champignon") < 1){
                    System.out.print("PRODUIT EN RUPTURE ");
                }
                break;
            case "Pizza avec du chorizo":
                if (stocksActuel.lireUnStock("Tomate") < 1 || stocksActuel.lireUnStock("Pâte à Pizza") < 1 || stocksActuel.lireUnStock("Fromage") < 1 || stocksActuel.lireUnStock("Chorizo") < 1){
                    System.out.print("PRODUIT EN RUPTURE ");
                }
                break;
            case "Fajitas au poulet":
                if (stocksActuel.lireUnStock("Riz") < 1 || stocksActuel.lireUnStock("Pâte à Fajitas") < 1 || stocksActuel.lireUnStock("Poulet") < 1){
                    System.out.print("PRODUIT EN RUPTURE ");
                }
                break;
            case "Fajitas au boeuf":
                if (stocksActuel.lireUnStock("Riz") < 1 || stocksActuel.lireUnStock("Pâte à Fajitas") < 1 || stocksActuel.lireUnStock("Boeuf") < 1){
                    System.out.print("PRODUIT EN RUPTURE ");
                }
                break;
            default:
                break;
        }
    }

    public static void printMenu() throws IOException {     // fonction qui affiche le menu
        for (int i = 0; i < menu.size();i++){
            verifierRupture(menu.get(i));
            System.out.println(i + " : " + menu.get(i));

        }
        System.out.println(menu.size() + " : FIN DE COMMANDE");
        System.out.println("Veuillez saisir le numéro de la table à enregistrer :");
        Scanner scan = new Scanner(System.in);
        int check = scan.nextInt();
        if(check <= 20 && check > 0){
            scanCommande(check);
        }
        System.out.println(menu.size() + " : FIN DE COMMANDE");
    }
    public static void scanCommande(int numTable) throws IOException {  // fonction qui scanne la commande effectuée
        System.out.println("Veuillez saisir le numéro du plat ou de la boisson commandé :");
        Scanner scan = new Scanner(System.in);
        int verif = scan.nextInt();
        Vector<String>commandeTable = new Vector();
        if(verif < menu.size()) {
            System.out.println(menu.get(verif));
            if(verif <= 4) commandeBoissons.add(menu.get(verif));
            else commandePlats.add(menu.get(verif));
            if(enregistrementTables.get(numTable) != null){
                commandeTable = enregistrementTables.get(numTable);
            }
            commandeTable.add(menu.get(verif));
            enregistrementTables.put(numTable, commandeTable);
            scanCommande(numTable);
        }
        if(verif >= menu.size()){
            System.out.println("Commande de la table " + numTable + " envoyée");
            for (int i = 0; i < enregistrementTables.get(numTable).size(); i++){
                System.out.println(enregistrementTables.get(numTable).get(i));
            }
        }
        TicketDeCaisse commande = new TicketDeCaisse();
        commande.sauvgarderTicket(numTable, commandeTable);
    }

}

