import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private int port;
    private ServerSocket serverSocket;
    private WorkerManager workerManager;

    public Server(int port) throws ClassNotFoundException {
        this.port = port;
        try {
            this.serverSocket = new ServerSocket(this.port);
            workerManager = new WorkerManager();
            workerManager.scanWorkers();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void startServer() throws IOException{
        while(true){
            Socket socket = this.serverSocket.accept();
            SocketHandler socketHandler = new SocketHandler(socket, workerManager);
            Thread handleThread = new Thread(socketHandler);
            handleThread.start();
        }
    }
}
