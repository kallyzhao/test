import java.util.*;

public class Array {
    public static void main(String[] args) {
        List<Person> list = Arrays.asList(new Person("xiaokai",18),new Person("xiaohong",17),new Person("xiaoli",20));
        Map<String , Person> map = new TreeMap<>();
        for (Person p :list){
            map.put(p.getName(),p);
        }
        for (String key : map.keySet()){
            System.out.println(map.get(key));
        }
        System.out.println(map.get("xiaokai"));
        List<Person> list1 = new ArrayList<>();
       // List<String> list2 =removeDuplicate(list1);

        list1.add(new Person("xiaoming",18));
        list1.add(new Person("xiaohong",16));
        System.out.println(list1);
        System.out.println(list1.contains(new Person("xiaoming",18)));
    }
    static List<String> removeDuplicate(List<String> list) {
        Set<String> set = new TreeSet<String>(list);
        return new ArrayList<String>(set);
    }
}
