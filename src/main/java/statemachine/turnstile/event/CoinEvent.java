package statemachine.turnstile.event;

import statemachine.fsm.Event;

public class CoinEvent implements Event {
    @Override
    public String getName() {
        return "CoinEvent";
    }
}
