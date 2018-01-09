package composite_pattern.demo2;

import java.util.ArrayList;

/**
 * Created by cmr on 2018/1/9.
 */
public abstract class Component {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Component(String _name){
        this.name = _name;
    }

    public void doSomething(){}

    public abstract void add(Component component);

    public abstract void remove(Component component);

    public abstract ArrayList<Component> getChildren();

}
