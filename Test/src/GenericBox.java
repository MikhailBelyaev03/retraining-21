class Box<T> {
    private T inside;
    public void getInside(){
        System.out.println(inside);
    }

    public Box(T inside) {
        this.inside = inside;
    }
}
class Candy{
    private String name;
    private String producer;

    public String getName() {
        return name;
    }

    public Candy(String name, String producer) {
        this.name = name;
        this.producer = producer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
public class GenericBox{
    public static void main(String[] args) {
        Candy candy = new Candy("Owl","Red");
        Box<Candy> box = new Box<>(candy);
        box.getInside();
    }
}
