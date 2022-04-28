package management;

import java.util.HashMap;
import java.util.Map;
import java.io.*;
import java.util.Vector;

public class Stocks {
    private final Map<String, Integer> stocks = new HashMap<>() ;
    File directory = new File("");
    File file = new File(directory.getAbsolutePath()+"\\src\\management\\stock.txt");
    public void setStocks(String conso) throws IOException {
        lireStock();
        switch (conso){
            case "Limonade":
                stocks.put("Limonade", stocks.get("Limonade")-1);
            case "Cidre doux":
                stocks.put("Cidre doux", stocks.get("Cidre doux")-1);
            case "Bière sans alcool":
                stocks.put("Bière sans alcool", stocks.get("Bière sans alcool")-1);
                break;
            case "Jus de fruit":
                stocks.put("Jus de fruit", stocks.get("Jus de fruit")-1);
                break;
            case "Verre d'eau":
                break;
            case "Salade":
                stocks.put("Salade", stocks.get("Salade")-1);
                break;
            case "Salade avec tomates":
                stocks.put("Salade", stocks.get("Salade")-1);
                stocks.put("Tomate", stocks.get("Tomate")-1);
                break;
            case "Potage aux oignons":
                stocks.put("Oignon", stocks.get("Oignon")-2);
                break;
            case "Potage à la tomate":
                stocks.put("Tomate", stocks.get("Tomate")-2);
                break;
            case "potage aux champignons":
                stocks.put("Champignon", stocks.get("Champignon")-2);
                break;
            case "Burger":
                stocks.put("Steack", stocks.get("Steack")-1);
                stocks.put("Pain à Burger", stocks.get("Pain à Burger")-1);
                stocks.put("Fromage", stocks.get("Fromage")-1);
                break;
            case "Burger avec salade":
                stocks.put("Steack", stocks.get("Steack")-1);
                stocks.put("Pain à Burger", stocks.get("Pain à Burger")-1);
                stocks.put("Fromage", stocks.get("Fromage")-1);
                stocks.put("Salade", stocks.get("Salade")-1);
                break;
            case "Burger avec salade et tomates":
                stocks.put("Steack", stocks.get("Steack")-1);
                stocks.put("Pain à Burger", stocks.get("Pain à Burger")-1);
                stocks.put("Fromage", stocks.get("Fromage")-1);
                stocks.put("Salade", stocks.get("Salade")-1);
                stocks.put("Tomate", stocks.get("Tomate")-1);
                break;
            case "Pizza":
                stocks.put("Tomate", stocks.get("Tomate")-1);
                stocks.put("Fromage", stocks.get("Fromage")-1);
                stocks.put("Pâte à Pizza", stocks.get("Pâte à Pizza")-1);
                break;
            case "Pizza avec champignons":
                stocks.put("Tomate", stocks.get("Tomate")-1);
                stocks.put("Fromage", stocks.get("Fromage")-1);
                stocks.put("Pâte à Pizza", stocks.get("Pâte à Pizza")-1);
                stocks.put("Champignon", stocks.get("Champignon")-1);
                break;
            case "Pizza avec du chorizo":
                stocks.put("Tomate", stocks.get("Tomate")-1);
                stocks.put("Fromage", stocks.get("Fromage")-1);
                stocks.put("Pâte à Pizza", stocks.get("Pâte à Pizza")-1);
                stocks.put("Chorizo", stocks.get("Chorizo")-1);
                break;
            case "Fajitas au poulet":
                stocks.put("Pâte à Fajitas", stocks.get("Pâte à Fajitas")-1);
                stocks.put("Riz", stocks.get("Riz")-1);
                stocks.put("Poulet", stocks.get("Poulet")-1);
                break;
            case "Fajitas au boeuf":
                stocks.put("Pâte à Fajitas", stocks.get("Pâte à Fajitas")-1);
                stocks.put("Riz", stocks.get("Riz")-1);
                stocks.put("Boeuf", stocks.get("Boeuf")-1);
                break;
            default:
                break;
        }
        FileWriter fileWriter = new FileWriter(file);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        int  compterEntree = 0;
        for (Map.Entry mapentry : stocks.entrySet()) {
            compterEntree++;
            printWriter.print(mapentry.getKey());
            printWriter.println();
            printWriter.print(mapentry.getValue());
            if(compterEntree<stocks.size()){
                printWriter.println();
            }
        }
        printWriter.close();
    }



    public void lireStock() throws IOException
    {

        File directory = new File("");
        File file = new File(directory.getAbsolutePath()+"\\src\\management\\stock.txt");
        Vector<String> v1 = new Vector();
        Vector<Integer> v2 = new Vector();
        int a = 0;
        FileReader fr = new FileReader(file);

        BufferedReader br = new BufferedReader(fr);

        String line;
        while((line = br.readLine()) != null)
        {
            if(a%2 == 0) v1.add(line);
            else v2.add(Integer.parseInt(line));
            a++;
        }
        fr.close();

        for (int i = 0; i < v1.size(); i++){
          stocks.put(v1.get(i), v2.get(i));
        }
        //for (Map.Entry mapentry : stocks.entrySet()) {
          //  System.out.println("ingrédient: "+mapentry.getKey()
            //        + " | quantité: " + mapentry.getValue());
        //}
    }
}
