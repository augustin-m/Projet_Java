package management;
import java.util.Vector;
public class Serveur extends Employe {
    private Vector table = new Vector();
    public Serveur(String name, String surname, int salary){
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }
    public void addTable(int tableNumber){
        table.add(tableNumber);
    }
    public void removeTable(int tableNumber){
        table.removeElement(tableNumber);
    }
}