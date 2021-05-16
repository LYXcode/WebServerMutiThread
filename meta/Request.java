package meta;

public class Request {
    private String method;
    private String uri;
    private String version;
    private String headers;
    private String requestContent;

    public String getHeaders() {
        return headers;
    }
    public void setHeaders(String headers) {
        this.headers = headers;
    }
    public String getMethod() {
        return method;
    }
    public void setMethod(String method) {
        this.method = method;
    }
    public String getUri() {
        return uri;
    }
    public void setUri(String uri) {
        this.uri = uri;
    }
    public String getVersion() {
        return version;
    }
    public void setVersion(String version) {
        this.version = version;
    }
    public String getRequestContent() {
        return requestContent;
    }
    public void setRequestContent(String requestContent) {
        this.requestContent = requestContent;
    }

}
