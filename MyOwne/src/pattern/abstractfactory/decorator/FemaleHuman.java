package pattern.abstractfactory.decorator;

public class FemaleHuman implements Human{

    private Human human;

    public FemaleHuman(Human human) {
        this.human = human;
    }

    @Override
    public void laugh() {
        System.out.print("女性");
        human.laugh();
    }

    @Override
    public void cry() {
        System.out.print("女性");
        human.cry();
    }

    @Override
    public void talk() {
        System.out.print("女性");
        human.talk();
    }
}
