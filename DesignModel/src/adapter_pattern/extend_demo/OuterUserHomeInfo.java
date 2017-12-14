package adapter_pattern.extend_demo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cmr on 2017/12/14.
 */
public class OuterUserHomeInfo implements IOuterUserHomeInfo {
    @Override
    public Map getUserHomeInfo() {
        HashMap homeInfoMap = new HashMap();
        homeInfoMap.put("homeAddress", "henan zhengzhou");
        homeInfoMap.put("homePosition", "yongpingRoad");
        return homeInfoMap;
    }
}
