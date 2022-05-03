import management.Stocks;

import java.io.IOException;
import java.util.*;



public class App {
    public static void main(String[] args) throws IOException {
        menu();
    }
    public static void menu() throws IOException {
        System.out.println("Quel écran souhaitez vous afficher?");  // Affichages d'un menu de redirection en fonction
        System.out.println("1- Ecran prise de commande");   // de l'écran à afficher : serveur (1), cuisinier/barman (2),
        System.out.println("2- Ecran cuisine ou de bar");   // monitor (3) ou paiment (4)
        System.out.println("3- Ecran Monitoring");
        System.out.println("4- Ecran Ticket de caisse");
        Scanner scanner = new Scanner(System.in);   // scanner pour déterminer l'indice associé à l'écran à afficher
        int choixEcran = scanner.nextInt();     // on associe la variable "choixEcran" au scanner déjà initialisé
        Affichage Display1 = new Affichage();
        Display1.print(choixEcran); // Affichage de l'écran souhaité
        menu(); // On appelle la fonction "menu()" en boucle pour afficher le menu une fois l'écran souhaité fermé
    }
}


