package meta;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Time;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Server {
    private int port;
    private ServerSocket serverSocket;
    private WorkerManager workerManager;

    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 100;
    private static final Long KEEP_ALIVE_TIME = 1L;
    

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

        ThreadPoolExecutor executor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.SECONDS, new ArrayBlockingQueue<>(QUEUE_CAPACITY), new ThreadPoolExecutor.CallerRunsPolicy());

        while(true){
            Socket socket = this.serverSocket.accept();
            SocketHandler socketHandler = new SocketHandler(socket, workerManager);
            // Thread handleThread = new Thread(socketHandler);
            // handleThread.start();

            executor.execute(socketHandler);
        }

    }
}
