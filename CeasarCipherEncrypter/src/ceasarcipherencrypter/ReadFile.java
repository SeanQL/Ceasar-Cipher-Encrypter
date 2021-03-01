package ceasarcipherencrypter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 *
 * @author Sean Lawson
 */
public class ReadFile {
    public String[] readFile(String file) throws IOException {
    
        //gets the path from the file textfield and converts the List into a String Array
        List<String> arr = Files.readAllLines((Paths.get(file)));
        String[] str = new String[arr.size()];

        for(int i = 0; i < arr.size(); i ++) {
            str[i] = arr.get(i);
        }
    
        return str;
    }
}
