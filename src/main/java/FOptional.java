import java.util.function.Function;

public class FOptional<T> implements Functor<T, FOptional<?>> {

    private final T valueOrNull;

    private FOptional(T valueOrNull){
        this.valueOrNull = valueOrNull;
    }

    public <R> FOptional<R> of (Function<T, R> f) {
        if (valueOrNull == null) {
            return empty();
        } else {
            return of(f.apply(valueOrNull));
        }
    }

    public static <T> FOptional<T> of(T t) {
        return new FOptional<>(t);
    }

    public static <T> FOptional<T> empty() {
        return new FOptional<>(null);
    }


    @Override
    public <R> FOptional<R> map(Function<T, R> f) {
        return null;
    }
}
