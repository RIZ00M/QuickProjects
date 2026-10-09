public interface BagInterface<T> {
    int getCurrentSize();
    boolean isEmpty();
    boolean addNewEntry(T newEntry);
    T remove();
    boolean remove(T anEntry);
    void clear();
    int getFrequencyOf(T anEntry);
    boolean contains(T anEntry);
    T[] toArray();
}
