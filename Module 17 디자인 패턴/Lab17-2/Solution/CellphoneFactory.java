package factory;
import framework.*;
import product.*;

public class CellphoneFactory extends Factory {
    protected Product create(int modelNumber, String modelName) {
        Product product = new Cellphone(modelNumber, modelName);
        return product;
    }

    protected void setCategory(Product product) {
        product.setCategory("Mobile Device");
    }
}