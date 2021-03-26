import java.util.ArrayList;
import java.util.List;

public class TestGenerics {
    public static void main(String[] args) {
        // removeItemFromList();
        // removeItemFromList();

        List names = new ArrayList();
        names.add("Vitya");
        names.add(new StringBuilder("Vera"));
        printNames(names);
    }

    static void removeItemFromList() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(new Integer(1));
        list.add(new Integer(2));
        list.remove(1);
        System.out.println(list);
    }

    static void printNames(List list){
        for (int i = 0; i< list.size(); i++){
            System.out.println((String)list.get(i));
        }
    }
}
