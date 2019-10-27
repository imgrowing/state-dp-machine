package state.light;

public class Launcher {
    public static void main(String[] args) {
        LightState lightOffState = LightOffState.getInstance();
        Light light = new Light(lightOffState);

        System.out.println("\n>>> push on button");
        light.pushOnButton();
        System.out.println("\n>>> push on button");
        light.pushOnButton();

        System.out.println("\n>>> push off button");
        light.pushOffButton();
        System.out.println("\n>>> push off button");
        light.pushOffButton();
    }
}
