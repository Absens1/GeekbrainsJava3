public class SecondTask {
    public static boolean isOnlyOnesAndFoursInArray(int[] array) {
        boolean check1 = false;
        boolean check4 = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 4) { check1 = true; }
            else if (array[i] == 1) { check4 = true; }
            else return false;
        }
        return check1 && check4;
    }
}
