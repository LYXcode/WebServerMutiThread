import java.io.IOException;



public class test {
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println(Class.forName("WorkerManager"));

        WorkerManager workerManager = new WorkerManager();
        // workerManager.getClass();
        // workerManager.getClass();
        try {
            workerManager.scanWorkers();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
