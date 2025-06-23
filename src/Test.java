public class Test {
    public static void main(String[] args) {
        MyHashMap<String, Integer> hMap = new MyHashMap<>();

        hMap.put("one", 1);
        hMap.put("two", 2);
        hMap.put("three", 3);

        System.out.println(hMap.get("two"));
        System.out.println(hMap.remove("two"));
        System.out.println(hMap.get("two"));
    }
}
