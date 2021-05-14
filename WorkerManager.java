import java.io.File;

import jdk.nashorn.internal.ir.Block;

public class WorkerManager {

    static{
        System.out.println("static block excuted");
    }

    {
        System.out.println("non_static excuted");
    }
    public void scanWorkers(){
        Class class1 = WorkerManager.class;
        System.out.println(class1);
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
