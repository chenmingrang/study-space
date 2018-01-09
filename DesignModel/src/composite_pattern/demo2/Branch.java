package composite_pattern.demo2;

import java.util.ArrayList;

/**
 * Created by cmr on 2018/1/9.
 */
public class Branch extends Component {
    private ArrayList<Component> children = new ArrayList<>();

    public Branch(String _name) {
        super(_name);
    }

    @Override
    public void add(Component component) {
        children.add(component);
    }

    @Override
    public void remove(Component component) {
        children.remove(component);
    }

    @Override
    public ArrayList<Component> getChildren() {
        return children;
    }
}
