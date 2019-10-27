package statemachine.turnstile.state;

import statemachine.fsm.State;

public class LockedState implements State {
    @Override
    public String getName() {
        return "LockedState";
    }
}
