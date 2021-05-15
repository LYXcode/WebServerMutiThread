import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
   
    public static void main(String[] args) throws IOException, ClassNotFoundException {
       Server server = new Server(4999);
       server.startServer();


    }

}
