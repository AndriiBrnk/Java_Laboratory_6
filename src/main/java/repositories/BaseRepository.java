package repositories;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseRepository<T> {

    protected final List<T> data = new ArrayList<>();

    public void add(T item) {
        data.add(item);
    }

    public void addAll(List<T> items) {
        data.addAll(items);
    }

    public List<T> getAll() {
        return data;
    }
}