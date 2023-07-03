import java.util.NoSuchElementException;

public class StackArray {
    String[] s;
    int N;
    int size;

    public StackArray() {
        s = new String[1];
        N = -1;
        size = 0;
    }

    public void push(String item) {
        if (s[s.length - 1] != null) {
            String[] newS = new String[s.length * 2];
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

    public String pop() {
        if (N > 0 && N == s.length / 4) {
            String[] copy = new String[s.length / 2];
            for (int i = 0; i < copy.length; i++) {
                copy[i] = s[i];
            }
            s = copy;
        }

        if (N == -1) {
            throw new NoSuchElementException("Empty!");
        }
        else {
            String item = s[N];
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

    public static void main(String[] args) {
        // Test client
        StackArray gryffindor = new StackArray();
        boolean result0 = gryffindor.isEmpty();
        gryffindor.push("Harry");
        gryffindor.push("Hermione");
        gryffindor.push("Ron");
        gryffindor.push("fred");
        gryffindor.push("George");
        boolean result1 = gryffindor.isEmpty();
        int size = gryffindor.getLength();

        gryffindor.pop();
        gryffindor.pop();
        gryffindor.pop();
        gryffindor.pop();
        gryffindor.pop();
        gryffindor.pop();
    }
}
