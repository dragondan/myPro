package pattern.abstractfactory.decorator;


public class DecoratorMain {
    public static void main(String[] args) {
        Human human = new MaleHuman(new BlackHuman(new HumanImpl()));
        human.cry();
        human.talk();
        human.laugh();
    }
}
