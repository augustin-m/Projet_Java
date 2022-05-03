package management;

import java.io.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.Vector;

public class TicketDeCaisse {    // Classe permetant de faire des opérations sur le ticket de caisse
    Integer numeroTable;
    File directory = new File("");
    public void sauvgarderTicket (Integer numeroTable, Vector<String> informations) throws IOException {    // fonction qui sauvegarde le ticket une fois la commande prise
        File file = new File(directory.getAbsolutePath()+"\\src\\stockage\\"+numeroTable+".txt");
        FileWriter ticket = new FileWriter(file);
        PrintWriter printWriter = new PrintWriter(ticket);
        int  compterEntree = 0;
        printWriter.println(numeroTable);
        for (int i = 0; i < informations.size(); i++) {
            compterEntree++;
            printWriter.print(informations.get(i));
            if(compterEntree<informations.size()){
                printWriter.println();
            }
        }
        printWriter.close();
    }

    public int getPrice(String aliment){    // fonction qui renvoie le prix d'un plat ou d'une boisson souhaité(e)
        int prix = 0;
        switch (aliment){
            case "Limonade":
                prix = 4;
                break;
            case "Cidre Doux":
            case "Bière sans alcool":
                prix = 5;
                break;
            case "Jus de fruit":
                prix = 1;
                break;
            case "Verre d'eau":
                prix = 0;
                break;
            case "Salade":
            case "Salade avec tomates":
                prix = 9;
                break;
            case "Potage aux oignons":
            case "potage aux champignons":
            case "Potage à la tomate":
                prix = 8;
                break;
            case "Burger":
            case "Burger avec salade et tomates":
            case "Burger avec salade":
                prix = 15;
                break;
            case "Pizza":
            case "Pizza avec du chorizo":
            case "Pizza avec champignons":
                prix = 12;
                break;
            case "Fajitas au poulet":
            case "Fajitas au boeuf":
                prix = 11;
                break;
            default:
                break;
        }
        return prix;
    }

    public void performances(Integer prix) throws IOException {     // fonction qui imprime les performances quotidiennes du restaurant
        File performances = new File(directory.getAbsolutePath()+"\\src\\stockage\\performance.txt");
        FileReader fr = new FileReader(performances);
        BufferedReader brPerf = new BufferedReader(fr);
        int perfActuel = Integer.parseInt(brPerf.readLine());
        fr.close();
        FileWriter fileWriterPerf = new FileWriter(performances);
        PrintWriter printWriter = new PrintWriter(fileWriterPerf);
        printWriter.print(perfActuel+prix);
        printWriter.close();
    }
    public void imprimerTicket (Integer numeroTable) throws IOException {   // fonction qui imprime le ticket de caisse
        File fileDelete = new File(directory.getAbsolutePath()+"\\src\\stockage\\"+numeroTable+".txt");
        final SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        File file = new File(directory.getAbsolutePath()+"\\src\\archives\\"+sdf3.format(timestamp)+".txt");
        FileWriter ticket = new FileWriter(file);
        PrintWriter printWriter = new PrintWriter(ticket);
        FileReader fr = new FileReader(fileDelete);
        BufferedReader br = new BufferedReader(fr);
        String line;
        int compteur =0;
        int total = 0;
        while((line = br.readLine()) != null)
        {
            if(compteur == 0){
                printWriter.println("Table numéro : "+line);
                System.out.println("Table numéro : "+line);
            } else{
                System.out.println(line + " " + getPrice(line)+"€");
                total += getPrice(line);
                printWriter.println(line + " " + getPrice(line)+"€");
            }
            compteur++;
        }
        System.out.println("Total : "+total+"€");
        printWriter.println("Total : "+total+"€");
        performances(total);
        fr.close();
        printWriter.close();
        fileDelete.delete();
    }
}
