package pattern.abstractfactory.decorator;

public class MaleHuman implements Human{

    private Human human;

    public MaleHuman(Human human) {
        this.human = human;
    }

    @Override
    public void laugh() {
        System.out.print("男性");
        human.laugh();
    }

    @Override
    public void cry() {
        System.out.print("男性");
        human.cry();
    }

    @Override
    public void talk() {
        System.out.print("男性");
        human.talk();
    }
}
