package com.ejb.sfsb.remote;

import javax.ejb.Stateful;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/12 0012.
 */
@Stateful(mappedName = "StatefulBeanEJB")
public class StatefulBeanBean implements StatefulBeanRemote{
    private List<String> bookList;
    public StatefulBeanBean(){
        bookList = new ArrayList<String>();
    }
    @Override
    public void add(String name) {
        bookList.add(name);
    }

    @Override
    public List<String> list() {
        return bookList;
    }
}
