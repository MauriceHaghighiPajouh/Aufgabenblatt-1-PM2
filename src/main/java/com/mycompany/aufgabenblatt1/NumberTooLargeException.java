/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aufgabenblatt1;

import java.io.IOException;

/**
 *
 * @author mauricehaghighi
 */
public class NumberTooLargeException extends IOException {
    
    public NumberTooLargeException(String param){
        
        // javaDoc !! IOException ... Hierfür muss konsruktor von superklasse aufgerufen werden..
      
        //
        super(param);

    }
    
   
    
    
}
