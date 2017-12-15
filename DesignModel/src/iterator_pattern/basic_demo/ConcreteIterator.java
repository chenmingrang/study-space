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
        Object result;
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
        //游标返回遍历前的位置
        this.vector.remove(this.cursor-1);
        this.cursor--;
        return true;
    }
}
