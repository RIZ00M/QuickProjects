import java.util.Arrays;

public class BagTest {

    public static void main(String[] args) {
        System.out.println("=== ARRAY BAG ===");
        testBag(new ArrayBag<String>());

        System.out.println("\n=== LINKED BAG ===");
        testBag(new LinkedBag<String>());
    }

    private static void testBag(BagInterface<String> bag) {
        System.out.println("Add Alice: " + bag.addNewEntry("Alice"));
        System.out.println("Add Bob: " + bag.addNewEntry("Bob"));
        System.out.println("Add Alice again: " + bag.addNewEntry("Alice"));

        System.out.println("Entries: " + Arrays.toString(bag.toArray()));
        System.out.println("Size: " + bag.getCurrentSize());
        System.out.println("Is empty: " + bag.isEmpty());
        System.out.println("Contains Bob: " + bag.contains("Bob"));
        System.out.println("Contains Sam: " + bag.contains("Sam"));
        System.out.println("Frequency of Alice: " + bag.getFrequencyOf("Alice"));

        System.out.println("Remove Bob: " + bag.remove("Bob"));
        System.out.println("Entries after removing Bob: " + Arrays.toString(bag.toArray()));

        System.out.println("Remove one entry: " + bag.remove());
        System.out.println("Entries now: " + Arrays.toString(bag.toArray()));

        bag.clear();
        System.out.println("After clear, size: " + bag.getCurrentSize());
        System.out.println("After clear, is empty: " + bag.isEmpty());
    }
}
