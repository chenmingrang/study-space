package iterator_pattern.basic_demo;

import javax.sound.midi.Soundbank;

/**
 * Created by cmr on 2017/12/15.
 */
public class Client {
    public static void main(String[] args) {
        Aggregate agg = new ConcreteAggregate();

        agg.add("abc");
        agg.add("123");
        agg.add("xyz");

        Iterator iterator = agg.iterator();
        while (iterator.hasNext()){
            Object obj = iterator.next();
            System.out.println(obj);
            if("xyz".equals(obj)){
                iterator.remove();
            }
        }
        System.out.println(agg.toString());
    }
}
