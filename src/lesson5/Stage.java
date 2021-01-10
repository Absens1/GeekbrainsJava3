package lesson5;

abstract class Stage {
    protected int length;
    protected String description;
    public abstract void go(Car c);
}