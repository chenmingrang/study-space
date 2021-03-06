package iterator_pattern.basic_demo;

import java.util.Vector;

/**
 * Created by cmr on 2017/12/15.
 */
public class ConcreteAggregate implements Aggregate {
    private Vector vector = new Vector();
    @Override
    public void add(Object object) {
        this.vector.add(object);
    }

    @Override
    public void remove(Object object) {
        this.vector.remove(object);
    }

    @Override
    public Iterator iterator() {
        return new ConcreteIterator(this.vector);
    }

    @Override
    public String toString() {
        return "ConcreteAggregate{" +
                "vector=" + vector +
                '}';
    }
}
