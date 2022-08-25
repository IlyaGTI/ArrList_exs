public interface ArrList<T> extends Iterable<T>{

    void add(T element);

    void add(T element, int index);

    void delete(T element);

    void mergeSort(T[] array, int start, int finish);

    T[] get();

    int length();

    T get(int index);

}
