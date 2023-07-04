import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackArray<T> implements Iterable<T> {
    T[] s;
    int N;
    int size;

    public StackArray() {
        s = (T[]) new Object[1]; // TODO
        N = -1;
        size = 0;
    }

    public void push(T item) {
        if (s[s.length - 1] != null) {
            T[] newS = (T[]) new Object[s.length * 2];
            for (int i = 0; i < s.length; i++) {
                newS[i] = s[i];
            }
            s = newS;
            s[++N] = item;
            size = size + 1;
        }
        else {
            s[++N] = item;
            size = size + 1;
        }
    }

    public T pop() {
        if (N > 0 && N == s.length / 4) {
            T[] copy = (T[]) new Object[s.length / 2];
            for (int i = 0; i < copy.length; i++) {
                copy[i] = s[i];
            }
            s = copy;
        }

        if (N == -1) {
            throw new NoSuchElementException("Empty!");
        }
        else {
            T item = s[N];
            s[N] = null;
            N = N - 1;
            size = size - 1;
            return item;
        }
    }

    public boolean isEmpty() {
        return N == -1;
    }

    public int getLength() {
        return size;
    }


    // Iterator
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<T> {
        public int temp = 0;

        public boolean hasNext() {
            return temp != N + 1;
        }

        public T next() {
            if (hasNext()) {
                T item = s[temp];
                temp = temp + 1;
                return item;
            }
            else {
                throw new NoSuchElementException("No value to read!");
            }
        }
    }

    public static void main(String[] args) {
        // Test client
        StackArray<String> gryffindor = new StackArray<String>();
        while (!StdIn.isEmpty()) {
            String name = StdIn.readString();
            if (name.equals("-")) {
                StdOut.print(gryffindor.pop() + " ");
            }
            else {
                gryffindor.push(name);
            }
        }

        for (String name : gryffindor) {
            StdOut.println(name);
        }

    }
}
