package composite_pattern.demo1;

/**
 * Created by cmr on 2017/12/19.
 */
public abstract class Corp {
    private String name;
    private String position;
    private int salary;

    public Corp(String name, String position, int salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String getInfo() {
        return "Corp{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}
