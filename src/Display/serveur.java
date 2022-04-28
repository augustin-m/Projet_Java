package Display;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class serveur {
    public static List<String> menu = new ArrayList<>(Arrays.asList(
            "Limonade", "Cidre doux", "Bière sans alcool", "Jus de fruit", "Verre d'eau",
            "Salade", "Salade avec tomates",
            "Potage aux oignons", "Potage à la tomate", "Potage aux champignons",
            "Burger avec salade et tomates", "Burger avec salade", "Burger",
            "Pizza", "Pizza avec champignons", "Pizza avec du chorizo"
    ));
    public static List<String> commandePlats = new ArrayList<String>();
    public static List<String> commandeBoissons = new ArrayList<String>();
    public static List<String> platsFaits = new ArrayList<String>();
    public static List<String> boissonsFaites = new ArrayList<String>();
    public static Map<Integer,Vector<String>> enregistrementTables  = new HashMap<>();

    public static void printMenu(){
        for (int i = 0; i < menu.size();i++){
            System.out.println(i + " : " + menu.get(i));
        }
        System.out.println("16 : FIN DE COMMANDE");
        System.out.println("Veuillez saisir le numéro de la table à enregistrer :");
        Scanner scan = new Scanner(System.in);
        int check = scan.nextInt();
        if(check <= 20 && check > 0){
            scanCommande(check);
        }
    }
    public static void scanCommande(int numTable){
        System.out.println("Veuillez saisir le numéro du plat ou de la boisson commandé :");
        Scanner scan = new Scanner(System.in);
        int verif = scan.nextInt();
        if(verif < 16) {
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
        if(verif == 16){
            System.out.println("Commande de la table " + numTable + " envoyée");
            for (int i = 0; i < enregistrementTables.get(numTable).size(); i++){
                System.out.println(enregistrementTables.get(numTable).get(i));
            }
        }
    }

}

