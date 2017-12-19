package composite_pattern.demo1;

import java.util.ArrayList;

/**
 * Created by cmr on 2017/12/19.
 */
public class Branch extends Corp {
    private ArrayList<Corp> subordinateList = new ArrayList<>();

    public Branch(String name, String position, int salary) {
        super(name, position, salary);
    }

    public void addSubordinate(Corp corp){
        this.subordinateList.add(corp);
    }

    public ArrayList<Corp> getSubordinate(){
        return this.subordinateList;
    }
}
