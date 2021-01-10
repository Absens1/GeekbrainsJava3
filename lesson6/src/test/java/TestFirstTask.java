import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestFirstTask {

    private int[] original;
    private int[] afterFour;

    public TestFirstTask(int[] original, int[] afterFour) {
        this.original = original;
        this.afterFour = afterFour;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, -5, 10, 22, 4, 0, 12}, new int[]{0, 12}},
                {new int[]{0, 4, 9, 3}, new int[]{9, 3}}
        });
    }


    @Test
    public void testAfterLast4() {
        Assert.assertArrayEquals(afterFour, FirstTask.arrayAfterFour(original));
    }

    @Test(expected = RuntimeException.class)
    public void testAfterLast4Ex() {
        FirstTask.arrayAfterFour(new int[]{0, 8, -6, 33});
    }
}