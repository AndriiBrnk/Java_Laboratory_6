package repository;

@FunctionalInterface
public interface IdentityExtractor<T> {
    int extract(T object);
}
