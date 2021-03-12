import java.util.*;

public class BuiltInLinkedList {

    public static void main(String[] args) {
        // create a LinkedList as a List Interface Data Type

        List<Integer> list = new LinkedList<>();
        list.add(33); // Index 0
        list.add(17); // 1
        list.add(88); // 2
        list.add(98); // 3

        System.out.println(list.toString());

        list.add(0, 101);
        System.out.println(list);
    }


}
