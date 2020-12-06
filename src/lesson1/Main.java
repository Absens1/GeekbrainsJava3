package lesson1;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5};
        String[] strArray = {"one","two","three","four","five"};
        System.out.println(Arrays.toString(swapArrayElements(intArray,0,4)));
        System.out.println(Arrays.toString(swapArrayElements(strArray,0,4)));
        System.out.println(convertArrayToList(intArray));
    }

    public static <T> List<T> convertArrayToList(T[] array) {
        return Arrays.asList(array);
    }

    public static <T> T[] swapArrayElements(T[] array, int firstIndex, int secondIndex) {
        T firstValue = array[firstIndex];
        T secondValue = array[secondIndex];
        array[firstIndex] = secondValue;
        array[secondIndex] = firstValue;
        return array;
    }
}