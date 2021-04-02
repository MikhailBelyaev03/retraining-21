import java.util.*;

public class Human {
    private String FullName;
    private int age;
    private Address address;

    @Override
    public String toString() {
        return "\n" + "Human{" +
                "FullName='" + FullName + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human)) return false;
        Human human = (Human) o;
        return age == human.age && FullName.equals(human.FullName) && Objects.equals(address, human.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(FullName, age, address);
    }

    public Human(String fullName, int age, Address address) {
        FullName = fullName;
        this.age = age;
        this.address = address;
    }

    public static void main(String[] args) {
        Human human1 = new Human("Василий Иванович Петров", 34, new Address("Москва", "ул.Ленина", "34а", 156));
        Human human2 = new Human("Иван Иванович Носов", 45, new Address("Москва", "ул.Кулибина", "13", 45));
        Human human3 = new Human("Юрий Владимирович Пастухов", 16, new Address("Москва", "ул.Льва Толстого", "8", 78));
        Human human4 = new Human("Олег Юрьевич Кузьмин", 33, new Address("Уфа", "ул.Ленина", "8а", 25));
        Human human5 = new Human("Олег Юрьевич Кузьмин", 33, new Address("Уфа", "ул.Ленина", "8а", 25));
        Human human6 = new Human("Василий Иванович Петров", 34, new Address("Москва", "ул.Ленина", "34а", 156));
        Human human7 = new Human("Олег Юрьвич Пономаренко", 56, new Address("Тольятти", "ул.Карбышева", "14", 48));
        Human human8 = new Human("Олег Юрьвич Пономаренко", 56, new Address("Тольятти", "ул.Карбышева", "14", 48));
        Human human9 = new Human("Василий Иванович Супрун", 34, new Address("Москва", "ул.Ленина", "34а", 14));
        Human human10 = new Human("Василий Иванович Латышев", 34, new Address("Москва", "ул.Ленина", "34а", 152));

        ArrayList<Human> list = new ArrayList<>();
        list.add(human1);
        list.add(human2);
        list.add(human3);
        list.add(human4);
        list.add(human5);
        list.add(human6);
        list.add(human7);
        list.add(human8);
        list.add(human9);
        list.add(human10);

        findDuplicates(list);
        deleteDuplicates(list);

        Comparator<Human> sortByName = new Comparator<>() {
            @Override
            public int compare(Human o1, Human o2) {
                return o1.getFullName().compareTo(o2.getFullName());
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        };
        Collections.sort(list, sortByName);
        System.out.println("Sorted by Name");
        System.out.println(list);
        Comparator<Human> sortByAge = new Comparator<>() {
            @Override
            public int compare(Human o1, Human o2) {
                return o1.getAge() - o2.getAge();
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        };
        Collections.sort(list, sortByAge);
        System.out.println("Sorted by Age");
        System.out.println(list);

        Collections.sort(list, Comparator
                .comparing((Human h) -> h.getAddress().getCity())
                .thenComparing((Human h) -> h.getAddress().getStreet())
                .thenComparing((Human h) -> h.getAddress().getHouse())
                .thenComparing((Human h) -> h.getAddress().getApartment()));

        System.out.println("Sorted by Address");
        System.out.println(list);
    }

    public static void findDuplicates(ArrayList<Human> list) {
        Map<Human, ArrayList<Integer>> indexes = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            ArrayList<Integer> ind = new ArrayList<>();
            if (indexes.containsKey(list.get(i)) == true) {
                ind = indexes.get(list.get(i));
            }
            ind.add(i);
            for (int j = i; j < list.size(); j++) {
                if ((!(ind.contains(j))) && (!(ind.contains(i))) && ((list.get(i).equals(list.get(j)))) && (i != j)) {
                    ind.add(j);

                }
            }
            indexes.put(list.get(i), ind);
        }
        for (Map.Entry<Human, ArrayList<Integer>> item : indexes.entrySet()) {
            if (item.getValue().size() > 1) {
                System.out.println("Find a duplicate in position: " + item.getKey() + ", " + ": " + item.getValue());
            }
        }

    }
    public static ArrayList<Human> deleteDuplicates(ArrayList<Human> list) {
        Map<Human, ArrayList<Integer>> indexes = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = i; j < list.size(); j++) {
                if ((list.get(i).equals(list.get(j))) && (i != j)) {
                    list.remove(j);
                }
            }
        }
        return list;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}