package pattern.adapter;

public class AdapterMain {
    public static void main(String[] args) {
        //没有与外系统连接的时候，是这样写的
        IUserInfo youngGirl = new UserInfo();
        //从数据库中查到101个
        for(int i=0;i<10;i++){
            youngGirl.getMobileNumber();
        }
        youngGirl = new OuterUserInfo(); //我们只修改了这一句好
        //从数据库中查到101个
        for(int i=0;i<10;i++){
            youngGirl.getMobileNumber();
        }
    }
}
