package factory_pattern.simpleFactory;

public abstract class AbstractHumanFactory {
public abstract <T extends Human> T createHuman(Class<T> c);
}
