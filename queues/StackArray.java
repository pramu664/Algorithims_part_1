import java.util.NoSuchElementException;

public class StackArray {
    String[] s;
    int N;

    public StackArray() {
        s = new String[1];
        N = -1;
    }

    public void push(String item) {
        if (s[s.length - 1] != null) {
            String[] newS = new String[s.length * 2];
            for (int i = 0; i < s.length; i++) {
                newS[i] = s[i];
            }
            s = newS;
            s[++N] = item;
        }
        else {
            s[++N] = item;
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
            return item;
        }
    }

    public static void main(String[] args) {
        // Test client
        StackArray gryffindor = new StackArray();
        gryffindor.push("Harry");
        gryffindor.push("Hermione");
        gryffindor.push("Ron");
        gryffindor.push("fred");
        gryffindor.push("George");

        gryffindor.pop();
        gryffindor.pop();
        gryffindor.pop();
        gryffindor.pop();
        gryffindor.pop();
        gryffindor.pop();
    }
}
