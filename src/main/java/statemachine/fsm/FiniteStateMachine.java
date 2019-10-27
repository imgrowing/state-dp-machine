package statemachine.fsm;

import java.util.HashSet;
import java.util.Set;

public class FiniteStateMachine {
    private Set<State> states;
    private Set<State> finalStates;
    private State currentState;
    private Set<Transition> transitions;
    private Event lastEvent;
    private Transition lastTransit;

    public FiniteStateMachine(Set<State> states, State currentState) {
        this.states = states;
        this.finalStates = new HashSet<>();
        setCurrentState(currentState);
        this.transitions = new HashSet<>();
    }

    private void setCurrentState(State currentState) {
        System.out.println("State change: " +
                (this.currentState != null ? this.currentState.getName() : "NULL")
                + " -> " + currentState.getName());
        this.currentState = currentState;
    }

    public void registerTransition(Transition transition) {
        this.transitions.add(transition);
    }

    public State fire(Event event) {
        if (finalStates.contains(currentState)) {
            System.out.println("WARNING: FSM is in final state(" + currentState.getName() + "). event(" + event.getName() + ") is ignored.");
            return currentState;
        }

        System.out.println("\nCurrent state: " + this.currentState.getName() + " -> " + event.getName());

        Transition transition = transitions.stream()
                .filter(t -> t.getSourceState().equals(this.currentState))
                .filter(t -> t.getEvent().equals(event))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Unsupported Event"));

        System.out.println("Transition: " + transition.getName());
        transition.getEventHandler().handleEvent(event);

        this.setCurrentState(transition.getTargetState());
        this.lastEvent = event;
        this.lastTransit = transition;
        return this.currentState;
    }
}
