package adapter_pattern.extend_demo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cmr on 2017/12/14.
 */
public class OuterUserBaseInfo implements IOuterUserBaseInfo{

    @Override
    public Map getUserBaseInfo() {
        HashMap baseInfoMap = new HashMap();
        baseInfoMap.put("username", "Micheal Jordan");
        baseInfoMap.put("mobileNumber", "12345671234");
        return baseInfoMap;
    }
}
