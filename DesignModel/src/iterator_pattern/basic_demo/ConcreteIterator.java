package iterator_pattern.basic_demo;

import java.util.Vector;

/**
 * Created by cmr on 2017/12/15.
 */
public class ConcreteIterator implements Iterator {

    private Vector vector = new Vector();
    public int cursor = 0;

    public ConcreteIterator(Vector _vector){
        this.vector =_vector;
    }

    @Override
    public Object next() {
        Object result = null;
        if(hasNext()){
            result = this.vector.get(this.cursor++);
        }else {
            result = null;
        }
        return result;
    }

    @Override
    public boolean hasNext() {
        if(this.cursor == vector.size()){
            return false;
        }
        return true;
    }

    @Override
    public boolean remove() {
        this.vector.remove(this.cursor);
        return true;
    }
}
