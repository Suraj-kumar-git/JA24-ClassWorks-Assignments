package list.iterator;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class IteratorList{

    public static void main(String[] args) {
        // Creating an ArrayList
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Mango");

        // Obtaining a ListIterator from the ArrayList
        ListIterator<String> iterator = fruits.listIterator();

        // Forward iteration
        System.out.println("Forward Iteration:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Backward iteration
        System.out.println("\nBackward Iteration:");
        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }

        // Modifying the list during iteration
        System.out.println("\nModified List:");
        while (iterator.hasNext()) {
            String fruit = iterator.next();
            if (fruit.equals("Banana")) {
                // Modifying the list by replacing "Banana" with "Grapes"
                iterator.set("Grapes");
            }
            System.out.println(fruit);
        }
    }
}

