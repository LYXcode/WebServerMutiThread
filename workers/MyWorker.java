package workers;

import annotations.*;
@Worker
@Route("/firstWorker")
public class MyWorker {

    int a = 10;
    @Route("/action")
    public String action(){
        System.out.println("action called");

        return "hello world";
    }
    
}
