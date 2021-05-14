import java.io.*;
import java.net.Socket;


public class SocketHandler implements Runnable {
    private Socket socket;
    BufferedReader bufferedReader;
    BufferedWriter bufferedWriter;

    SocketHandler(Socket socket) throws IOException {
        this.socket = socket;
        this.bufferedReader = new BufferedReader(new InputStreamReader(this.socket.getInputStream(), "UTF-8"));
        this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream()));
    }

    @Override
    public void run() {
        try {

            String requestString = "";
            while(this.bufferedReader.ready() || requestString.length() == 0){
                requestString += (char)this.bufferedReader.read();
            }
          System.out.println(requestString);
          Request request = utils.parseRequestString(requestString);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
