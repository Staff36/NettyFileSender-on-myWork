import java.util.Scanner;

public class Controller {
    public Controller() {
        InboundMessage inboundMessage = new InboundMessage(this);
        NetworkHandler networkHandler = new NetworkHandler(inboundMessage.getCallback());
        Thread thread = new Thread(networkHandler);
        thread.start();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String s = scanner.nextLine();
            networkHandler.writeToChannel(s);
        }
    }
    public void print(String s){
        System.out.println(s);
    }
}
