package management;

import Display.barmanXcuisinier;
import Display.serveur;

import java.util.HashMap;
import java.util.Map;
import java.io.*;
import java.util.Vector;

public class Stocks {
    private Map<String, Integer> stocks = new HashMap<>() ;

    public void setStocks(String conso) {
        if(conso == "Salade"){

        }
        else if(conso == "Salade avec "){

        }
    }


    public void lireStock() throws IOException
    {

        File file = new File("C:/Users/Administrateur/IdeaProjects/TP2_Java/src/management/stock.txt");
        Vector v1 = new Vector();
        Vector v2 = new Vector();
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
          stocks.put((String) v1.get(i), (Integer) v2.get(i));
        }
        //for (Map.Entry mapentry : stocks.entrySet()) {
          //  System.out.println("ingrédient: "+mapentry.getKey()
            //        + " | quantité: " + mapentry.getValue());
        //}
    }
}
