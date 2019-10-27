package state.light;

public class LightOnState implements LightState {

    public static LightState instance = new LightOnState();

    private LightOnState() {
    }

    public static LightState getInstance() {
        return instance;
    }

    @Override
    public void pushOnButton(Light light) {
        System.out.println("Already On");
    }

    @Override
    public void pushOffButton(Light light) {
        System.out.println("Light Off");
        light.changeState(LightOffState.getInstance());
    }

    @Override
    public String toString() {
        return "LightOnState !!!";
    }
}
