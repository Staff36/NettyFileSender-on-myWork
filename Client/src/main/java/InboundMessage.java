import lombok.Data;

import java.util.function.Consumer;
@Data
public class InboundMessage {
    Controller controller;
    Consumer<Object> callback;

    public InboundMessage(Controller controller) {
        callback = this::HandleMessages;
        this.controller = controller;
    }

    public void HandleMessages(Object o){
        if (o == null) {
            return;
        }
        if (o instanceof String) {
            controller.print(o.toString());
        }
    }
}
