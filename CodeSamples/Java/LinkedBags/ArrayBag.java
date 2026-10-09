import java.util.Arrays;
import java.util.Objects;

public class ArrayBag<T> implements BagInterface<T> {

    private static final int CAPACITY = 25;

    private final Object[] bag;
    private int numberOfEntries;

    public ArrayBag() {
        bag = new Object[CAPACITY];
        numberOfEntries = 0;
    }

    public int getCurrentSize() {
        return numberOfEntries;
    }

    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    public boolean addNewEntry(T newEntry) {
        if (numberOfEntries == bag.length) {
            return false;
        }

        bag[numberOfEntries] = newEntry;
        numberOfEntries++;
        return true;
    }

    public T[] toArray() {
        // The interface uses T[], so copy entries into an Object[] cast to T[].
        return (T[]) Arrays.copyOf(bag, numberOfEntries, Object[].class);
    }

    public T remove() {
        if (isEmpty()) {
            return null;
        }

        T removed = (T) bag[numberOfEntries - 1];
        bag[numberOfEntries - 1] = null;
        numberOfEntries--;
        return removed;
    }

    public boolean remove(T anEntry) {
        for (int i = 0; i < numberOfEntries; i++) {
            if (Objects.equals(bag[i], anEntry)) {
                bag[i] = bag[numberOfEntries - 1];
                bag[numberOfEntries - 1] = null;
                numberOfEntries--;
                return true;
            }
        }
        return false;
    }


    public void clear() {
        while (!isEmpty()) {
            remove();
        }
    }

    public int getFrequencyOf(T anEntry) {
        int count = 0;

        for (int i = 0; i < numberOfEntries; i++) {
            if (Objects.equals(bag[i], anEntry)) {
                count++;
            }
        }
        return count;
    }

    public boolean contains(T anEntry) {
        for (int i = 0; i < numberOfEntries; i++) {
            if (Objects.equals(bag[i], anEntry)) {
                return true;
            }
        }
        return false;
    }
}
