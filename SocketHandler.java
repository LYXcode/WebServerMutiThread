import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.net.Socket;

import meta.UrlWorkerMethodMapping;



public class SocketHandler implements Runnable {
    private Socket socket;
    private WorkerManager workerManager;
    BufferedReader bufferedReader;
    BufferedWriter bufferedWriter;

    SocketHandler(Socket socket, WorkerManager workerManager ) throws IOException {
        this.socket = socket;
        this.workerManager = workerManager;
        this.bufferedReader = new BufferedReader(new InputStreamReader(this.socket.getInputStream(), "UTF-8"));
        this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream()));
    }

    @Override
    public void run() {
        

            String requestString = "";
            try {
                while(this.bufferedReader.ready() || requestString.length() == 0){
                    requestString += (char)this.bufferedReader.read();
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
          System.out.println(requestString);
          Request request = utils.parseRequestString(requestString);
          UrlWorkerMethodMapping urlWorkerMethodMapping = (UrlWorkerMethodMapping) workerManager.Mapping.get(request.getUri());
          System.out.println(urlWorkerMethodMapping.getClassName());
          try {
            Object object = urlWorkerMethodMapping.getClassName().newInstance();
            Object result = urlWorkerMethodMapping.getMethodName().invoke(object);
            String response = "http/1.1 200 ok\r\n"+"\r\n"+ result;
            System.out.println(response);
            this.bufferedWriter.write(response);
            this.bufferedWriter.flush();
            this.bufferedWriter.close();
            System.out.println(result);
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // String response = "http/1.1 200 ok\n"+"\n\n"+ reponse;
        // System.out.println(response);
          
            

    
}
}
