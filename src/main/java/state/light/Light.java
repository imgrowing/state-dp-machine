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
        currentState.pushOnButton(this);
    }

    public void pushOffButton() {
        currentState.pushOffButton(this);
    }
}
