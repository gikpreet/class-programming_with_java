@FunctionalInterface
public interface BinaryOp {
    int apply(int i, int j);
}

class Algorithm {
    static BinaryOp Adder = (i, j) -> i * j;

    static BinaryOp multiplier = new BinaryOp() {
        public int apply(int i, int j) {
            return i * j;
        }
    };

    public static int calc(BinaryOp binder, int start, int end, int step, int init) {
        int result = init;
        for (int i = start; i <= end; i += step) {
            result = binder.apply(result, i);
        }
        return result;
    }

    public static int sigma(int start, int end, int step) {
        return calc(Adder, start, end, step, 0);
    }

    public static int pi(int start, int end, int step) {
        return calc(multiplier, start, end, step, 1);
    }
}

class Test {
    public static void main(String[] args) {
        System.out.println(Algorithm.sigma(1, 10, 1));
        System.out.println(Algorithm.pi(1, 10, 1));
    }
}