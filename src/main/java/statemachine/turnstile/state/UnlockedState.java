package statemachine.turnstile.state;

import statemachine.fsm.State;

public class UnlockedState implements State {
    @Override
    public String getName() {
        return "UnlockedState";
    }
}
