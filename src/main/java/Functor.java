import java.util.function.Function;

// A functor is a typed data structure that encapsulates some value(s).
public interface Functor<T, F extends Functor<?,?>> {
    // This function receives whatever is inside a box
    // transforms it and wraps the result as-is into a second functor.
    <R> F map(Function<T, R> f);
}

class Identity<T> implements Functor<T, Identity<?>> {
    private T value;

    Identity(T value) {this.value = value;}

    @Override
    public <R> Identity<R> map(Function<T, R> f) {
        final R result = f.apply(value);
        return new Identity<>(result);
    }

    public T get() {
        return value;
    }
}
