import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Optional;
import java.util.function.Predicate;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Exercises {
    static Map<Integer, Long> change(long amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        var counts = new HashMap<Integer, Long>();
        for (var denomination : List.of(25, 10, 5, 1)) {
            counts.put(denomination, amount / denomination);
            amount %= denomination;
        }
        return counts;
    }

    // Write your first then lower case function here
    public static Optional<String> firstThenLowerCase(List<String> a, Predicate<String> p) {
        return a.stream()
                .filter(p)
                .findFirst()
                .map(String::toLowerCase);
        // Create a stream from the list + Filter elements that satisfy the predicate + Get the first element that matches +Convert it to lowercase if present
    }

    // Write your say function here
static record Sayer(String phrase) {

        Sayer and(String word) {
            // word = "" --> add space
            if (word.isEmpty()) {
                return new Sayer(this.phrase + " ");
            }
            // phrase starts with no words --> add 1st word
            if (this.phrase.isEmpty()) {
                return new Sayer(word);
            }
            // add a space + new word to the already made phrase
            return new Sayer(this.phrase + " " + word);
        }
    }

    public static Sayer say() {
        return new Sayer ("");
    }

    public static Sayer say(String word) {
        return new Sayer(word);
    }
    
    // Write your line count function here
    public static int meaningfulLineCount(String filename) throws IOException {
        try (FileReader in = new FileReader(filename)) {
            BufferedReader br = new BufferedReader(in);
            return (int) br.lines()
                        .filter(line -> !line.trim().isEmpty())
                        .filter(line -> line.trim().charAt(0) != '#')
                        .count();
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("No such file");
        }
    }
}

// Write your Quaternion record class here
record Quaternion (double a, double b, double c, double d) {
    
    public final static Quaternion ZERO = new Quaternion(0,0,0,0);
    public final static Quaternion I = new Quaternion(0,1,0,0);
    public final static Quaternion J = new Quaternion(0,0,1,0);
    public final static Quaternion K = new Quaternion(0,0,0,1);

    public Quaternion {
        if (Double.isNaN(a) || Double.isNaN(b) || Double.isNaN(c) || Double.isNaN(d)) {
            throw new IllegalArgumentException("Coefficients cannot be NaN");
        }
    }
    
    Quaternion plus (Quaternion other) {
        return new Quaternion(a + other.a, b + other.b, c + other.c, d + other.d);
    }

    Quaternion times(Quaternion other) {
        return new Quaternion(
        a * other.a - b * other.b - c * other.c - d * other.d,
        a * other.b + b * other.a + c * other.d - d * other.c, 
        a * other.c - b * other.d + c * other.a + d * other.b,
        a * other.d + b * other.c - c * other.b + d * other.a);
    }
    
    public Quaternion conjugate() {
        return new Quaternion(a, -b, -c, -d);
    }

    public List<Double> coefficients() {
        return List.of(a,b,c,d);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        // Handle the real part (a)
        if (a != 0) {
            sb.append(a);
        }

        // Handle the imaginary part for i (b)
        if (b != 0) {
            if (b > 0 && sb.length() > 0) sb.append("+");
            if (b == 1) {
                sb.append("i");
            } else if (b == -1) {
                sb.append("-i");
            } else {
                sb.append(b).append("i");
            }
        }

        // Handle the imaginary part for j (c)
        if (c != 0) {
            if (c > 0 && sb.length() > 0) sb.append("+");
            if (c == 1) {
                sb.append("j");
            } else if (c == -1) {
                sb.append("-j");
            } else {
                sb.append(c).append("j");
            }
        }

        // Handle the imaginary part for k (d)
        if (d != 0) {
            if (d > 0 && sb.length() > 0) sb.append("+");
            if (d == 1) {
                sb.append("k");
            } else if (d == -1) {
                sb.append("-k");
            } else {
                sb.append(d).append("k");
            }
        }

        // Handle case where the quaternion is zero
        if (sb.length() == 0) {
            return "0"; // For the zero quaternion
        }

        return sb.toString();
}
}

// Write your BinarySearchTree sealed interface and its implementations here
