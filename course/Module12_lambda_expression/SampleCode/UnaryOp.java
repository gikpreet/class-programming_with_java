@FunctionalInterface
interface UnaryOp {
    public int apply(int a);
}

class Test {
    public static int getUnaryResult(UnaryOp binder, int input) {
        return binder.apply(input);
    }

    public static void main(String[] args) {
        // 익명 클래스
        UnaryOp unaryResult = new UnaryOp() {
            public int apply(int i) {
                return i + i;
            }
        };

        // 익명 클래스 형식 사용
        getUnaryResult(unaryResult, 1);

        // 람다 식 사용
        UnaryOp getUnaryResult = (int a) -> {return a + a;};

        getUnaryResult(getUnaryResult, 1);

        // 람다 식 직접 사용
        getUnaryResult((int a) -> {return a + a;}, 1);

        // 파라미터 타입 생략
        getUnaryResult((a) -> {return a + a;}, 1);

        // 파라미터가 하나인 경우 괄호 생략
        getUnaryResult(a -> {return a + a;}, 1);

        // 괄호가 생략된 수행문에 return 키워드가 없을 경우 return 생략
        getUnaryResult(a -> a + a, 1);
    }
}
