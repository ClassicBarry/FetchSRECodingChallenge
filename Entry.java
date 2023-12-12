import java.util.Map;

public class Entry {
    private String name;
    private String url;
    private String method;
    private Map<String, String> headers;
    private String body;

    public Entry(String name, String url, String method, Map<String, String> headers, String body)
    {
        this.name = name;
        this.url = url;
        this.method = method;
        this.headers = headers;
        this.body = body;
    }

    public Entry(String name, String url, String method, Map<String, String> headers)
    {
        this.name = name;
        this.url = url;
        this.method = method;
        this.headers = headers;
    }

    public Entry(String name, String url, String method, String body)
    {
        this.name = name;
        this.url = url;
        this.method = method;
        this.body = body;
    }

    public Entry(String name, String url, Map<String, String> headers, String body)
    {
        this.name = name;
        this.url = url;
        this.method = "GET";
        this.headers = headers;
        this.body = body;
    }

    public Entry(String name, String url, String method)
    {
        this.name = name;
        this.url = url;
        this.method = method;
    }

    public Entry(String name, String url,  Map<String, String> headers)
    {
        this.name = name;
        this.url = url;
        this.method = "GET";
        this.headers = headers;
    }

    public Entry(String name, String url)
    {
        this.name = name;
        this.url = url;
        this.method = "GET";
    }

    public String getName()
    {
        return name;
    }

    public String getUrl()
    {
        return url;
    }

    public String getMethod()
    {
        return method;
    }

    public Map<String, String> getHeaders()
    {
        return headers;
    }

    public String getBody()
    {
        return body;
    }
}
