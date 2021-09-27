package pattern.singleton;

public class Emperor {
    private static Emperor emperor = null; //定义一个皇帝放在那里，然后给这个皇帝名字

    private Emperor() {
        //世俗和道德约束你，目的就是不让你产生第二个皇帝
    }

    public static Emperor getInstance() {
        if (emperor == null) { //如果皇帝还没有定义，那就定一个
            emperor = new Emperor();
        }
        return emperor;
    }

    //皇帝叫什么名字呀
    public static void emperorInfo() {
        System.out.println("我就是皇帝某某某....");

    }


}
