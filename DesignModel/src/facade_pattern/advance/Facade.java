package facade_pattern.advance;

/**
 * Created by cmr on 2018/1/10.
 */
public class Facade {
    private ClassA a = new ClassA();
    private ClassB b = new ClassB();
    private Context context = new Context();

    public void methodA(){
        this.a.doSomethingA();
    }

    public void methodB(){
        b.doSomethingB();
    }

    public void complexMethod(){
        context.complexMethod();
    }

}
