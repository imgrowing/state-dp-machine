package statemachine.turnstile.action;

import statemachine.fsm.Event;
import statemachine.fsm.EventHandler;

public class UnlockEventHandler implements EventHandler {

    @Override
    public void handleEvent(Event event) {
        System.out.println("Unlock  Action - " + event.getName());
    }
}
