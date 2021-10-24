import java.util.List;

public interface BinaryTree<T extends Comparable<T>> {

    void insert(T value);

    boolean contains(T value);

    void delete(T value);

    List<T> toInfixList();
    List<T> toPrefixList();
    List<T> toPostfixList();
    T getSuccessor(T val);
    T getPredecessor(T val);
    void print();
}
