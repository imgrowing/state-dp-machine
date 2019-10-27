package statemachine.turnstile.action;

import statemachine.fsm.Event;
import statemachine.fsm.EventHandler;

public class NoOpEventHandler implements EventHandler {

    @Override
    public void handleEvent(Event event) {
        System.out.println("No Op Action - " + event.getName());
    }
}
