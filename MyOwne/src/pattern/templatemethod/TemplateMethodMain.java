package pattern.templatemethod;

public class TemplateMethodMain {
    public static void main(String[] args) {
        //客户开着H1型号，出去遛弯了
        HummerH1Model h1 = new HummerH1Model();
        h1.setAlarm(true);
        h1.run(); //汽车跑起来了；

    }
}
