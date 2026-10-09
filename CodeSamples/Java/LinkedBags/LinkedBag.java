import java.util.Objects;

public class LinkedBag<T> implements BagInterface<T> {

    private Node firstNode;
    private int numberOfEntries;

    private class Node {
        private T data;
        private Node next;

        private Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public LinkedBag() {
        firstNode = null;
        numberOfEntries = 0;
    }

    public int getCurrentSize() {
        return numberOfEntries;
    }

    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    public boolean addNewEntry(T newEntry) {
        firstNode = new Node(newEntry, firstNode);
        numberOfEntries++;
        return true;
    }


    public T[] toArray() {
        Object[] result = new Object[numberOfEntries];
        Node current = firstNode;
        int i = 0;

        while (current != null) {
            result[i] = current.data;
            current = current.next;
            i++;
        }

        return (T[]) result;
    }

    public T remove() {
        if (isEmpty()) {
            return null;
        }

        T removed = firstNode.data;
        firstNode = firstNode.next;
        numberOfEntries--;
        return removed;
    }

    public boolean remove(T anEntry) {
        Node current = firstNode;
        Node previous = null;

        while (current != null) {
            if (Objects.equals(current.data, anEntry)) {
                if (previous == null) {
                    firstNode = current.next;
                } else {
                    previous.next = current.next;
                }

                numberOfEntries--;
                return true;
            }

            previous = current;
            current = current.next;
        }

        return false;
    }

    public void clear() {
        firstNode = null;
        numberOfEntries = 0;
    }

    public int getFrequencyOf(T anEntry) {
        int count = 0;
        Node current = firstNode;

        while (current != null) {
            if (Objects.equals(current.data, anEntry)) {
                count++;
            }
            current = current.next;
        }

        return count;
    }

    public boolean contains(T anEntry) {
        Node current = firstNode;

        while (current != null) {
            if (Objects.equals(current.data, anEntry)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }
}
