public class Test {
    public static void main(String[] args) {
        Rectangle rectangle = new Square();
        rectangle.setWidth(10);
        rectangle.setHeight(5);

        System.out.println(rectangle.getArea()); 
    }
}
