package pattern.abstractfactory.decorator;


public class WhiteHuman implements Human {
    private Human human;

    public WhiteHuman(Human human) {
        this.human = human;
    }

    @Override
    public void laugh() {
        System.out.println("白人大笑");
    }

    @Override
    public void cry() {
        System.out.println("白人大哭");
    }

    @Override
    public void talk() {
        System.out.println("白人大喊");
    }

}
