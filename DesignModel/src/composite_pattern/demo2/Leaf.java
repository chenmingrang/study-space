package composite_pattern.demo2;

import java.util.ArrayList;

/**
 * Created by cmr on 2018/1/9.
 * 透明的组合模式
 * 叶子节点添加子节点的方法不可用
 */
public class Leaf extends Component {

    public Leaf(String _name) {
        super(_name);
    }

    @Deprecated
    public void add(Component component) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public void remove(Component component) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public ArrayList<Component> getChildren() {
        throw new UnsupportedOperationException();
    }
}
