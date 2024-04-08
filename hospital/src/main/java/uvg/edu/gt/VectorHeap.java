package uvg.edu.gt;

import java.util.AbstractQueue;
import java.util.Comparator;
import java.util.Iterator;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @param <E> seran los elementos de la lista
 */

public class VectorHeap<E extends Comparable<E>> extends AbstractQueue<E> implements Queue<E> {
    private PriorityQueue<E> heap;
    private Comparator<E> comparator;

    public VectorHeap() {
        this.heap = new PriorityQueue<>();
        this.comparator = (e1, e2) -> e1.compareTo(e2);
    }

    /**
     * Crea un comparador para los paramentros dados
     * @param comparator
     */
    public VectorHeap(Comparator<E> comparator) {
        this.heap = new PriorityQueue<>(comparator);
        this.comparator = comparator;
    }

    /**
     * Inserta paramentros en diferentes elementos
     * @param elements
     */
    public VectorHeap(E[] elements) {
        this.heap = new PriorityQueue<>();
        this.comparator = (e1, e2) -> e1.compareTo(e2);
        for (E element : elements) {
            this.add(element);
        }
    }

    /**
     * Finalmente ordena la lista
     * @param elements
     * @param comparator
     */
    public VectorHeap(E[] elements, Comparator<E> comparator) {
        this.heap = new PriorityQueue<>(comparator);
        this.comparator = comparator;
        for (E element : elements) {
            this.add(element);
        }
    }

    @Override
    public boolean add(E e) {
        return heap.add(e);
    }

    @Override
    public boolean offer(E e) {
        return heap.offer(e);
    }

    @Override
    public E peek() {
        return heap.peek();
    }

    @Override
    public E poll() {
        return heap.poll();
    }

    @Override
    public int size() {
        return heap.size();
    }

    @Override
    public Iterator<E> iterator() {
        return heap.iterator();
    }
}