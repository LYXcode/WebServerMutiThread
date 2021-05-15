package workers;

import annotations.Route;
import annotations.Worker;
@Worker
public class MyThirdWorker {
    
    @Route("/thirdWorker/action")
    public void action(){
        System.out.println("action called");
    }
}
