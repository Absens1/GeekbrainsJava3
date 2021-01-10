import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import Annotations.*;

public class Main {
    public static void main(String[] args) throws InstantiationException, InvocationTargetException, IllegalAccessException {
        Class c = TestClass.class;
        Object testObj = c.newInstance();
        ArrayList<Method> testList = new ArrayList<>();
        Method beforeMethod = null;
        Method afterMethod = null;
        for (Method o : c.getDeclaredMethods()) {
            if (o.isAnnotationPresent(Test.class)) {
                testList.add(o);
            }
            if (o.isAnnotationPresent(BeforeSuite.class)) {
                if (beforeMethod == null) beforeMethod = o;
                else throw new RuntimeException("BeforeSuite может быть только один!");
            }
            if (o.isAnnotationPresent(AfterSuite.class)) {
                if (afterMethod == null) afterMethod = o;
                else throw new RuntimeException("AfterSuite может быть только один!");
            }
            testList.sort((o1, o2) -> o2.getAnnotation(Test.class).priority()-o1.getAnnotation(Test.class).priority());
        }

        if (beforeMethod != null) beforeMethod.invoke(testObj, null);
        for (Method o : testList) o.invoke(testObj, null);
        if (afterMethod != null) afterMethod.invoke(testObj, null);
    }
}
