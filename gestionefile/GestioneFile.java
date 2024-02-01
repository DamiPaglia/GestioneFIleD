package gestionefile;

import java.io.Console;
import java.util.Arrays;
import java.io.IOException;
import java.util.Scanner;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 *
 * @author Damiano Pagliairni
 * @version 12/01/23
 */
public class GestioneFile {

    public static void main(String[] args) throws  IOException{
        Matrice mt = new Matrice("VIGENERE");
        Vigenere v = new Vigenere(0,12,0,12,mt);
        Vigenere v1 = new Vigenere(12,26,0,12,mt);
        Vigenere v2 = new Vigenere(0,12,0,12,mt);
        Vigenere v3 = new Vigenere(12,26,12,26,mt);
        Thread t = new Thread(v);
        Thread t1 = new Thread(v1);
        Thread t2 = new Thread(v2);
        Thread t3 = new Thread(v3);
        t.start();
        t1.start();
        t2.start();
        t3.start();
      try{
        t.join();
        t1.join();
        t2.join();
        t3.join();
      }catch(InterruptedException ex){
        
      }
     
        
      
        //1)LETTURA
        Lettore lettore = new Lettore("user.json");
        lettore.start();
        //2)ELABORAZIONE
      Scanner input = new Scanner(System.in);
      System.out.println("Enter username:");
      String username = input.nextLine();
      String userNameC= mt.cifra(username);
      System.out.println("Enter password:");
      String password = input.nextLine();
      String passwordC= mt.cifra(password);
        //3) SCRITTURA
        Scrittore scrittore = new Scrittore("output.csv", userNameC, passwordC);
      Scrittore copia = new Scrittore("copia.csv", userNameC, passwordC);
      Scrittore StreamCopia = new Scrittore("user.csv", userNameC, passwordC);
      Thread threadStream = new Thread(StreamCopia);
      threadStream.start();
       final String dataFile = "user.csv";
      DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(dataFile))); 
   DataOutputStream out = new DataOutputStream(new BufferedOutputStream(
        new FileOutputStream(dataFile)));
      out.writeUTF(dataFile);
        Thread threadScrittore = new Thread(scrittore);
        Thread threadCopia = new Thread(copia);
        threadCopia.start();
        threadScrittore.start();
        
    }

}
