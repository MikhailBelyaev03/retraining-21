import java.util.*;

public class SortedHashMapByKey {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(13, "f");
        map.put(45, "a");
        map.put(12, "b");
        map.put(5, "c");
        map.put(53, "d");
        map.put(109, "e");
        map.put(455, "f");
        map.put(2, "f");
        map = sortMap(map);
        System.out.println(map);
    }

    public static HashMap<Integer,String> sortMap(HashMap<Integer, String> map) {
        Comparator<Map.Entry<Integer,String>> comparator = new Comparator<Map.Entry<Integer, String>>() {
            @Override
            public int compare(Map.Entry<Integer, String> o1, Map.Entry<Integer, String> o2) {
                return o1.getKey()-o2.getKey();
            }
        };
        Set<Map.Entry<Integer, String>> entry = map.entrySet();
        List<Map.Entry<Integer, String>> listT = new ArrayList<>(entry);
        Collections.sort(listT,comparator);

        LinkedHashMap<Integer,String> lm = new LinkedHashMap<>();
        for (Map.Entry<Integer,String> l :listT){
            lm.put(l.getKey(),l.getValue());
        }
    return lm;}
}