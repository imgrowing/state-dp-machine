package statemachine.fsm;

import lombok.Builder;
import lombok.Getter;

/**
 * State(S) + Event -> Action(EventHandler), State(S')
 */
@Builder
@Getter
public class Transition {

    private String name;
    private State sourceState;
    private Event event;
    private EventHandler eventHandler;
    private State targetState;

}
