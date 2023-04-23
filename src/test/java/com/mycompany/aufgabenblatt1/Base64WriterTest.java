package com.mycompany.aufgabenblatt1;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.Base64;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author mauricehaghighi
 * @version 01/04/2023
 * 
 */
public class Base64WriterTest {

    public Base64WriterTest() {
    }

    /**
     * Test of write method, of class Base64Writer.
     */
    @Test
    public void testWrite() throws Exception {
        // Writer wird erzeugt, und schreibt irgendwas
        Writer wr = new Base64Writer(new FileOutputStream("test64.txt"));
        // erstellung encoder instanz
        Base64.Encoder encoder = Base64.getEncoder();
        //unser wort was wir zum testen nutzen
        String written = "hallo";
        // enco ist der Written String - verschluesslt in Base64
        String enco = encoder.encodeToString(written.getBytes());
        //byte-array wird benötigt zur speicherung vom reader
        byte[] array = new byte[enco.length()];
        
       
        //writer schreibt unser wort in eine datei 
        wr.write(written);
        //immer spülen und  zu machen, sonst ganz große kaka
        wr.flush();
        wr.close();
        
       
        //erzeugung FileInputStream .. zum lesen. Bietet sich in diesem Fall eher an als Reader
        FileInputStream in = new FileInputStream("test64.txt");
        
        //variablen für logik
        int i= 0;
        int val;
        //datei wird ausgelesen, jeder byte wird einzeln in Array gepackt
        while((val=in.read())!=-1){
            array[i]=(byte)val;
            i++;
        }
        //zu machen!
        in.close();
        //neuer string wird erstellt mit den Bytes aus dem array. Man muss leider ein Charset angeben, Netbeans schlägt einem aber direkt das default
        //Charset vor.. keine ahnung ob es das richtige ist? es gibt noch sachen wie UTF_8 und 16.. kein plan
        String sr = new String(array);
        
        // wir vergleichen das verschlüsselte wort mit dem was tatsächlich in der datei steht.
        // somit wissen wir a, dass der writer schreibt und b dass der encoder funktioniert 
        
        assertEquals(enco,sr);
        
        
        
        
  
       


    }

}
