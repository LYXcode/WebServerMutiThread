package workers;

import annotations.Route;
import annotations.Worker;
@Worker
@Route("/secondWorker")
public class MySecondWorker {
    @Route("/action")
    public void action(){
        System.out.println("action called");
    }
}
