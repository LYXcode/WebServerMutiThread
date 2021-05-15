import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

import javax.print.DocFlavor.STRING;

import annotations.Route;
import annotations.Worker;

public class WorkerManager {

    ArrayList<String> classArrayList = new ArrayList<String>();
    HashMap<Class<?>, Object> workerPool = new HashMap<Class<?>, Object>();
    ArrayList<Class<?>> workerClassNames = new ArrayList<Class<?>>();

    public void scanWorkers() throws IOException, ClassNotFoundException {
        String classPath = WorkerManager.class.getResource("/").getPath();
        System.out.println(classPath);

        // 搜索classpath路径下的所有的.class文件
        findAllClassFile(classPath);
        findAllWorker(classPath);
        // System.out.println(workerClassNames);
        parseUrlWorkerMapping();

    }

    public void parseUrlWorkerMapping() {
        for (int i = 0; i < workerClassNames.size(); i++) {
            Class<?> worker = workerClassNames.get(i);
            Route route = worker.getAnnotation(Route.class);
            String classRoute = "";
            if (route != null) {
                classRoute = route.value();
            }
            else{
                classRoute = "";
            }

            Method[] methods = worker.getMethods();
            System.out.println(methods);
            for(int j = 0; j<methods.length;j++){
                String methodURL = "";
                Route methodRoute = methods[j].getAnnotation(Route.class);
                if(methodRoute == null){
                    methodURL = "";
                    continue;
                }
                else{
                    methodURL = classRoute + methodRoute.value();
                }
                
                System.out.println(methodURL);
            }

        }
    }

    public void findAllWorker(String classPath) throws ClassNotFoundException {
        for (int i = 0; i < classArrayList.size(); i++) {
            String className = classArrayList.get(i).replace(classPath, "").replace("/", ".").replace(".class", "");

            Class<?> class1 = Class.forName(className);

            Annotation[] annotations = class1.getAnnotationsByType(Worker.class);
            if (annotations.length != 0) {
                workerClassNames.add(class1);

            }

        }
    }

    public void findAllClassFile(String rootPath) throws IOException {
        File[] files = new File(rootPath).listFiles();

        for (File file : files) {
            if (file.isDirectory()) {

                findAllClassFile(file.getAbsolutePath());
            }
            if (file.isFile()) {

                if (file.getName().endsWith(".class")) {
                    String classPath = "\\" + file.getPath();
                    classPath = classPath.replace("\\", "/");

                    classArrayList.add(classPath);
                    // System.out.println("\\" + file.getPath());
                }

            }
        }
    }
}
