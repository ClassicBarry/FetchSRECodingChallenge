import java.io.*;
import java.util.*;
import org.yaml.snakeyaml.Yaml;

public class Main {
    public Values values;
    InputStream input = this.getClass()
    .getClassLoader()
    .getResourceAsStream("httpEndpoints.yaml");
    Yaml yaml = new Yaml();
    Map<String,Values> obj = yaml.load(input);
    public void output()
    {
        System.out.println(obj);
    }
}