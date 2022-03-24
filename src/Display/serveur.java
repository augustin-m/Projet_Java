package Display;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class serveur {
    public static List<String> menu = new ArrayList<>(Arrays.asList(
            "Limonade", "Cidre doux", "Bière sans alcool", "Jus de fruit", "verre d'eau",
            "Salade", "Salade avec tomates",
            "Potage aux oignons", "Potage à la tomate", "Potage aux champignons",
            "Burger avec salade et tomates", "Burger avec salade", "Burger",
            "Pizza", "Pizza avec champignons", "Pizza avec du chorizo"
    ));
    public static List<String> commandePlats = new ArrayList<String>();
    public static List<String> commandeBoissons = new ArrayList<String>();

    public static void printMenu(){
        for (int i = 0; i < menu.size();i++){
            System.out.println(i + " : " + menu.get(i));
        }
        System.out.println("16 : FIN DE COMMANDE");
    }
    public static void scanCommande(){
        Scanner scan = new Scanner(System.in);
        while(scan.nextInt() != 16) {
            System.out.println(menu.get(scan.nextInt()));
            if(scan.nextInt() <= 4) commandeBoissons.add(menu.get(scan.nextInt()));
            else commandePlats.add(menu.get(scan.nextInt()));
        }
    }

}

