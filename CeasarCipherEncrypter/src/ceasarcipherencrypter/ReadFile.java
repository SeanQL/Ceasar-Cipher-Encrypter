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
    public List<String> readFile(String file) throws IOException {
    //creates a list of strings from file path
        List<String> list = Files.readAllLines((Paths.get(file)));
    
        return list;
    }
}
