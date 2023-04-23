package com.mycompany.aufgabenblatt1;

import org.junit.jupiter.api.Test;

/**
 *
 * @author mauricehaghighi
 */
import java.io.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;

public class NumberInputStreamTest {

    

    @Test
    public void testRead1() throws IOException {
        InputStream stream1 = new NumberInputStream(new FileReader("zahlen_1.txt"));
        assertEquals(12,stream1.read());
        assertEquals(0,stream1.read());
        assertEquals(222,stream1.read());
        
        }
    @Test 
    public void testRead2() throws IOException {
        InputStream stream2 = new NumberInputStream(new FileReader("zahlen_2.txt"));
        assertEquals(122,stream2.read());
        assertEquals(01,stream2.read());
        
    }

}
