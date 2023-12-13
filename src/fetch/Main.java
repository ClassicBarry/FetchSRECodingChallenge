package fetch;

import java.io.*;
import java.util.*;
import java.net.*;
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

        int httpRequests = 0;
        while(true)
        {
            int[] available = new int[yamlData.size()];
            int[] checkPoints = checkEndpoints(yamlData);
            httpRequests++;
            for(int i = 0; i < yamlData.size(); i++)
            {
                if(checkPoints[i] == 1)
                    available[i]++;
                System.out.println(yamlData.get("name") + " has " + (100*(available[i]/httpRequests)) + "% availability percentage");
            }
            Thread.sleep(15000);
        }
    }

    private int[] checkEndpoints(Map<String,Values> endpoints)
    {
        int[] status = new int[endpoints.size()];
        int currentEndpoint = 0;
        for(String endpoint : endpoints)
        {
            URL url = new URL(endpoint.get("url"));
            HttpURLConnection connect = url.openConnection().setRequestMethod(endpoint.method);

            for(Map.Values<String, String> header : endpoint.get("headers").entrySet())
            {
                connect.setRequestProperty(header.getKey(), header.getValue());
            }

            if(!endpoint.get("body").isEmpty())
            {
                connect.setDoOutput(true);
                connect.getOutputStream().write(endpoint.get("body").getBytes());
            }

            int code = connect.getResponseCode();
            if(code > 199 && code < 300)
                status[currentEndpoint] = 1;
            else
                status[currentEndpoint] = 0;
            currentEndpoint++;
        }
        return status;
    }
}