package product;
import framework.*;

public class Cellphone implements Product {
    private int modelNumber;
    private String modelName;
    private String category;

    public Cellphone(int modelNumber, String modelName) {
        this.modelNumber = modelNumber;
        this.modelName = modelName;
    }

    public int getModelNumber() {
        return this.modelNumber;
    }

    public String getProductName() {
        return this.modelName;
    }

    public String getCategoryName() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    } 
}