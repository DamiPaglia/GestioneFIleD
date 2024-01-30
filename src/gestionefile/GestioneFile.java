package gestionefile;

import java.io.Console;
import java.util.Arrays;
import java.io.IOException;
import java.util.Scanner; 
/**
 *
 * @author Damiano Pagliairni
 * @version 12/01/23
 */
public class GestioneFile {

    public static void main(String[] args) throws  IOException{

        //1)LETTURA
        Lettore lettore = new Lettore("user.json");
        lettore.start();
        //2)ELABORAZIONE
      Scanner input = new Scanner(System.in);
      System.out.println("Enter username:");
      String username = input.nextLine();
      System.out.println("Enter password:");
      String password = input.nextLine();
        //inserire utente e password e assegnare a 2 stringhe 
        //scrivere il ile output.csv con questi dati
        //3) SCRITTURA
        Scrittore scrittore = new Scrittore("output.csv", username, password);
        Thread threadScrittore = new Thread(scrittore);
        threadScrittore.start();
    }

}