public class ArrListImpl<T> implements ArrList<T>{

    private T[] elements = (T[]) new Object[12];
    private int size = 0;

    @Override
    public void add(T element) {
        if (size >= elements.length) {
            T[] newArray = (T[]) new Object[elements.length * 2];
            for (int i = 0; i < elements.length; i++) {
                newArray = elements;
            }
            elements = newArray;
        }
        elements[size] = element;
        size++;
    }

    @Override
    public void add(T element, int index) {
       for (int i = size; i > index; i--) {
           elements[i] = elements[i - 1];
       }
       elements[index] = element;
       size++;
    }

    @Override
    public void delete(T element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                for (int j = i; j < size - 1; j++) {
                    elements[j] = elements[j + 1];
                }
                size--;
            }
        }
    }
}
