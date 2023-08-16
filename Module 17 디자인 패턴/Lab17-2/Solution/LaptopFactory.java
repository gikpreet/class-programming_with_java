package factory;
import framework.*;
import product.*;

public class LaptopFactory extends Factory {
    protected Product create(int modelNumber, String modelName) {
        Product product = new Laptop(modelNumber, modelName);
        return product;
    }

    protected void setCategory(Product product) {
        product.setCategory("Laptop");
    }
}
