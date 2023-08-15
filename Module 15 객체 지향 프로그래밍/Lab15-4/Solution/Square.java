public class Square implements Shape {
    protected int length;

    public Square(int length) {
        this.length = length;
    }

    public int width() {
        return this.length;
    }
    public int height() {
        return this.length;
    }
    protected void setWidth(int width) {
        this.length = width;
    }
    protected void setHeight(int height) {
        this.length = height;
    }
    public int getArea() {
        return this.length * this.length;
    }
}
