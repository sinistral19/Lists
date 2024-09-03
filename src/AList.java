import java.util.Collection;

public abstract class AList<T>{
    public abstract void add(T el);
    public abstract void addAll(Collection<T> list);
    public abstract <T> T get(int i);
    public abstract void set(int i,T value);
    public abstract void remove(int i);
    public abstract void sort();
}

