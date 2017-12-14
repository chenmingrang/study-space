package adapter_pattern.extend_demo;

/**
 * Created by cmr on 2017/12/14.
 */
public class Client {
    public static void main(String[] args){
        IOuterUserBaseInfo baseInfo = new OuterUserBaseInfo();
        IOuterUserHomeInfo homeInfo = new OuterUserHomeInfo();
        IOuterUserOfficeInfo officeInfo = new OuterOfficeInfo();

        IUserInfo userInfo = new OuterUserInfo(baseInfo, homeInfo, officeInfo);
        System.out.println(userInfo.getUsername());
        System.out.println(userInfo.getMobileNumber());
        System.out.println(userInfo.getHomeAddress());
        System.out.println(userInfo.getHomePosition());
        System.out.println(userInfo.getOfficeCity());
        System.out.println(userInfo.getOfficePosition());
    }
}
