import java.util.LinkedList;

public class PrintedLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add( (int) (Math.random()*100));
        list.add( (int) (Math.random()*100));
        list.add( (int) (Math.random()*100));
        list.add( (int) (Math.random()*100));
        list.add( (int) (Math.random()*100));
        list.add( (int) (Math.random()*100));
        list.add( (int) (Math.random()*100));
        for (int i=0;i<list.size();i++){
            System.out.println("Value: "+list.get(i)+"; index: "+i);
        }
    }
}
