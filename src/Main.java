import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        ArrList<Integer> integerArrList = new ArrListImpl<>();
        integerArrList.add(2);
        integerArrList.add(6);
        integerArrList.add(12);
        integerArrList.add(2);
        integerArrList.add(81);

        integerArrList.delete(12);

        integerArrList.mergeSort(integerArrList.get(), 0, integerArrList.length() - 1);

        System.out.println(Arrays.toString(integerArrList.get()));

        System.out.println(integerArrList.get(2));

    }
}
