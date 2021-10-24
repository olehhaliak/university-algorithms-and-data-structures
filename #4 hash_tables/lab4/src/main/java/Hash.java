public interface Hash<T> {
    void insert(int key, T value);

    T search(int key);

    void delete(int key);

    void show();
}
