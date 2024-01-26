package gestionefile;

import java.io.Console;
import java.util.Arrays;
import java.io.IOException;
/**
 *
 * @author Damiano Pagliairni
 * @version 12/01/23
 */
public class GestioneFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws  IOException{
        
        //1)LETTURA
        Lettore lettore = new Lettore("user.json");
        lettore.start();
        //2)ELABORAZIONE
        //inserire utente e password e assegnare a 2 stringhe 
        //scrivere il ile output.csv con questi dati
        //3) SCRITTURA
        Scrittore scrittore = new Scrittore("output.csv");
        Thread threadScrittore = new Thread(scrittore);
        threadScrittore.start();
    }
    
}
