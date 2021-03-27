import java.util.ArrayList;
import java.util.List;

interface Flyable {
    public void fly();
}

class Duck implements Flyable {
    public void fly() {
    }
}

public class GenericDuck {
    public void anyFly(List<Flyable> list) {
    }

    public void groupFly(List<? extends Flyable> list) {
    }

    public static void main(String[] args) {
        List<Duck> duckList = new ArrayList<>();
        List<Flyable> flyableList = new ArrayList<>();
        new GenericDuck().groupFly(duckList);
        new GenericDuck().groupFly(flyableList);
        //doesnt compile
        //   new GenericDuck().anyFly(duckList);
        new GenericDuck().anyFly(flyableList);
    }

}
