package iterator_pattern.basic_demo;

/**
 * Created by cmr on 2017/12/15.
 */
public interface Aggregate {
    void add(Object object);
    void remove(Object object);
    Iterator iterator();
}
