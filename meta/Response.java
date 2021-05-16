package meta;

import java.util.HashMap;

public class Response {
    private String httpVsersion = "HTTP/1.1";
    private String stateCode = "";
    private String stateMessage = "";

    private HashMap<String, String> responseHeades;
    private Object responseContent;

    private final String space = " ";
    private final String newLine = "\r\n";

    public Response(String stateCode, String stateMessage,  HashMap<String, String> responseHeades, Object responseContent){
        this.stateCode= stateCode;
        this.stateMessage =stateMessage;
        this.responseHeades = responseHeades;
        this.responseContent =responseContent;
    }

    public String createResponse() {
        if (stateCode == "" || stateMessage == "") {
            stateCode = "500";
            stateMessage = "Internal Server Error";
        }
        String headers = "";

        if (responseHeades == null) {
            headers = "";
        } else {
            for (String key : responseHeades.keySet()) {
                headers += key + ": " + responseHeades.get(key) + newLine;
            }

        }
String content = "";
        if(responseContent != null){
content = responseContent.toString();
        }

        String responseString = httpVsersion + space + stateCode + space + stateMessage + newLine + headers + newLine
                + content;

        return responseString;
    }

    public String getHttpVsersion() {
        return httpVsersion;
    }

    public void setHttpVsersion(String httpVsersion) {
        this.httpVsersion = httpVsersion;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getStateMessage() {
        return stateMessage;
    }

    public void setStateMessage(String stateMessage) {
        this.stateMessage = stateMessage;
    }

    public HashMap<String, String> getResponseHeades() {
        return responseHeades;
    }

    public void setResponseHeades(HashMap<String, String> responseHeades) {
        this.responseHeades = responseHeades;
    }

    public Object getResponseContent() {
        return responseContent;
    }

    public void setResponseContent(Object responseContent) {
        this.responseContent = responseContent;
    }

    public String getSpace() {
        return space;
    }

    public String getNewLine() {
        return newLine;
    }

}
