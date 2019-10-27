package statemachine.turnstile;

import statemachine.fsm.FiniteStateMachine;
import statemachine.fsm.State;
import statemachine.fsm.Transition;
import statemachine.turnstile.action.LockEventHandler;
import statemachine.turnstile.action.NoOpEventHandler;
import statemachine.turnstile.action.UnlockEventHandler;
import statemachine.turnstile.event.CoinEvent;
import statemachine.turnstile.event.PushEvent;
import statemachine.turnstile.state.LockedState;
import statemachine.turnstile.state.UnlockedState;

import java.util.HashSet;
import java.util.Set;

public class Launcher {

    public static void main(String[] args) {

        // FiniteStateMachine 초기화
        LockedState lockedState = new LockedState();
        UnlockedState unlockedState = new UnlockedState();

        Set<State> states = new HashSet<>();
        states.add(lockedState);
        states.add(unlockedState);

        CoinEvent coinEvent = new CoinEvent();
        PushEvent pushEvent = new PushEvent();

        LockEventHandler lockAction = new LockEventHandler();
        UnlockEventHandler unlockAction = new UnlockEventHandler();
        NoOpEventHandler noOpAction = new NoOpEventHandler();

        /**
         * Transition
         * State
         * Locked   + Push  -> N/A,     Locked
         * Locked   + Coin  -> Unlock,  Unlocked
         * Unlocked + Coin  -> N/A,     Unlocked
         * Unlocked + Push  -> Lock,    Locked
         */

        Transition lockedPush = Transition.builder()
                .name("lockedPush")
                .sourceState(lockedState)
                .event(pushEvent)
                .eventHandler(noOpAction)
                .targetState(lockedState)
                .build();
        Transition lockedCoin = Transition.builder()
                .name("lockedCoin")
                .sourceState(lockedState)
                .event(coinEvent)
                .eventHandler(unlockAction)
                .targetState(unlockedState)
                .build();
        Transition unlockedCoin = Transition.builder()
                .name("unlockedCoin")
                .sourceState(unlockedState)
                .event(coinEvent)
                .eventHandler(noOpAction)
                .targetState(unlockedState)
                .build();
        Transition unlockedPush = Transition.builder()
                .name("unlockedPush")
                .sourceState(unlockedState)
                .event(pushEvent)
                .eventHandler(lockAction)
                .targetState(lockedState)
                .build();

        FiniteStateMachine fsm = new FiniteStateMachine(states, lockedState);
        fsm.registerTransition(lockedPush);
        fsm.registerTransition(lockedCoin);
        fsm.registerTransition(unlockedCoin);
        fsm.registerTransition(unlockedPush);

        fsm.fire(pushEvent);
        fsm.fire(coinEvent);
        fsm.fire(coinEvent);
        fsm.fire(pushEvent);

    }
}
