import management.Serveur;
import java.util.*;



public class App {
    public static void main(String[] args){
        menu();
    }
    public static void menu(){
        System.out.println("Quel écran souhaitez vous afficher?");
        System.out.println("1- Ecran prise de commande");
        System.out.println("2- Ecran cuisine ou de bar");
        System.out.println("3- Ecran Monitoring");
        Serveur Jack = new Serveur("Jack", "Dubois", 1200);
        Scanner scanner = new Scanner(System.in);
        int choixEcran = scanner.nextInt();
        Affichage Display1 = new Affichage();
        Display1.print(choixEcran);
        menu();
    }
}


