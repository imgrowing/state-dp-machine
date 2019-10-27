package statemachine.turnstile.action;

import statemachine.fsm.Event;
import statemachine.fsm.EventHandler;

public class LockEventHandler implements EventHandler {

    @Override
    public void handleEvent(Event event) {
        System.out.println("Lock Action - " + event.getName());
    }
}
