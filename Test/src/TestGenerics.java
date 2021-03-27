import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface Flying<T> {
    public void fly(T t);
}

//1 option - implement interface
class TestFlying implements Flying<Integer> {
    public void fly(Integer i) {
    }
}

//2 option - make Generic class
//You cannot use the same letter!
class TestFlying2<U> implements Flying<U> {
    public void fly(U u) {
    }
}

//3 options - dont use generic
class TestFlying3 implements Flying {
    public void fly(Object o) {
    }
}

public class TestGenerics {
    public static void main(String[] args) {
        // removeItemFromList();
        //testArrayCollection();

//        List names = new ArrayList();
//        names.add("Vitya");
//        names.add(new StringBuilder("Vera"));
//        printNames(names);


        //not in a pointed list
        //        List list = new ArrayList<>();
//        list.add(1);
//        int a = list.get(0);
//        System.out.println(a);

        //in a pointed list
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        //Autoconvert autobox to primitive
//        int a = list.get(0);
//        System.out.println(a);

//        MyArrayList<String> arr = new MyArrayList<String>();
//        arr.addItem("one");
//        arr.addItem("two");
//        arr.addItem("three");
//        arr.addItem("four");
//        arr.addItem("five");
//        arr.addItem("six");
//        arr.addItem("seven");
//        arr.addItem("eight");
//        System.out.println(arr.toString());

//        MyArrayList<Integer> arr = new MyArrayList<Integer>();
//        arr.addItem(1);
//        arr.addItem(2);
//        arr.addItem(3);
//        arr.addItem(4);
//        arr.addItem(5);
//        arr.addItem(6);
//        arr.addItem(7);
//        arr.addItem(8);
//        System.out.println(arr.toString());

//        TwoGeneric<String,Integer> test = new TwoGeneric<>("Hello",0);
//        System.out.println(test);

        //generic method
//        printFun(1);
//        printFun("!!!");
//        printFun('&');

        //Wildcards
        //Unbounded
        List<?> l = new ArrayList<String>();
        //Upper bound
        List<? extends Exception> r = new ArrayList<RuntimeException>();
        //Lower bound
        List<? super Exception> t = new ArrayList<Object>();

        //List of whatever
//        List<String> k = new ArrayList<>();
//        k.add("Two");
//        printList(k);

        //Upper  = immutable
        ArrayList<? extends Number> list = new ArrayList<Integer>();

        //You cannot change upperbounded list
//        ArrayList<? extends Number> e = new ArrayList<Number>();
//        e.add(new Integer(1));

        //List with ? == immutable
//        List <? extends Object> d = new ArrayList<Integer>();
//        d.add(4);
//        d.add("C");
//        int sum = 0;
//        for (int x=0;x<d.size();x++){
//            sum+=d.get(x);
//        }

        //Wildcards always stay at right
       // List<?> list2 = new ArrayList<? extends Number>();
    }

    public static void printList(List<?> list) {
        for (Object l : list) {
            System.out.println(l);
        }
    }

    static <T> void printFun(T t) {
        System.out.println("Fun " + t.toString());
    }

    static void removeItemFromList() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(new Integer(1));
        list.add(new Integer(2));
        list.remove(1);
        System.out.println(list);
    }

    static void printNames(List list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println((String) list.get(i));
        }
    }

    static void testArrayCollection() {
        String[] arr = {"one", "two"};
        List<String> list = Arrays.asList(arr);
        list.set(0, "three");
        System.out.println(list);
        arr[1] = "test";
        System.out.println(list);
        String[] arr2 = (String[]) list.toArray();
        list.remove(1);
    }
}

class MyArrayList<T> {
    private int currElement;
    private T[] arr;

    public MyArrayList() {
        this.currElement = 0;
        this.arr = (T[]) new Object[5];
    }

    public void addItem(T item) {
        if (currElement == arr.length) {
            T[] copyArr = Arrays.copyOf(arr, arr.length + arr.length / 2);
            arr = copyArr;
        }
        arr[currElement] = item;
        currElement = currElement + 1;
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "arr=" + Arrays.toString(arr) +
                '}';
    }
}

class TwoGeneric<T, U> {
    private T first;
    private U second;

    public TwoGeneric(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public U getSecond() {
        return second;
    }

    public void setSecond(U second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return "TwoGeneric{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}