package adapter_pattern.extend_demo;

/**
 * Created by cmr on 2017/12/14.
 */
public class OuterUserInfo implements IUserInfo {
    private IOuterUserBaseInfo baseInfo;
    private IOuterUserHomeInfo homeInfo;
    private IOuterUserOfficeInfo officeInfo;

    public OuterUserInfo(IOuterUserBaseInfo _baseInfo, IOuterUserHomeInfo _homeInfo,
           IOuterUserOfficeInfo _officeInfo) {
        this.baseInfo = _baseInfo;
        this.homeInfo = _homeInfo;
        this.officeInfo = _officeInfo;
    }

    @Override
    public String getUsername() {
        return  (String) baseInfo.getUserBaseInfo().get("username");
    }

    @Override
    public String getMobileNumber() {
        return (String)baseInfo.getUserBaseInfo().get("mobileNumber");
    }

    @Override
    public String getHomeAddress() {
        return (String)homeInfo.getUserHomeInfo().get("homeAddress");
    }

    @Override
    public String getHomePosition() {
        return (String)homeInfo.getUserHomeInfo().get("homePosition");
    }

    @Override
    public String getOfficeCity() {
        return (String)officeInfo.getUserOfficeInfo().get("officeCity");
    }

    @Override
    public String getOfficePosition() {
        return (String)officeInfo.getUserOfficeInfo().get("officePosition");
    }
}
