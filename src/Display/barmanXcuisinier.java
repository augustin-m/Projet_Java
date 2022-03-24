package Display;

import java.util.Scanner;

public class barmanXcuisinier {
    public int statut;
    public void print(){
        System.out.println("Etes vous barman ou cuisinier ?");
        System.out.println("1- Barman");
        System.out.println("2- Cuisinier");
        Scanner scanner = new Scanner(System.in);
        int choixEcran = scanner.nextInt();
        this.statut = choixEcran;
    }
}
