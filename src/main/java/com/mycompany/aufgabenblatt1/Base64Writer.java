
package com.mycompany.aufgabenblatt1;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Base64;

/**
 *
 * @author mauricehaghighi
 */
public class Base64Writer extends OutputStreamWriter{
    
    public Base64Writer(OutputStream out) {
        super(out);
    }
    
    
    //methode aus OutputStreamWriter wird überschrieben
    @Override
    public void write(String str) throws IOException{
     String temp = "";      //hilfsvariable
     
     temp= Base64.getEncoder().encodeToString(str.getBytes());    // an Base64.getEncoder wird encodeToString aufgerufen - hierfür hilft getBytes methode 
     
     super.write(temp);     // wir rufen an OutputStreamWriter die originale write methode aus. Selbes prinzip wie beim reader
        
      
       
        
        
    }
    
    
}
