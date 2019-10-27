package state.light;

public class Light {
    private LightState currentState;

    public Light(LightState state) {
        this.currentState = state;
        System.out.println("Current State : " + currentState);
    }

    public void setLightState(LightState state) {
        this.currentState = state;
    }

    public void pushOnButton() {
        System.out.println("Current State : " + currentState);
        currentState.pushOnButton(this);
    }

    public void pushOffButton() {
        System.out.println("Current State : " + currentState);
        currentState.pushOffButton(this);
    }
}
