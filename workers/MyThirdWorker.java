package workers;

import annotations.Route;
import annotations.Worker;
@Worker
public class MyThirdWorker {
    
    @Route("/thirdWorker/action")
    public String action(){
        System.out.println("action called");

        return "nihaoya";
    }
}
