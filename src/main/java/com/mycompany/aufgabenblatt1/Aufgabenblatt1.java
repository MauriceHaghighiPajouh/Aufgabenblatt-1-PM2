package com.mycompany.aufgabenblatt1;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mauricehaghighi
 *
 */
public class Aufgabenblatt1 {

    public static void main(String[] args) {

        FileReader fr;
        try {
            fr = new FileReader("zahlen_2.txt"); // wir erstellen einen Filereader und übergeben die datei

            NumberInputStream input = new NumberInputStream(fr); // wir erzeugen ein Objekt von NIS . 
            //NumberInputStream erbt von InputStream

            int val;
            

            // loop läuft solange bis -1 return wird.
            // reader returnt -1 sobald nichts mehr gefunden wird, quasi die ganze datei ausgelesen wurde
            while ((val = input.read()) != -1) {
                if (val == -2) {
                    continue;
                }
                System.out.println(val);
            }
            // NICHT  VERGESSEN
            input.close();

            //automatisches trycatch
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Aufgabenblatt1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Aufgabenblatt1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        // writer
        
        try {
            Writer out = new Base64Writer(new FileOutputStream("output.txt"));
            out.write("Hallo, Ich bin Maurice und ich frustiere mit diesem Aufgabenblatt");
            out.flush();
            out.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Aufgabenblatt1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Aufgabenblatt1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
   
}
