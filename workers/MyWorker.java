package workers;

import annotations.*;
@Worker
@Route("/firstWorker")
public class MyWorker {
    @Route("/action")
    public void action(){
        System.out.println("action called");
    }
    
}
