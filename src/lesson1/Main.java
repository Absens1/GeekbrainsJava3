package lesson1;

import java.util.Arrays;
import java.util.List;
import lesson1.storage.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("-----------------Task1-----------------");
        startFirstTask();
        System.out.println("\n-----------------Task2-----------------");
        startSecondTask();
        System.out.println("\n-----------------Task3-----------------");
        startThirdTask();
    }

    public static void startFirstTask() {
        Integer[] intArray = {1, 2, 3, 4, 5};
        String[] strArray = {"one","two","three","four","five"};
        System.out.println("Исходный целочисленный массив: " + Arrays.toString(intArray));
        System.out.println("Исходный строчный массив: " + Arrays.toString(strArray));
        System.out.println("Поменять два элемента 0 и 4 цел. массива: "
                + Arrays.toString(swapArrayElements(intArray,0,4)));
        System.out.println("Поменять два элемента 0 и 4 стр. массива: "
                + Arrays.toString(swapArrayElements(strArray,0,4)));
    }

    public static void startSecondTask() {
        Integer[] intArray = {1, 2, 3, 4, 5};
        System.out.println("Конвертация из массива в список!\nРезультат: " + convertArrayToList(intArray));
    }

    public static void startThirdTask() {
        Box<Apple> appleBox = new Box<>(new Apple(), new Apple(), new Apple());
        Box<Apple> appleBox2 = new Box<>();
        Box<Orange> orangeBox = new Box<>(new Orange(), new Orange(), new Orange());
        System.out.println("Вес коробки с апельсинами: " + orangeBox.getWeight());
        System.out.println("Вес коробки с яблоками: " + appleBox.getWeight());
        System.out.println("Содержимое appleBox = orangeBox? " + appleBox.compare(orangeBox));
        appleBox.pourTo(appleBox2);
        System.out.println("> Пересыпаем из appleBox в appleBox2 яблоки!");
        System.out.println("Теперь appleBox весит: " + appleBox.getWeight() + ", а appleBox2: " + appleBox2.getWeight() + ".");
        System.out.println("> Добавляем в orangeBox 3 фрукта!");
        orangeBox.addFruit(new Orange(), 3);
        System.out.println("Теперь orangeBox весит: " + orangeBox.getWeight());
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