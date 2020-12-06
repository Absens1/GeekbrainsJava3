package lesson1.storage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box<T extends Fruit> {

    private ArrayList<T> fruitList;

    public Box(T...fruits) {
        fruitList = new ArrayList<>(Arrays.asList(fruits));
    }

    public boolean compare(Box box) {
        return Math.abs(getWeight() - box.getWeight()) < 0.0001;
    }

    public void pourTo(Box <T> box){
        box.fruitList.addAll(this.fruitList);
        this.fruitList.clear();
    }

    public void addFruit(T fruit, int amount) {
        for(int i = 0; i < amount; i++){
            fruitList.add(fruit);
        }
    }

    public int getWeight() {
        int weight = 0;
        for(T fruit : fruitList){
            weight += fruit.getWeight();
        }
        return weight;
    }
}
