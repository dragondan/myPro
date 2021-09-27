package pattern.abstractfactory.decorator;

public class HumanImpl implements Human{
    @Override
    public void laugh() {
        System.out.println("大笑");
    }

    @Override
    public void cry() {
        System.out.println("大哭");

    }

    @Override
    public void talk() {
        System.out.println("大喊");
    }
}
