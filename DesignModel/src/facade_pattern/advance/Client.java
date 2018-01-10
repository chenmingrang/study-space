package facade_pattern.advance;

/**
 * Created by cmr on 2018/1/10.
 */
public class Client {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.methodA();
        facade.methodB();
        facade.complexMethod();
    }
}
