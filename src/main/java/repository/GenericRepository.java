package repository;


import java.util.*;
import java.util.logging.Logger;

public class GenericRepository<T extends Comparable<T>> {
    private final List<T> data = new ArrayList<>();
    private final IdentityExtractor<T> extractor;
    private static final Logger log = Logger.getLogger(GenericRepository.class.getName());

    public GenericRepository(IdentityExtractor<T> extractor) {
        this.extractor = extractor;
    }

    public void add(T obj) {
        int id = extractor.extract(obj);
        if (findByIdentity(id).isPresent()) {
            log.warning("Найдено дублікат: " + id);
            return;
        }
        data.add(obj);
        log.info("Добавлено: " + id);
    }

    public List<T> getAll() {
        return Collections.unmodifiableList(data);
    }

    public void remove(T obj) {
        data.remove(obj);
        log.info("Видалено: " + extractor.extract(obj));
    }

    public Optional<T> findByIdentity(int id) {
        return data.stream()
                .filter(e -> extractor.extract(e) == id)
                .findFirst();
    }

    // 5
    public void sortByIdentity(String order) {
        if (order.equalsIgnoreCase("asc")) {
            Collections.sort(data);
        } else if (order.equalsIgnoreCase("desc")) {
            Collections.sort(data, Collections.reverseOrder());
        }
        // тут можна додати логування
        System.out.println("Виконано сортування за основним полем у порядку: " + order);
    }
}
