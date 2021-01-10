import java.util.Arrays;

public class FirstTask {

    public static int[] arrayAfterFour(int[] array) throws RuntimeException {
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 4) {
                index = i;
            }
        }
        if (index != -1) { return Arrays.copyOfRange(array, index+1, array.length); }
        else {
            throw new RuntimeException("4 нет в массиве!");
        }
    }
}
