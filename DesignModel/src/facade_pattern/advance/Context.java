package facade_pattern.advance;

/**
 * Created by cmr on 2018/1/10.
 */
public class Context {
    private ClassA a = new ClassA();
    private ClassC c = new ClassC();

    public void complexMethod(){
        System.out.println("complexMethod is calling ...");
        this.a.doSomethingA();
        this.c.doSomethingC();
    }

}
