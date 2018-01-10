package facade_pattern.common;

/**
 * Created by cmr on 2018/1/10.
 */
public class Facade {
    private ClassA a = new ClassA();
    private ClassB b = new ClassB();
    private ClassC c = new ClassC();

    public void methodA(){
        this.a.doSomethingA();
    }

    public void methodB(){
        b.doSomethingB();
    }

    public void methodC(){
        c.doSomethingC();
    }
}
