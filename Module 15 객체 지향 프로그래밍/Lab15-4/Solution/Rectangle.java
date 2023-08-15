public class Rectangle implements Shape {
    protected int width;
    protected int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int width() {
        return this.width;
    }
    public int height() {
        return this.height;
    }
    protected void setWidth(int width) {
        this.width = width;
    }
    protected void setHeight(int height) {
        this.height = height;
    }
    public int getArea() {
        return this.width * this.height;
    }
}
