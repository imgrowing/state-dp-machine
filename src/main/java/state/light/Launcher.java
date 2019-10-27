package state.light;

public class Launcher {
    public static void main(String[] args) {
        LightState lightOffState = LightOffState.getInstance();
        Light light = new Light(lightOffState);

        System.out.println(">>> push on button");
        light.pushOnButton();
        System.out.println(">>> push on button");
        light.pushOnButton();

        System.out.println(">>> push off button");
        light.pushOffButton();
        System.out.println(">>> push off button");
        light.pushOffButton();
    }
}
