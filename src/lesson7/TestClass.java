package lesson7;

import lesson7.Annotations.*;

public class TestClass {

    @BeforeSuite
    public void init() {
        System.out.println("Start testing");
    }

    @Test(priority = 0)
    public void test1() {
        System.out.println("Start test1");
    }

    @Test(priority = 8)
    public void test2() {
        System.out.println("Start test2");
    }

    @Test(priority = 9)
    public void test3() {
        System.out.println("Start test3");
    }

    @Test(priority = 11)
    public void test4() {
        System.out.println("Start test4");
    }

    @AfterSuite
    public void stop() {
        System.out.println("Test completion");
    }

}
