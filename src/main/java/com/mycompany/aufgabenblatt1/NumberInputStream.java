package com.mycompany.aufgabenblatt1;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/**
 *
 * @author mauricehaghighi
 */
public class NumberInputStream extends InputStream {

    private Reader reader1;

    public NumberInputStream(Reader param) {
        //Unsere klasse erwartet einen Reader als Übergabeparameter
        this.reader1 = param;
    }

    /*
     Returns:
    The character read, as an integer in the range 0 to 65535 (0x00-0xffff), or -1 if the end of the stream has been reached
     */
    // Read MUSS überschrieben werden, da abstract method aus InputStream
    /*
    Notizen , grobe Übersicht : reader ließt ASCII zeichen und returnt diese. 
    ASCII Ziffern starten ab 49 (49==1).
    32 = SP ( siehe ASCII Tabelle)
    32 ist also das Leerzeichen, somit wollen wir diese aussortieren
    10= Linefeed ( LF)
    
     */
    @Override
    public int read() throws IOException {
        int r;
        int c = reader1.read();
        String temp = "";
        // KLAMMERN WICHTIG !!!
        if ((c < 47 || c > 58) && c != -1) {
            return -2;
        }

        while (c > 47 && c < 58) // wir aktzeptieren nur ASCII werte zwischen 48 und 57, da hier unsere 10 ziffern "liegen" 
        {
            temp += (char) c;  //cast begrenzt benutzen

            c = reader1.read();

        }

        // wird benötigt falls zwei leerzeichen aufeinander folgen. Falls dies der fall ist wird der zuletzt gültige wert returnt
        if (temp.isEmpty()) {

            return c;
        } else {
            r = Integer.parseInt(temp);         // unser zusammengebauter string wird in r uebergeben ( als integer)

            if (r > 255) {      //falls nummer zu groß
                throw new NumberTooLargeException("Nummer zu groß");

            }
            return r;

        }
    }

}
