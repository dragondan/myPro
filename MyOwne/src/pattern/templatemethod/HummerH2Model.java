package pattern.templatemethod;

public class HummerH2Model extends HummerModel {
    @Override
    protected void alarm() {
        System.out.println("悍马H2鸣笛...");
    }
    @Override
    protected void engineBoom() {
        System.out.println("悍马H2引擎声音是这样在...");
    }
    @Override
    protected void start() {
        System.out.println("悍马H2发动...");
    }
    @Override
    protected void stop() {
        System.out.println("悍马H1停车...");
    }


    //默认没有喇叭的
    @Override
    protected boolean isAlarm() {
        return false;
    }
}
