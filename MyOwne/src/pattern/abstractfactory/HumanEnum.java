package pattern.abstractfactory;

public enum HumanEnum {
    //把世界上所有人类型都定义出来
    YelloMaleHuman("pattern.abstractfactory.YellowMaleHuman"),

    YelloFemaleHuman("pattern.abstractfactory.YellowFemaleHuman"),

    WhiteFemaleHuman("pattern.abstractfactory.WhiteFemaleHuman"),

    WhiteMaleHuman("pattern.abstractfactory.WhiteMaleHuman"),

    BlackFemaleHuman("pattern.abstractfactory.BlackFemaleHuman"),

    BlackMaleHuman("pattern.abstractfactory.BlackMaleHuman");
    private String value = "";
    //定义构造函数，目的是Data(value)类型的相匹配
    private HumanEnum(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }
}
