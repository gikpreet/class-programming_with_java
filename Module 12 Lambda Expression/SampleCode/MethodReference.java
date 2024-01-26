interface BinaryOp {
    public int apply(int i, int j);
}

class Calc {
    public static int add(int i, int j) {
        return i + j;
    }

    public int mult(int i, int j) {
        return i * j;
    }
}

class Test {
    public static void main(String[] args) {
        BinaryOp adder = Calc::add;
        BinaryOp multer = new Calc()::mult;
        System.out.println(adder.apply(1, 2));
        System.out.println(multer.apply(2, 3));
    }
}