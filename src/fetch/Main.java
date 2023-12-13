package fetch;

import java.io.*;
import java.util.*;
import org.yaml.snakeyaml.Yaml;

public class Main {
    public static void main(String args[])
    {
        String file = "src/fetch/httpEndpoints.java";
        try
        {
            Yaml yaml = new Yaml();
            Map<String, Values> yamlData = yaml.load(file);
        } 
        catch(IOException e)
        {

        }
    }
}