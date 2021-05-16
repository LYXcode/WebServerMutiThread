package workers;
import annotations.Route;
import annotations.Worker;

@Worker
@Route("/forthWorker")
public class Forth {
    @Route("/action")
    public String action(){
        System.out.println("action called");
        return "forth";
    }
}