import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestSecondTask {

    private int[] array;
    private boolean result;

    public TestSecondTask(int[] array, boolean result) {
        this.array = array;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 1, 4, 1, 4, 4, 4, 4}, true},
                {new int[]{1, 1, 1, 1, 1, 1,}, false},
                {new int[]{1, 4, 0, 0}, false}
        });
    }
    @Test
    public void testOnly1and4() {
        Assert.assertEquals(SecondTask.isOnlyOnesAndFoursInArray(array), result);
    }
}