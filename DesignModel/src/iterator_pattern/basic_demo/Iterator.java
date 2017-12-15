package iterator_pattern.basic_demo;

/**
 * Created by cmr on 2017/12/15.
 */
public interface Iterator {
    //遍历到下一个元素
    Object next();
    //是否遍历到结尾
    boolean hasNext();
    //删除当前指向的元素
    boolean remove();
}
