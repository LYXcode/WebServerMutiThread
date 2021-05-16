package meta;
public class utils {
    public static Request parseRequestString(String requestString) {
        Request request = new Request();
        String resLine = "";
        String resHeaders = "";
        String resContents = "";
        int currentPos = 0;
        while (currentPos < requestString.length()) {
            if (requestString.charAt(currentPos) == '\r' && requestString.charAt(currentPos + 1) == '\n') {
                break;
            }
            currentPos++;
        }

        resLine = requestString.substring(0, currentPos);

        int headerStart = currentPos + 2;

        while (currentPos < requestString.length()) {
            if (requestString.charAt(currentPos) == '\r' && requestString.charAt(currentPos + 1) == '\n'
                    && requestString.charAt(currentPos + 2) == '\r' && requestString.charAt(currentPos + 3) == '\n') {
                break;
            }
            currentPos++;
        }
        // System.out.println(headerStart);
        // System.out.println(currentPos);

        resHeaders = requestString.substring(headerStart, currentPos);
        resContents = requestString.substring(currentPos + 4, requestString.length());
        resLine = resLine.replaceAll("\r\n|\r|\n", "");

        String[] strings = resLine.split(" ");
        request.setMethod(strings[0]);
        request.setUri(strings[1]);
        request.setVersion(strings[2].split("/")[1]);
        request.setHeaders(resHeaders);
        request.setRequestContent(resContents);
        // System.out.println(request.getMethod());
        // System.out.println(request.getUri());
        // System.out.println(request.getVersion());

        return request;

    }
}
