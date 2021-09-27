package pattern.factorymethod;

public class YellowHuman implements Human {

    public void cry() {
        System.out.println("黄色人类会哭");
    }

    public void laugh() {
        System.out.println("黄色人类会大笑，幸福呀！");
    }

    public void talk() {
        System.out.println("黄色人类会说话，一般说的都是双字节");
    }
}
