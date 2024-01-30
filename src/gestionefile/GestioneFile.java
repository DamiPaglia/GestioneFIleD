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
        //inserire utente e password e assegnare a 2 stringhe 
        Scanner input = new Scanner(System.in);
        System.out.println("inserisci username:");
        String username = input.next();
        System.out.println("inserisci la password");
        String password =input.text();
        //scrivere il ile output.csv con questi dati
        //3) SCRITTURA
        Scrittore scrittore = new Scrittore("output.csv");
        Thread threadScrittore = new Thread(scrittore);
        threadScrittore.start();
    }
    
}
