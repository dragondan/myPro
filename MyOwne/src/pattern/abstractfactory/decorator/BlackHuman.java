package pattern.abstractfactory.decorator;


public class BlackHuman implements Human {
    private Human human;

    public BlackHuman(Human human) {
        this.human = human;
    }

    @Override
    public void laugh() {
        System.out.print("黑人");
        human.laugh();
    }

    @Override
    public void cry() {
        System.out.print("黑人");
        human.cry();
    }

    @Override
    public void talk() {
        System.out.print("黑人");
        human.talk();
    }

}
