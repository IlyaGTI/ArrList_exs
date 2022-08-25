import java.util.Iterator;

public class ArrListImpl<T extends Comparable<? super T>> implements ArrList<T> {

    private T[] elements = (T[]) new Comparable[12];
    private int size = 0;

    @Override
    public void add(T element) {
        if (size >= elements.length) {
            T[] newArray = (T[]) new Comparable[elements.length * 2];
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

    @Override
    public T[] get() {
        return elements;
    }

    @Override
    public int length() {
        return elements.length;
    }

    @Override
    public void mergeSort(T[] array, int start, int end)
    {
        if (start < end)
        {
            int middle = (start + end) / 2;
            mergeSort(array, start, middle);
            mergeSort(array, middle + 1, end);
            merge(array, start, middle, end);
        }
    }

    public void merge(T[] array, int start, int middle, int end)
    {
        T[] leftArray  = (T[]) new Comparable[middle - start + 1];
        T[] rightArray = (T[]) new Comparable[end - middle];

        for (int i = 0; i < leftArray.length; ++i)
            leftArray[i] = array[start + i];

        for (int i = 0; i < rightArray.length; ++i)
            rightArray[i] = array[middle + 1 + i];

        int leftIndex = 0, rightIndex = 0;
        int currentIndex = start;
        while (leftIndex < leftArray.length && rightIndex < rightArray.length)
        {
            if (leftArray[leftIndex].compareTo(rightArray[rightIndex]) <= 0)
            {
                array[currentIndex] = leftArray[leftIndex];
                leftIndex++;
            }
            else
            {
                array[currentIndex] = rightArray[rightIndex];
                rightIndex++;
            }
            currentIndex++;
        }


        while (leftIndex < leftArray.length) array[currentIndex++] = leftArray[leftIndex++];

        while (rightIndex < rightArray.length) array[currentIndex++] = rightArray[rightIndex++];
    }

    @Override
    public T get(int index) {
        return (T) elements[index];
    }


    @Override
    public Iterator<T> iterator() {
        return new ArrayItertor<>(elements);
    }
}


