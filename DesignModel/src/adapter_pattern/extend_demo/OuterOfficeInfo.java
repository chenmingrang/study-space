package adapter_pattern.extend_demo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cmr on 2017/12/14.
 */
public class OuterOfficeInfo implements IOuterUserOfficeInfo {
    @Override
    public Map getUserOfficeInfo() {
        HashMap officeInfoMap = new HashMap();
        officeInfoMap.put("officeCity", "zhengzhou");
        officeInfoMap.put("officePosition", "jinshuiRoad");
        return officeInfoMap;
    }
}
