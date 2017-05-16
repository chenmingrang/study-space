package com.ejb.sfsb.remote;

import javax.ejb.Remote;
import java.util.List;

/**
 * Created by Administrator on 2017/5/12 0012.
 */
@Remote
public interface StatefulBeanRemote {
    void add(String name);
    List<String> list();
}
