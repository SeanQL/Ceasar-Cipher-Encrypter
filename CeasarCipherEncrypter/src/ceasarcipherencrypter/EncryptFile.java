
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ceasarcipherencrypter;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sean Lawson
 */
public class EncryptFile {
    public List<String> encrypt(List<String> key, List<String> file) {
        
        List<String> originalList = file;
        List<String> encodedList = new ArrayList<>();
        
        //splits key into plain text and cipher text
        String plainTxt = key.get(0);
        String cipherTxt = key.get(1);
        
        //for each string in the original text file
        for (String str : originalList) {
            String encodedStr = "";
            //for each character in the string
            for(int i = 0; i < str.length(); i++) {
                char c = str.toLowerCase().charAt(i);
                
                //if character is alphabetic, if not adds the character to the end of the string
                if(Character.isAlphabetic(c)) {
                    //finds the index of the character in the plain text list
                    int index = plainTxt.indexOf(c);

                    // converts character to the one found at the index of the cipher
                    System.out.println("i: " + i + "\tdecodedStr: " + str + "\tindex: " + index + "\tc: " + c);
                    c = cipherTxt.charAt(index);
                    
                }
                
                // adds character to the end of a new string
                encodedStr = encodedStr + c;
            }
            
            //adds string to the encoded list
            encodedList.add(encodedStr);
        }
    
        return encodedList;
    }
}