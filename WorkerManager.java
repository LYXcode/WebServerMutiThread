import java.io.File;


public class WorkerManager {

    static{
        System.out.println("static block excuted");
    }

    {
        System.out.println("non_static excuted");
    }
    public void scanWorkers(){
        String classPath = WorkerManager.class.getResource("/").toString();
        System.out.println(classPath);
        File[] classFiles = new File(".\\workers").listFiles();
        for(File classFile:classFiles){
            if(classFile.isFile()){
                if(classFile.getName().endsWith(".class")){
                    System.out.println(classFile.getName());
                }
            }
        }
    }
}
