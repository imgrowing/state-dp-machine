package state.light;

public class LightOffState implements LightState {

    public static LightState instance = new LightOffState();

    private LightOffState() {
    }

    public static LightState getInstance() {
        return instance;
    }

    @Override
    public void pushOnButton(Light light) {
        System.out.println("Light On");
        light.changeState(LightOnState.getInstance());
    }

    @Override
    public void pushOffButton(Light light) {
        System.out.println("Already Off");
    }

    @Override
    public String toString() {
        return "LightOffState !!!";
    }
}
