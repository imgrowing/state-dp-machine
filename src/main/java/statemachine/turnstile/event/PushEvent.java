package statemachine.turnstile.event;

import statemachine.fsm.Event;

public class PushEvent implements Event {
    @Override
    public String getName() {
        return "PushEvent";
    }
}
